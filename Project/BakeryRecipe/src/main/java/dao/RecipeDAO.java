/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Recipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author kichi
 */
public class RecipeDAO {

    private static final String SELECT_RECIPE_SQL = "SELECT TOP 12 ID, Name, Description, [Like], Dislike, DatePost, LastDateEdit, PrepTime, CookTime, Saved, UserID, LastName + ' ' + FirstName AS username\n"
            + "FROM Recipe\n"
            + "WHERE IsDeleted = 0";
    private static final String SELECT_MOST_RATED_SQL = SELECT_RECIPE_SQL.replace("12", "8") + " ORDER BY [Like] DESC ";
    private static final String SELECT_MOST_RECENT_SQL = SELECT_RECIPE_SQL + " ORDER BY DatePost DESC";
    private static final String SELECT_PICTURE_SQL = "SELECT img FROM Picture"; 
    public static List<Recipe> getMostRatedRecipe() {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(SELECT_PICTURE_SQL);
            ResultSet rs1 = ps1.executeQuery();
            ArrayList<String> pic = new ArrayList<>();
            while (rs1.next()){
                pic.add(rs1.getString("img"));
            }
            
            PreparedStatement ps = conn.prepareStatement(SELECT_MOST_RATED_SQL);
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

    public static List<Recipe> getMostRecentRecipe() {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps1 = conn.prepareStatement(SELECT_PICTURE_SQL);
            ResultSet rs1 = ps1.executeQuery();
            ArrayList<String> pic = new ArrayList<>();
            while (rs1.next()){
                pic.add(rs1.getString("img"));
            }
            
            PreparedStatement ps = conn.prepareStatement(SELECT_MOST_RECENT_SQL);
            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<Recipe>();
            while (rs.next()) {
                Recipe recipe = new Recipe(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
                        rs.getInt("Like"), rs.getInt("Dislike"), rs.getDate("DatePost"),
                        rs.getDate("LastDateEdit"), rs.getInt("PrepTime"), rs.getInt("CookTime"),
                        rs.getInt("Saved"), rs.getInt("UserID"), pic, rs.getString("username"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRecentRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }

    private static final String SEARCH_RECIPE = "SELECT [ID],[Name],[Description],[Like],[Dislike]"
            + ",[DatePost],[LastDateEdit],[PrepTime],[CookTime],"
            + "[Saved],[IsDeleted],[UserID]\n"
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
                Recipe recipe = new Recipe(ID, name, description, like, dislike, DatePost, lastDateEdit, prepareTime, CookTime, userID, userID, img, name);
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

}
