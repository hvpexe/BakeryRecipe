package dao;

import dto.Ingredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.DBUtils;

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
     * @return the Ingredient Object with the same <b>id</b> as the inputted
     * <b>id</b>
     */
    public static Ingredient getIngredientByID(int ID) {
        String sql = SELECT_INGREDIENT_BY_ID;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setInt(1, ID);
            //run ps
            ResultSet rs = ps.executeQuery();
            Ingredient ingredient = null;
            if (rs.next()) {
                ingredient = new Ingredient(rs.getString(1), rs.getString(2));
            }
            return ingredient;
        } catch (Exception e) {
            System.out.println("getIngredientByID error:");
            e.printStackTrace();
        }
        return null;
    }
    private static final String SELECT_INGREDIENT_BY_NAME = SELECT_ALL_INGREDIENT
            + "  Where [Name] = 'egg'";

    public static Ingredient getIngredientByName(String name) {
        String sql = SELECT_INGREDIENT_BY_NAME;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setString(1, name);
            //run ps
            ResultSet rs = ps.executeQuery();
            Ingredient ingredient = null;
            if (rs.next()) {
                ingredient = new Ingredient(rs.getString(1), rs.getString(2));
            }
            System.out.println(ingredient+"a");
            return ingredient;
        } catch (Exception e) {
            System.out.println("getIngredientByID error:");
            e.printStackTrace();
        }
        return null;
    }
}
