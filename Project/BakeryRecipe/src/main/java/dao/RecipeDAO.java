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
import org.checkerframework.checker.units.qual.A;

/**
 *
 * @author kichi
 */
public class RecipeDAO {

    private static final String SELECT_MOST_RECENT_SQL = "SELECT Recipe.ID, Name, Description, [Like], Dislike, DatePost, LastDateEdit, PrepTime, CookTime, Saved, UserID, img, LastName + ' ' + FirstName AS username\n"
            + "                                                        FROM Recipe\n"
            + "                                                        JOIN Picture ON Recipe.ID = Picture.RecipeID\n"
            + "                                                        JOIN [User] ON Recipe.UserID = [User].ID\n"
            + "                                                        WHERE IsDeleted = 0\n"
            + "                                                        ORDER BY DatePost DESC\n"
            + "							 OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
    private static final String SELECT_MOST_RATED_SQL = "SELECT Recipe.ID, Name, Description, [Like], Dislike, DatePost, LastDateEdit, PrepTime, CookTime, Saved, UserID, img, LastName + ' ' + FirstName AS username\n"
            + "                                                        FROM Recipe\n"
            + "                                                        JOIN Picture ON Recipe.ID = Picture.RecipeID\n"
            + "                                                        JOIN [User] ON Recipe.UserID = [User].ID\n"
            + "                                                        WHERE IsDeleted = 0\n"
            + "                                                        ORDER BY [Like] DESC\n"
            + "							 OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
    private static final String SELECT_PICTURE_SQL = "SELECT img FROM Picture";
    private static final String TOP8_MOST_RATED_SQL = "SELECT TOP 8 Recipe.ID, Name, Description, [Like], Dislike, DatePost, LastDateEdit, PrepTime, CookTime, Saved, UserID, img, LastName + ' ' + FirstName AS username\n"
            + "                                                      FROM Recipe\n"
            + "                                                      JOIN Picture ON Recipe.ID = Picture.RecipeID\n"
            + "                                                      JOIN [User] ON Recipe.UserID = [User].ID\n"
            + "                                                      WHERE IsDeleted = 0\n"
            + "                                                      ORDER BY [Like] DESC";
    private static final String TOP8_MOST_RECENT_SQL = "SELECT TOP 8 Recipe.ID, Name, Description, [Like], Dislike, DatePost, LastDateEdit, PrepTime, CookTime, Saved, UserID, img, LastName + ' ' + FirstName AS username\n"
            + "                                                      FROM Recipe\n"
            + "                                                      JOIN Picture ON Recipe.ID = Picture.RecipeID\n"
            + "                                                      JOIN [User] ON Recipe.UserID = [User].ID\n"
            + "                                                      WHERE IsDeleted = 0\n"
            + "                                                      ORDER BY DatePost DESC";

