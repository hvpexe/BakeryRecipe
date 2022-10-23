/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Picture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import utils.Tools;

/**
 *
 * @author Admin
 */
public class PictureDAO {

    private static final String INSERT_PICTURE = "INSERT INTO [dbo].[Picture]\n"
            + "           ([Img]\n"
            + "           ,[IsCover]\n"
            + "           ,[RecipeID])\n"
            + "     OUTPUT inserted.ID,inserted.RecipeID"
            + "     VALUES\n"
            + "           (?,?,?)";

    static boolean addPictureRecipe (Part picture, boolean isCover, int pictureIndex, int recipeId, Connection conn,
            ServletContext sc) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        String filename = null;
        try {
            //set sql
            sql = INSERT_PICTURE;
            //picture path config
            System.out.println("--------------------------------------------------------------------------------------");
            filename = "picture_" + pictureIndex + "_" + recipeId;
            ps = conn.prepareStatement(sql);
            ps.setString(1, filename);
            ps.setBoolean(2, isCover);
            ps.setInt(3, recipeId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Tools.saveFile(filename, picture, sc, Picture.IMG_PATH);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Add Picture Error" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
        }
        return false;
    }

    static boolean addPicturesRecipe (List<Part> pictureList, int cover, int recipeId, Connection conn,
            ServletContext sc) throws SQLException {
        conn.setAutoCommit(false);
        for (int i = 0; i < pictureList.size(); i++) {
            Part picture = pictureList.get(i);

            if (cover == pictureList.indexOf(picture))
                addPictureRecipe(picture, true, i, recipeId, conn, sc);
            else
                addPictureRecipe(picture, false, i, recipeId, conn, sc);
        }
        conn.commit();
        return true;
    }
}
