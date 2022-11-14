package dao;

import dto.Ingredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletContext;
import utils.DBUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.SortedList;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
public class IngredientDAO {

    public static String[] MEASUREMENTS = {"oz", "tbsp", "c", "g", "ml", "lb", "fl,oz", "l", "gram", "cup",
        "tablespoon", "teaspoon", "ounce", "pound", "liter", "pint", "gallon", "piece"};
    private static Connection conn = DBUtils.getConnection();

    private static final String SELECT_ALL_INGREDIENT = "SELECT [Name]"
            + "      ,[Img]"
            + "  FROM [dbo].[Ingredient] ";

    private static final String SELECT_INGREDIENT_BY_ID = SELECT_ALL_INGREDIENT + " WHERE [ID] = ?";

    /**
     * Get Ingredient by ID
     *
     * @param id the <b>id</b> of the <b>Ingredient</b>
     *
     * @return the Ingredient Object with the same <b>id</b> as the inputted
     * <b>id</b>
     */
    public static Ingredient getIngredientByID (int ID) throws SQLException {
        String sql = SELECT_INGREDIENT_BY_ID;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = DBUtils.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            //Set ps
            ps.setInt(1, ID);
            //run ps
            rs = ps.executeQuery();
            Ingredient ingredient = null;
            if (rs.next()) {
                ingredient = new Ingredient(rs.getString(1), rs.getString(2));
            }
            return ingredient;
        } catch (Exception e) {
            System.out.println("getIngredientByID error:");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
    private static final String SELECT_INGREDIENT_BY_NAME = SELECT_ALL_INGREDIENT
            + "  Where [Name] = ?";

    public static Ingredient getIngredientByName (String name) throws SQLException {
        String sql = SELECT_INGREDIENT_BY_NAME;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = DBUtils.getConnection();
        try {
            ps = conn.prepareStatement(sql);
            //Set ps
            ps.setString(1, name);
            //run ps
            rs = ps.executeQuery();
            Ingredient ingredient = null;
            if (rs.next()) {
                ingredient = new Ingredient(rs.getString(1), rs.getString(2));
            }
            System.out.println(ingredient + "a");
            return ingredient;
        } catch (Exception e) {
            System.out.println("getIngredientByID error:");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
    private static final String INSERT_INGREDIENT_RECIPE
            = "INSERT INTO [dbo].[IngredientRecipe]\n"
            + "           ([RecipeID]\n"
            + "           ,[IngredientID]\n"
            + "           ,[Amount])\n"
            + "     VALUES\n"
            + "           (?,?,?)";

    public static boolean addIngredientRecipe (String ingreName, String ingreAmount, int recipeId, Connection conn,
            ServletContext sc) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        String filename = null;
        try {
            //set sql
            conn.setAutoCommit(false);
            sql = INSERT_INGREDIENT_RECIPE;
            int ingreId = IngredientDAO.getIngredientIDByName(ingreName, conn);
            if (ingreId == -1) {
                ingreId = IngredientDAO.addIngredient(ingreName, conn);
            }

            ps = conn.prepareStatement(sql);
            ps.setInt(1, recipeId);
            ps.setInt(2, ingreId);
            ps.setString(3, ingreAmount.isEmpty() ? "1 Piece" : ingreAmount);
            if (ps.executeUpdate() > 0) {
                System.out.println("Added Ingrdient Recipe" + recipeId + " " + ingreId);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Add Ingredient Recipe Error" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return false;
    }

    public static boolean addIngredientsRecipe (String[] ingreNames, String[] ingreAmounts, int recipeId,
            Connection conn, ServletContext sc) throws SQLException {
        conn.setAutoCommit(false);
        if(ingreNames != null)
        for (int i = 0; i < ingreNames.length; i++) {
            addIngredientRecipe(ingreNames[i], ingreAmounts[i], recipeId, conn, sc);
        }
        return true;
    }
    private static final String LIST_INGREDIENT
            = "             select ingre.[ID],ingre.[Name],ingre.[Img],ingreRe.Amount\n"
            + "            from [dbo].[Ingredient] ingre join [dbo].[IngredientRecipe] ingreRe\n"
            + "            on ingre.ID =ingreRe.IngredientID\n"
            + "            join [dbo].[Recipe] re on ingreRe.RecipeID =re.ID\n"
            + "            where re.ID = ? ";

    public static List<Ingredient> getListIngredient (int recipeID) throws SQLException {
        List<Ingredient> listIgre = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(LIST_INGREDIENT);
            ptm.setInt(1, recipeID);
//            ptm.setString(2, des);
            rs = ptm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String img = rs.getString("Img");
                String amount = rs.getString("Amount");
                Ingredient sc;
                sc = new Ingredient(id, name, img, amount);
                listIgre.add(sc);
            }
        } catch (Exception e) {
            System.out.println("System have error !!!");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listIgre;

    }
    private static final String LIST_INGREDIENT_RECIPE
            = "SELECT i.[Name]\n"
            + "      ,[Img]\n"
            + "      ,ir.Amount\n"
            + "	  ,ir.IngredientID\n"
            + "      ,ir.RecipeID"
            + "  FROM [Ingredient] i \n"
            + "  join IngredientRecipe ir on ir.IngredientID=i.ID\n"
            + "  join Recipe r on ir.RecipeID = r.ID\n"
            + "  where RecipeID = ?";

    public static List<Ingredient> getListIngredientRecipe (int recipeID, Connection conn) throws SQLException {
        List<Ingredient> listIgre = new LinkedList<>();
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            ptm = conn.prepareStatement(LIST_INGREDIENT_RECIPE);
            ptm.setInt(1, recipeID);
            rs = ptm.executeQuery();
            Ingredient sc;
            while (rs.next()) {
                int id = rs.getInt("IngredientID");
                String name = rs.getString("Name");
                String img = rs.getString("Img");
                String amount = rs.getString("Amount");
                sc = new Ingredient(id, name, img, amount);
                listIgre.add(sc);
            }
        } catch (Exception e) {
            System.out.println("System have error !!!");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
        }
        System.out.println(listIgre);
        return listIgre;

    }
    private static final String SELECT_INGREDIENT_ID_BY_NAME = "SELECT ID\n"
            + "  FROM [Ingredient]\n"
            + "  WHERE [Name] = ?";

    public static int getIngredientIDByName (String name, Connection conn) throws SQLException {
        String sql = SELECT_INGREDIENT_ID_BY_NAME;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            //Set ps
            ps.setString(1, name);
            //run ps
            rs = ps.executeQuery();
            int id = -1;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            System.out.println(id);
            return id;
        } catch (Exception e) {
            System.out.println("getIngredientByID error:");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return -1;
    }
    private static final String ALL_INGREDIENT = "SELECT LOWER(Name) as Name\n"
            + " FROM Ingredient"
            + " WHERE Img is not null"
            + " ORDER BY LEN(NAME)";

    public static List<String> getAllIngredients () throws SQLException {
        List<String> list = new ArrayList<String>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(ALL_INGREDIENT);
            rs = ptm.executeQuery();
            int i = 0;
            while (rs.next()) {
                String name = rs.getString("Name");
                list.add(name);
            }
        } catch (Exception e) {
            System.out.println("getAllIngredients have error !!!");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public static HashMap<String, Integer> getAllIngredientsWithPoint () throws SQLException {
        String sql = "SELECT Name, Point\n"
                + "FROM Ingredient";
        HashMap<String, Integer> list = new HashMap<String, Integer>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Name");
                int point = rs.getInt("Point");
                list.put(name, point);
            }
        } catch (Exception e) {
            System.out.println("getAllIngredientsWithPoint have error !!!");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    private static final String ADD_INGREDIENT
            = "INSERT INTO [Ingredient]\n"
            + "           ([Name]\n"
            + "           ,[Img],[Point])\n"
            + "	OUTPUT inserted.ID,inserted.Name\n"
            + "     VALUES\n"
            + "           (?,?,?)";

    public static int addIngredient (String ingreName, Connection conn) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = ADD_INGREDIENT;
            ps = conn.prepareStatement(sql);
            ps.setString(1, ingreName.toLowerCase());
            ps.setString(2, null);
            ps.setInt(3, 0);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Added Ingredient " + rs.getString(2));
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, "addIngredient Error:", ex);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return -1;
    }

    /**
     * edit Ingredient name if old list larger than new list delete old list if
     * old list smaller than new list add more ingredients if index is equal
     * update it
     *
     * @param ingreName
     * @param ingreAmount
     * @param recipeId
     * @param conn
     * @param sc
     *
     * @return
     */
    static boolean updateIngredientsRecipe (String[] ingreName, String[] ingreAmount, int recipeId, Connection conn,
            ServletContext sc) throws SQLException {

        List<Ingredient> oldIngredientList = null;
        oldIngredientList = getListIngredientRecipe(recipeId, conn);
        int newSize = 0;
        if (ingreName != null) {
            newSize = ingreName.length;
        }
        int oldSize = oldIngredientList.size();
        int maxSize = Integer.max(newSize, oldSize);
        for (int i = 0; i < oldSize; i++) {
            Ingredient oldIngredient = oldIngredientList.get(i);
            deleteIngredientRecipe(oldIngredient.getId(), recipeId, conn);
        }
        for (int i = 0; i < newSize; i++) {

            Ingredient oldIngredient = null;
            if (i < oldSize) {
                oldIngredient = oldIngredientList.get(i);
            }

//            if (i < newSize && i < oldSize) {//update ingredient
//                System.out.println(newSize + " " + oldSize);
//                if (oldIngredient.getName() == ingreName[i] && oldIngredient.getAmount() == ingreAmount[i])
//                    continue;// if it's the same then continue
//                updateIngredientRecipe(ingreName[i], ingreAmount[i], recipeId, oldIngredient.getId(), conn);
//            }
//            if (i < newSize && i >= oldSize) { //add ingredient
            addIngredientRecipe(ingreName[i], ingreAmount[i], recipeId, conn, sc);
//            }
//            if (i >= newSize && i < oldSize) { //delete ingredient
//                deleteIngredientRecipe(oldIngredient.getId(), recipeId, conn);
//            }

        }

        return true;
    }
    private static final String UPDATE_INGREDIENT_RECIPE
            = " UPDATE IngredientRecipe\n"
            + " SET IngredientID = ? , [Amount] = ?\n"
            + " WHERE IngredientID = ? and RecipeID = ?";

    private static boolean updateIngredientRecipe (String ingreName, String ingreAmount, int recipeId, int ingreId,
            Connection conn) throws SQLException {
        String sql = UPDATE_INGREDIENT_RECIPE;
        PreparedStatement ps = null;
        int newID = -1;
        try {
            ps = conn.prepareStatement(sql);
            newID = IngredientDAO.getIngredientIDByName(ingreName, conn);
            if (newID == -1) {
                newID = IngredientDAO.addIngredient(ingreName, conn);
            }
            ps.setInt(1, newID);
            ps.setString(2, ingreAmount);
            ps.setInt(3, ingreId);
            ps.setInt(4, recipeId);
            System.out.println(newID + " " + ingreAmount + " " + ingreId + " " + recipeId);
            ps.executeUpdate();
            System.out.println("Updated Ingredient Recipe" + newID + " " + ingreName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return false;
    }

    private static final String DELETE_INGREDIENT_RECIPE
            = "DELETE FROM [IngredientRecipe]\n"
            + "      WHERE IngredientID = ? and RecipeID = ?";

    private static boolean deleteIngredientRecipe (int ingreId, int recipeId, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(DELETE_INGREDIENT_RECIPE);
            ps.setInt(1, ingreId);
            ps.setInt(2, recipeId);
            if (ps.executeUpdate() == 1) {
                System.out.println("DELETED Ingredient Recipe " + ingreId);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                ps.close();
        }
        return false;
    }
}
