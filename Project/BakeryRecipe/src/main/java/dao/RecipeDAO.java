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
import utilities.DBUtils;
import java.sql.Date;
import java.sql.SQLException;
/**
 *
 * @author kichi
 */
public class RecipeDAO {
    private static final String SELECT_RECIPE_SQL = "SELECT TOP 12 ID, Name, Description, [Like], Dislike, DatePost, LastDateEdit, PrepTime, CookTime, Saved, UserID\n" +
                                                    "FROM Recipe\n" +
                                                    "WHERE IsDeleted = 0";
    private static final String SELECT_MOST_RATED_SQL = SELECT_RECIPE_SQL.replace("12", "8") + " ORDER BY [Like] DESC ";
    private static final String SELECT_MOST_RECENT_SQL = SELECT_RECIPE_SQL + " ORDER BY DatePost DESC";
    public static List<Recipe> getMostRatedRecipe(){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_MOST_RATED_SQL);
            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<>();
            while(rs.next()){
                Recipe recipe = new Recipe(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), 
                                           rs.getInt("Like"), rs.getInt("Dislike"), rs.getDate("DatePost"), 
                                           rs.getDate("LastDateEdit"), rs.getInt("PrepTime"), rs.getInt("CookTime"), 
                                           rs.getInt("Saved"), rs.getInt("UserID"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRatedRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }
    public static List<Recipe> getMostRecentRecipe(){
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_MOST_RECENT_SQL);
            ResultSet rs = ps.executeQuery();
            List<Recipe> list = new ArrayList<Recipe>();
            while(rs.next()){
                Recipe recipe = new Recipe(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"), 
                                           rs.getInt("Like"), rs.getInt("Dislike"), rs.getDate("DatePost"), 
                                           rs.getDate("LastDateEdit"), rs.getInt("PrepTime"), rs.getInt("CookTime"), 
                                           rs.getInt("Saved"), rs.getInt("UserID"));
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRecentRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }
}
