package com.bakeryRecipe.test;


import dao.CommentDAO;
import dao.RecipeDAO;
import dao.UserDAO;
import dto.Comment;
import dto.Recipe;
import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import utils.DBUtils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kichi
 */
public class LoginPageTesting {
    private static final String SELECT_MOST_RATED_SQL = "SELECT Recipe.ID, Name, Description, [Like], Dislike, DatePost, LastDateEdit, PrepTime, CookTime, Saved, UserID, img, LastName + ' ' + FirstName AS username\n" +
                                                        "FROM Recipe, [User], Picture\n" +
                                                        "WHERE IsDeleted = 0\n" +
                                                        "ORDER BY [Like] DESC" 
                                                        ;
    private static final String SELECT_MOST_RECENT_SQL = "SELECT Recipe.ID, Name, Description, [Like], Dislike, DatePost, LastDateEdit, PrepTime, CookTime, Saved, UserID, LastName + ' ' + FirstName AS username \n" +
"            FROM Recipe, [User]\n" +
"            WHERE IsDeleted = 0\n" +
"            ORDER BY DatePost DESC";
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
                
//                Recipe recipe = new Recipe(rs.getInt("ID"), rs.getString("Name"), rs.getString("Description"),
//                                           rs.getInt("Like"), rs.getInt("Dislike"), rs.getDate("DatePost"), 
//                                           rs.getDate("LastDateEdit"), rs.getInt("PrepTime"), rs.getInt("CookTime"),
//                                           rs.getInt("Saved"), rs.getInt("UserID"), pic, rs.getString("username"));
                Recipe recipe = null;
                list.add(recipe);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("getMostRatedRecipe Query Error!" + ex.getMessage());
        }
        return null;
    }
    public static void main(String[] args) {
        
        List<Comment> comment = CommentDAO.manageCommentList();
        for (Comment o : comment){
            System.out.println(o);
        }
        
    }
}
