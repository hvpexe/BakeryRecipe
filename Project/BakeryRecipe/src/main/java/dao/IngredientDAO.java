package dao;

import dto.Ingredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import utils.DBUtils;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class IngredientDAO {

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
            int ingreId = IngredientDAO.getIngredientIDByName(ingreName);
            if (ingreId == -1) {
                ingreId = IngredientDAO.addIngredient(ingreName, conn);
            }
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println(recipeId + " " + ingreId);
            ps = conn.prepareStatement(sql);
            ps.setInt(1, recipeId);
            ps.setInt(2, ingreId);
            ps.setString(3, ingreAmount);
            ps.executeUpdate();
            return false;
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
            Connection conn,
            ServletContext sc) throws SQLException {
        conn.setAutoCommit(false);
        for (int i = 0; i < ingreNames.length; i++) {
            addIngredientRecipe(ingreNames[i], ingreAmounts[i], recipeId, conn, sc);
        }
        return true;
    }
    private static final String LIST_INGREDIENT = "select ingre.[ID],ingre.[Name],ingre.[Img],ingreRe.Amount\n"
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

    private static final String SELECT_INGREDIENT_ID_BY_NAME = "SELECT ID\n"
            + "  FROM [BakeryRecipe].[dbo].[Ingredient]\n"
            + "  WHERE [Name] = ?";

    public static int getIngredientIDByName (String name) throws SQLException {
        String sql = SELECT_INGREDIENT_ID_BY_NAME;
        Connection conn = null;
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
            if (conn != null) {
                conn.close();
            }
        }
        return -1;
    }
    private static final String ALL_INGREDIENT = "SELECT Name\n"
            + "FROM Ingredient";

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
            = "INSERT INTO [dbo].[Ingredient]\n"
            + "           ([Name]\n"
            + "           ,[Img])\n"
            + "	OUTPUT inserted.ID\n"
            + "     VALUES\n"
            + "           (?,?)";

    public static int addIngredient (String ingreName, Connection conn) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = ADD_INGREDIENT;
            ps = conn.prepareStatement(sql);
            ps.setString(1, ingreName);
            ps.setString(2, null);
            rs = ps.executeQuery();
            if (rs.next()) {
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
        List<Ingredient> oldIngredientList = getListIngredient(recipeId);
        int newSize = 0;
        if (ingreName != null) {
            newSize = ingreName.length;
        }
        int oldSize = oldIngredientList.size();
        int maxSize = Integer.max(newSize, oldSize);
        for (int i = 0; i < maxSize; i++) {

            if (i < newSize && i < oldSize) {//update ingredient

                Ingredient oldIngredient = oldIngredientList.get(i);
                updateIngredientRecipe(ingreName[i], ingreAmount[i], recipeId, oldIngredient.getId(), conn, sc);
            }
            if (i < newSize && i >= oldSize) { //add ingredient
                addIngredientRecipe(ingreName[i], ingreAmount[i], recipeId, conn, sc);
            }
            if (i >= newSize && i < oldSize) { //delete ingredient
                deleteIngredientRecipe(oldIngredientList.get(i).getId(), conn);
            }

        }
        return true;
    }
    private static final String UPDATE_INGREDIENT_RECIPE
            = "UPDATE [IngredientRecipe]\n"
            + "   SET "
            + " IngredientID= ?,[Amount] = ?"
            + " WHERE IngredientID = ?";

    private static boolean updateIngredientRecipe (String ingreName, String ingreAmount, int recipeId, int ingreId,
            Connection conn, ServletContext sc) throws SQLException {
        String sql = UPDATE_INGREDIENT_RECIPE;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            int newID = getIngredientIDByName(ingreName);
            ps.setInt(1, newID);
            ps.setString(2, ingreAmount);
            ps.setInt(3, ingreId);
            if (ps.executeUpdate() == 1) {
                System.out.println("Updated Ingredient Recipe" + newID + " " + ingreName);
            }
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
            + "      WHERE ID = ?";

    private static boolean deleteIngredientRecipe (int id, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(DELETE_INGREDIENT_RECIPE);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                System.out.println("DELETED Ingredient Recipe " + id);
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
