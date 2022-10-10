/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Ingredient;
import dto.Intruction;
import dto.Recipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import utils.Tools;

/**
 *
 * @author kichi
 */
public class RecipeDAO {

    private static final String SELECT_MOST_RATED_SQL = "SELECT Recipe.ID, Name, Description, [Like], [Save], Comment, DatePost, LastDateEdit, Img, UserID, LastName + ' ' + FirstName AS Username\n"
            + "                                                        FROM Recipe\n"
            + "                                                        JOIN [User] ON Recipe.UserID = [User].ID\n"
            + "                                                        JOIN Picture ON Picture.RecipeID = Recipe.ID\n"
            + "                                                        WHERE IsDeleted = 0 AND IsCover = 1\n"
            + "                                                        ORDER BY [Like] DESC\n"
            + "			                                 OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
    private static final String SELECT_PICTURE_SQL = "SELECT img FROM Picture";

    public static List<Recipe> getMostRatedRecipe(int index) {

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_MOST_RATED_SQL);
            ps.setInt(1, (index - 1) * 8);
            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<>();
            while (rs.next()) {
                Recipe recipe = new Recipe(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getInt("Like"),
                        rs.getInt("Save"),
                        rs.getInt("Comment"),
                        rs.getTimestamp("DatePost"),
                        rs.getTimestamp("LastDateEdit"),
                        rs.getString("Img"),
                        rs.getInt("UserID"),
                        rs.getString("Username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRatedRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }

    private static final String SELECT_MOST_RECENT_SQL = "SELECT Recipe.ID, Name, Description, [Like], [Save], Comment, DatePost, LastDateEdit, Img, UserID, LastName + ' ' + FirstName AS Username\n"
            + "                                                        FROM Recipe\n"
            + "                                                        JOIN [User] ON Recipe.UserID = [User].ID\n"
            + "                                                        JOIN Picture ON Picture.RecipeID = Recipe.ID\n"
            + "                                                        WHERE IsDeleted = 0 AND IsCover = 1\n"
            + "                                                        ORDER BY DatePost DESC\n"
            + "			                                 OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";

    public static List<Recipe> getMostRecentRecipe(int index) {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_MOST_RECENT_SQL);
            ps.setInt(1, (index - 1) * 8);
            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<>();
            while (rs.next()) {
                Recipe recipe = new Recipe(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getInt("Like"),
                        rs.getInt("Save"),
                        rs.getInt("Comment"),
                        rs.getTimestamp("DatePost"),
                        rs.getTimestamp("LastDateEdit"),
                        rs.getString("Img"),
                        rs.getInt("UserID"),
                        rs.getString("Username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRecentRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }

    private static final String SEARCH_RECIPE = "SELECT recipe.[Name],[Description],[Like],recipe.ID\n"
            + "            ,[DatePost],[LastDateEdit],[PrepTime],[CookTime]\n"
            + "            [Save],[IsDeleted],[UserID],Comment,[Img],baker.FirstName +' '+baker.LastName as fullName\n"
            + "            FROM[dbo].[Recipe] recipe join [dbo].[Picture] pic\n"
            + "			on recipe.ID =pic.RecipeID\n"
            + "			join [dbo].[User]  baker\n"
            + "			on  baker.ID =recipe.UserID\n"
            + "            WHERE recipe.Name like ? and pic.IsCover ='True'";

    public List<Recipe> searchRecipe(String name) throws SQLException {
        ArrayList<Recipe> listRecipe = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(SEARCH_RECIPE);
            ptm.setString(1, "%" + name + "%");
            rs = ptm.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("fullName");
//                String img = rs.getString("Img");
                int comment =rs.getInt("Comment");
                int like =rs.getInt("Like");
                int save = rs.getInt("Save");
                String cakeName = rs.getString("Name");
                String cover = rs.getString("Img");
                Recipe recipe;
                recipe = new Recipe(cakeName, like, comment, cover, fullName);
                listRecipe.add(recipe);
            }

        } catch (Exception e) {
            System.out.println("System had a problem ???");
            e.printStackTrace();
        }
        return listRecipe;
    }

    public static int getAllRecipe() {
        String sql = "SELECT count(Recipe.ID)\n" +
"                     FROM Recipe\n" +
"		      JOIN [User] ON Recipe.UserID = [User].ID\n" +
"		      JOIN Picture ON Picture.RecipeID = Recipe.ID\n" +
"                     WHERE IsDeleted = 0 AND IsCover = 1";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        return 0;
    }

    private static final String TOP8_MOST_RATED_SQL = "SELECT TOP 8 Recipe.ID, Name, Description, [Like], [Save], Comment, DatePost, LastDateEdit, Img, UserID, LastName + ' ' + FirstName AS Username\n"
            + "FROM Recipe\n"
            + "JOIN [User] ON Recipe.UserID = [User].ID\n"
            + "JOIN Picture ON Picture.RecipeID = Recipe.ID\n"
            + "WHERE IsDeleted = 0 AND IsCover = 1\n"
            + "ORDER BY [Like] DESC";

    public static List<Recipe> getTop8MostRatedRecipe() {

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(TOP8_MOST_RATED_SQL);

            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<>();
            while (rs.next()) {
                Recipe recipe = new Recipe(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getInt("Like"),
                        rs.getInt("Save"),
                        rs.getInt("Comment"),
                        rs.getTimestamp("DatePost"),
                        rs.getTimestamp("LastDateEdit"),
                        rs.getString("Img"),
                        rs.getInt("UserID"),
                        rs.getString("Username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRatedRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }

    private static final String TOP8_MOST_RECENT_SQL = "SELECT TOP 8 Recipe.ID, Name, Description, [Like], [Save], Comment, DatePost, LastDateEdit, Img, UserID, LastName + ' ' + FirstName AS Username\n"
            + "FROM Recipe\n"
            + "JOIN [User] ON Recipe.UserID = [User].ID\n"
            + "JOIN Picture ON Picture.RecipeID = Recipe.ID\n"
            + "WHERE IsDeleted = 0 AND IsCover = 1\n"
            + "ORDER BY [DatePost] DESC";

    public static List<Recipe> getTop8MostRecentRecipe() {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(TOP8_MOST_RECENT_SQL);

            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<>();
            while (rs.next()) {
                Recipe recipe = new Recipe(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getInt("Like"),
                        rs.getInt("Save"),
                        rs.getInt("Comment"),
                        rs.getTimestamp("DatePost"),
                        rs.getTimestamp("LastDateEdit"),
                        rs.getString("Img"),
                        rs.getInt("UserID"),
                        rs.getString("Username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getTop8MostRecentRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }
    
    private static final String SAVED_RECIPES_LIST_SQL = "SELECT Recipe.ID, Recipe.[Name], Recipe.[Description], Recipe.[Like], Recipe.[Save], Recipe.Comment, Recipe.DatePost, Recipe.LastDateEdit, Picture.Img, Recipe.UserID, LastName + ' ' + FirstName AS Username\n" +
                                                         "FROM [User]\n" +
                                                         "JOIN [Save] ON [Save].UserID = [User].ID\n" +
                                                         "JOIN [Recipe] ON [Save].RecipeID = [Recipe].ID\n" +
                                                         "JOIN [Picture] ON [Recipe].ID = [Picture].RecipeID\n" +
                                                         "WHERE IsDeleted = 0 AND IsCover = 1 AND [User].ID = ?\n" +
                                                         "ORDER BY Recipe.[Like] DESC\n" +
                                                         "OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
    
    public static List<Recipe> showSavedRecipe(int userID, int index) {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(SAVED_RECIPES_LIST_SQL);
            ps.setInt(1, userID);
            ps.setInt(2, (index - 1) * 8);
            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<>();
            while (rs.next()) {
                Recipe recipe = new Recipe(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getInt("Like"),
                        rs.getInt("Save"),
                        rs.getInt("Comment"),
                        rs.getTimestamp("DatePost"),
                        rs.getTimestamp("LastDateEdit"),
                        rs.getString("Img"),
                        rs.getInt("UserID"),
                        rs.getString("Username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRatedRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }
    public static int getAllSavedRecipe(int id) {
        String sql = "SELECT count(Recipe.ID)\n" +
"                     FROM [User]\n" +
"		      JOIN [Save] ON [Save].UserID = [User].ID\n" +
"		      JOIN [Recipe] ON [Save].RecipeID = [Recipe].ID\n" +
"		      JOIN [Picture] ON [Recipe].ID = [Picture].RecipeID\n" +
"                     WHERE IsDeleted = 0 AND IsCover = 1 AND [User].ID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        return 0;
    }  

       private static final String LIST_PICTURE = "  SELECT pic.img,recipe.Video\n"
            + " FROM  [dbo].[Recipe] recipe\n"
            + "join [dbo].[Picture] pic\n"
            + "on pic.RecipeID=recipe.ID\n"
            + "   where recipe.ID = ?";

    public static ArrayList<String> listPicture(int recipeID) throws SQLException {
        ArrayList<String> listPicture = new ArrayList<>();
        Recipe recipe = new Recipe();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(LIST_PICTURE);
            ptm.setInt(1, recipeID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String picture = rs.getString("img");
                listPicture.add(picture);
            }
        } catch (Exception e) {
            System.out.println("System have error !!!");
        }
        return listPicture;

    }

    private static final String LIST_INGREDIENT = "select ingre.[Name],ingre.[Img]\n"
            + "from [dbo].[Ingredient] ingre join [dbo].[IngredientRecipe] ingreRe\n"
            + "on ingre.ID =ingreRe.IngredientID\n"
            + "join [dbo].[Recipe] re on ingreRe.RecipeID =re.ID\n"
            + "where re.ID = ?";

    public List<Ingredient> listIngredient(int recipeID) throws SQLException {
        List<Ingredient> listIgre = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(LIST_INGREDIENT);
            ptm.setInt(1, recipeID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Name");
                String img = rs.getString("Img");
                Ingredient sc;
                sc = new Ingredient(name, img);
                listIgre.add(sc);
            }
        } catch (Exception e) {
            System.out.println("System have error !!!");
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

  private static final String LIST_STEP = "SELECT [InsStep],[Detail],[Img]\n"
            + "FROM [dbo].[Instruction] instruc join [dbo].[Recipe] recipe \n"
            + "ON instruc.RecipeID = recipe.ID\n"
            + "WHERE recipe.ID = ?";

    public List<Intruction> listStep(int recipeID) throws SQLException {
        List<Intruction> liststep = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(LIST_STEP);
            ptm.setInt(1, recipeID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                int step = rs.getInt("InsStep");
                String detailStep = rs.getString("Detail");
                String imgStep = rs.getString("Img");
                Intruction intruc;
                intruc = new Intruction(step, detailStep, imgStep);
                liststep.add(intruc);
            }

        } catch (Exception e) {
            System.out.println("System have error !!!" + e);

        }
        return liststep;
    }

    private static final String POST_HOME_RECIPE_SQL = "(SELECT U2.ID as UserID, U2.FirstName + ' ' + U2.LastName AS Username, U2.Avatar, R.ID, R.Name, R.Description, R.[Like], R.[Save], R.Comment, R.DatePost, P.Img AS Cover\n"
            + "FROM [User] U\n"
            + "JOIN Follow ON U.ID = Follow.UserID\n"
            + "JOIN [User] U2 ON U2.ID = Follow.UserID2\n"
            + "JOIN Recipe R ON R.UserID = Follow.UserID2\n"
            + "JOIN Picture P ON P.RecipeID = R.ID\n"
            + "WHERE U.ID = ? AND R.IsDeleted = 0 AND P.IsCover = 1)\n"
            + "UNION\n"
            + "(SELECT U.ID AS UserID, U.FirstName + ' ' + U.LastName AS Username, U.Avatar, R.ID, R.Name, R.Description, R.[Like], R.[Save], R.Comment, R.DatePost, P.Img AS Cover\n"
            + "FROM Recipe R\n"
            + "JOIN [User] U ON R.UserID = U.ID\n"
            + "JOIN Picture P ON P.RecipeID = R.ID\n"
            + "WHERE R.UserID = ? AND R.IsDeleted = 0 AND P.IsCover = 1)\n"
            + "ORDER BY DatePost DESC";

    public static ArrayList<Recipe> getPostHomeRecipes(int userID) {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(POST_HOME_RECIPE_SQL);
            ps.setInt(1, userID);
            ps.setInt(2, userID);
            ResultSet rs = ps.executeQuery();
            ArrayList<Recipe> list = new ArrayList<Recipe>();
            while (rs.next()) {
                Recipe recipe = new Recipe(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getInt("Like"), rs.getInt("Save"),
                        rs.getInt("Comment"),
                        rs.getTimestamp("DatePost"),
                        rs.getString("Cover"),
                        rs.getInt("UserID"),
                        rs.getString("Avatar"),
                        rs.getString("Username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getPostHomeRecipes Query Error!" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

    private static final String POST_PROFILE_RECIPE_SQL = "SELECT U.ID AS UserID, U.FirstName + ' ' + U.LastName AS Username, U.Avatar, R.ID, R.Name, R.Description, R.[Like], R.[Save], R.Comment, R.DatePost, P.Img AS Cover\n"
            + "FROM Recipe R\n"
            + "JOIN [User] U ON R.UserID = U.ID\n"
            + "JOIN Picture P ON P.RecipeID = R.ID\n"
            + "WHERE R.UserID = ? AND R.IsDeleted = 0 AND P.IsCover = 1\n"
            + "ORDER BY DatePost DESC";

    public static ArrayList<Recipe> getPostProfileRecipes(int userID) {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(POST_PROFILE_RECIPE_SQL);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            ArrayList<Recipe> list = new ArrayList<Recipe>();
            while (rs.next()) {
                Recipe recipe = new Recipe(rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getInt("Like"), rs.getInt("Save"),
                        rs.getInt("Comment"),
                        rs.getTimestamp("DatePost"),
                        rs.getString("Cover"),
                        rs.getInt("UserID"),
                        rs.getString("Avatar"),
                        rs.getString("Username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getPostProfileRecipes Query Error!" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

     private static final String COOK_DETAIL = "SELECT [Name],[Like],[Save],[Comment],[PrepTime],[CookTime],[Description],[DatePost],DatePost, LastDateEdit \n"
            + "FROM [dbo].[Recipe]recipe join [dbo].[User] baker\n"
            + "on recipe.UserID =baker.ID\n"
            + "WHERE baker.ID = ? and recipe.ID =?";

    public Recipe recipeDetail(int userID,int recipeID) {
        Recipe recipe = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(COOK_DETAIL);
            ptm.setInt(1, userID);
            ptm.setInt(2, recipeID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                int like = rs.getInt("Like");
                int save = rs.getInt("Save");
                int prepTime = rs.getInt("PrepTime");
                int cookTime = rs.getInt("CookTime");
                int comment = rs.getInt("Comment");
                recipe = new Recipe(name, description, like, save, comment, rs.getTimestamp("DatePost"), rs.getTimestamp("LastDateEdit"), prepTime, cookTime);
            }
        } catch (Exception e) {
            System.out.println("System have error !!!" + e);
        }
        return recipe;
    }
    
    
     private static final String VIDEO_DETAIL = "SELECT [Video]\n"
            + "FROM [dbo].[Recipe] recipe join [dbo].[User] baker\n"
            + "ON recipe.[UserID]= baker.[ID]\n"
            + "WHERE baker.[ID] = ?";

    public String recipeVideo(int userID) {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        String theVideo = null;
        try {
            conn =DBUtils.getConnection();
            ptm = conn.prepareStatement(VIDEO_DETAIL);
            ptm.setInt(1, userID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String video = rs.getString("Video");
                theVideo = video;
            }
        } catch (Exception e) {
        }
        return theVideo;
    }
    public static void main(String[] args) {
        List<Recipe> list = showSavedRecipe(3, 1);
        for (Recipe recipe : list) {
            System.out.println(recipe);
        }
    }
    
}
