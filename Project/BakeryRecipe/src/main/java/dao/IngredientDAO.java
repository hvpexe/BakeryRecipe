package dao;

import dto.Ingredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import utils.DBUtils;
import static dao.PictureDAO.addPictureRecipe;
import dto.IngredientRecipe;
import dto.Picture;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Tools;

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
    public static Ingredient getIngredientByID (int ID) {
        String sql = SELECT_INGREDIENT_BY_ID;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setInt(1, ID);
            //run ps
            ResultSet rs = ps.executeQuery();
            Ingredient ingredient = null;
            if (rs.next())
                ingredient = new Ingredient(rs.getString(1), rs.getString(2));
            return ingredient;
        } catch (Exception e) {
            System.out.println("getIngredientByID error:");
            e.printStackTrace();
        }
        return null;
    }
    private static final String SELECT_INGREDIENT_BY_NAME = SELECT_ALL_INGREDIENT
            + "  Where [Name] = ?";

    public static Ingredient getIngredientByName (String name) {
        String sql = SELECT_INGREDIENT_BY_NAME;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setString(1, name);
            //run ps
            ResultSet rs = ps.executeQuery();
            Ingredient ingredient = null;
            if (rs.next())
                ingredient = new Ingredient(rs.getString(1), rs.getString(2));
            System.out.println(ingredient + "a");
            return ingredient;
        } catch (Exception e) {
            System.out.println("getIngredientByID error:");
            e.printStackTrace();
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
            if (ingreId == -1)
                ingreId = IngredientDAO.addIngredient(ingreName, conn);
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
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
        }
        return false;
    }

    public static boolean addIngredientsRecipe (String[] ingreNames, String[] ingreAmounts, int recipeId,
            Connection conn,
            ServletContext sc) throws SQLException {
        conn.setAutoCommit(false);
        for (int i = 0; i < ingreNames.length; i++)
            addIngredientRecipe(ingreNames[i], ingreAmounts[i], recipeId, conn, sc);
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
        }
        return listIgre;

    }

    private static final String SELECT_INGREDIENT_ID_BY_NAME = "SELECT ID\n"
            + "  FROM [BakeryRecipe].[dbo].[Ingredient]\n"
            + "  WHERE [Name] = ?";

    public static int getIngredientIDByName (String name, Connection conn) {
        String sql = SELECT_INGREDIENT_ID_BY_NAME;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setString(1, name);
            //run ps
            ResultSet rs = ps.executeQuery();
            int id = -1;
            if (rs.next())
                id = rs.getInt(1);
            System.out.println(id);
            return id;
        } catch (Exception e) {
            System.out.println("getIngredientByID error:");
            e.printStackTrace();
        }
        return -1;
    }
    private static final String ALL_INGREDIENT = "SELECT Name\n"
            + "FROM Ingredient";

    public static List<String> getAllIngredients () {
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
            if (conn == null) {
                conn = IngredientDAO.conn;
                conn.setAutoCommit(true);
            }
            String sql = ADD_INGREDIENT;
            ps = conn.prepareStatement(sql);
            ps.setString(1, ingreName);
            ps.setString(2, null);
            rs = ps.executeQuery();
            if (rs.next())
                return rs.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, "addIngredient Error:", ex);
        } finally {
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
        }
        return -1;
    }

    /**
     * edit Ingredient name
     * if old list larger than new list delete old list
     * if old list smaller than new list add more ingredients
     * if index is equal update it
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
        if (ingreName != null)
            newSize = ingreName.length;
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
    private static final String UPDATE_INGREDIENT_RECIPE = 
            "UPDATE [IngredientRecipe]\n"
            + "   SET "
            + " IngredientID= ?,[Amount] = ?"
            + " WHERE IngredientID = ?";

    private static boolean updateIngredientRecipe (String ingreName, String ingreAmount, int recipeId, int ingreId,
            Connection conn, ServletContext sc) throws SQLException {
        String sql = UPDATE_INGREDIENT_RECIPE;
        PreparedStatement ps = conn.prepareStatement(sql);
        int id = getIngredientIDByName(ingreName, conn);
        ps.setInt(1, id);
        ps.setString(2, ingreAmount);
        ps.setInt(3, ingreId);
        if(ps.executeUpdate()==1){
            System.out.println("Updated Ingredient Relation" + id +" "+ ingreName);
        }
        return false;
    }
    private static final String DELETE_INGREDIENT_RECIPE = "DELETE [IngredientRecipe] WHERE ID = ?";

    private static boolean deleteIngredientRecipe (int id, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(DELETE_INGREDIENT_RECIPE);
        if (ps.executeUpdate() == 1) {
            System.out.println("DELETED Ingredient Recipe " + id);
            return true;
        }
        return false;
    }
}
