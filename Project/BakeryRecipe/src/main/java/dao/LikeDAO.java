/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Recipe;
import dto.User;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import static utils.DaoHelper.execute;

/**
 *
 * @author Admin
 */
public class LikeDAO {

    public static List<Recipe> getLikedRecipeFromUser (int id) throws SQLException {
        List<Object[]> list = execute("SELECT [RecipeID]\n"
                + "  FROM [Like] WHERE UserID = ?", id);
        List<Recipe> recipeList = new LinkedList<>();
        for (Object[] objects : list)
            recipeList.add(RecipeDAO.getRecipeByID((int) objects[0]));
        if (recipeList.size() == 0)
            return null;
        return recipeList;
    }

    public static List<User> getLikedUserFromRecipe (int id) throws SQLException {
        List<Object[]> list = execute("SELECT [UserID]\n"
                + "  FROM [Like] WHERE RecipeID = ?", id);
        List<User> userList = new LinkedList<>();
        for (Object[] objects : list)
            userList.add(UserDAO.getUserByID((int) objects[0]));
        if (userList.size() == 0)
            return null;
        return userList;

    }

}