    public static List<Recipe> getMostRatedRecipe(int index) {

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(SELECT_PICTURE_SQL);
            ResultSet rs1 = ps1.executeQuery();
            ArrayList<String> pic = new ArrayList<>();
            while (rs1.next()) {
                pic.add(rs1.getString("img"));
            }

            PreparedStatement ps = conn.prepareStatement(SELECT_MOST_RATED_SQL);
            ps.setInt(1, (index - 1) * 8);
            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<>();
            while (rs.next()) {

                Recipe recipe = new Recipe(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getInt("Like"), rs.getInt("Dislike"), rs.getDate("DatePost"),
                        rs.getDate("LastDateEdit"), rs.getInt("PrepTime"), rs.getInt("CookTime"),
                        rs.getInt("Saved"), rs.getInt("UserID"), pic, rs.getString("username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRatedRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }

    public static List<Recipe> getMostRecentRecipe(int index) {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(SELECT_PICTURE_SQL);
            ResultSet rs1 = ps1.executeQuery();
            ArrayList<String> pic = new ArrayList<>();
            while (rs1.next()) {
                pic.add(rs1.getString("img"));
            }

            PreparedStatement ps = conn.prepareStatement(SELECT_MOST_RECENT_SQL);
            ps.setInt(1, (index - 1) * 8);
            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<>();
            while (rs.next()) {

                Recipe recipe = new Recipe(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getInt("Like"), rs.getInt("Dislike"), rs.getDate("DatePost"),
                        rs.getDate("LastDateEdit"), rs.getInt("PrepTime"), rs.getInt("CookTime"),
                        rs.getInt("Saved"), rs.getInt("UserID"), pic, rs.getString("username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRatedRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }

    private static final String SEARCH_RECIPE = "SELECT [ID],[Name],[Description],[Like],[Dislike]"
            + ",[DatePost],[LastDateEdit],[PrepTime],[CookTime],"
            + "[Saved],[IsDeleted],[UserID],[Img]\n"
            + "FROM[dbo].[Recipe]\n"
            + "WHERE [Name] = ?";

    public static List<Recipe> searchRecipe(String name) throws SQLException {
        ArrayList<Recipe> listRecipe = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(SEARCH_RECIPE);
            ptm.setString(1, name);
            rs = ptm.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String description = rs.getString("Description");
                int like = rs.getInt("Like");
                int dislike = rs.getInt("DisLike");
                Date DatePost = rs.getDate("DatePost");
                Date lastDateEdit = rs.getDate("LastDateEdit");
                int prepareTime = rs.getInt("PrepTime");
                int CookTime = rs.getInt("CookTime");
                int userID = rs.getInt("UserID");
                boolean isDeleted = rs.getBoolean("IsDeleted");
                int save = Integer.parseInt(rs.getString("Saved"));
                String img1 = rs.getString("Img");
                ArrayList<String> img = null;
                img = new ArrayList<>();
                img.add(img1);
                Recipe recipe = new Recipe(ID, name, description, like, dislike, DatePost, lastDateEdit, prepareTime, CookTime, save, userID, img, name);
                if (!isDeleted) {
                    listRecipe.add(recipe);

                }
            }

        } catch (Exception e) {
            System.out.println("System had a problem ???");
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
        return listRecipe;
    }

    public static int getAllRecipe() {
        String sql = "SELECT count(Recipe.ID)\n"
                + "FROM Recipe\n"
                + "WHERE IsDeleted = 0";
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

    public static List<Recipe> getTop8MostRatedRecipe() {

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(SELECT_PICTURE_SQL);
            ResultSet rs1 = ps1.executeQuery();
            ArrayList<String> pic = new ArrayList<>();
            while (rs1.next()) {
                pic.add(rs1.getString("img"));
            }

            PreparedStatement ps = conn.prepareStatement(TOP8_MOST_RATED_SQL);

            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<>();
            while (rs.next()) {

                Recipe recipe = new Recipe(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getInt("Like"), rs.getInt("Dislike"), rs.getDate("DatePost"),
                        rs.getDate("LastDateEdit"), rs.getInt("PrepTime"), rs.getInt("CookTime"),
                        rs.getInt("Saved"), rs.getInt("UserID"), pic, rs.getString("username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRatedRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }

    public static List<Recipe> getTop8MostRecentRecipe() {

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(SELECT_PICTURE_SQL);
            ResultSet rs1 = ps1.executeQuery();
            ArrayList<String> pic = new ArrayList<>();
            while (rs1.next()) {
                pic.add(rs1.getString("img"));
            }

            PreparedStatement ps = conn.prepareStatement(TOP8_MOST_RECENT_SQL);

            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<>();
            while (rs.next()) {

                Recipe recipe = new Recipe(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getInt("Like"), rs.getInt("Dislike"), rs.getDate("DatePost"),
                        rs.getDate("LastDateEdit"), rs.getInt("PrepTime"), rs.getInt("CookTime"),
                        rs.getInt("Saved"), rs.getInt("UserID"), pic, rs.getString("username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRatedRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }

    private static final String LIST_PICTURE_SQL = "SELECT [img]\n"
            + "FROM [dbo].[Picture] picture  join [dbo].[Recipe] recipe \n"
            + "on picture.RecipeID = recipe.ID\n"
            + "where recipe.ID = ?";

    public ArrayList<String> listPicture(int recipeID) throws SQLException {
        ArrayList<String> listPic = new ArrayList<>();
        Recipe sc = new Recipe();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(LIST_PICTURE_SQL);
            ptm.setInt(1, recipeID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String pic = rs.getString("img");
                listPic.add(pic);
                sc.setVideo(listPic);
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
        return sc.getVideo();

    }
/////on roi nha

    private static final String LIST_VIDEO = " SELECT [link]\n"
            + "FROM [dbo].[Video] video join [dbo].[Recipe] recipe\n"
            + "on video.RecipeID = recipe.ID\n"
            + "where recipe.ID = ?";

    public ArrayList<String> listVideo(int recipeID) throws SQLException {
        ArrayList<String> listVideo = new ArrayList<>();
        Recipe recipe = new Recipe();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(LIST_VIDEO);
            ptm.setInt(1, recipeID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String video = rs.getString("link");
                listVideo.add(video);
                recipe.setVideo(listVideo);
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
        return recipe.getVideo();

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
        return liststep;
    }
}
