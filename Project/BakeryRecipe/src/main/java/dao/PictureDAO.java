/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Picture;
import dto.Recipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import utils.DBUtils;
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
        String filePath = null;
        try {
            //set sql
            sql = INSERT_PICTURE;
            //picture path config
            System.out.println("--------------------------------------------------------------------------------------");
            filename = "picture_" + pictureIndex + "_" + recipeId;
            filePath = Tools.getFilePath(filename, picture);
            ps = conn.prepareStatement(sql);
            ps.setString(1, filePath);
            ps.setBoolean(2, isCover);
            ps.setInt(3, recipeId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Tools.saveFile(filename, picture, sc, Picture.IMG_PATH);
                System.out.println("Added Picture " + rs.getInt(1) + " " + filePath);
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
    private static final String SELECT_PICTURE_LIST = "SELECT [ID]\n"
            + "      ,[Img]\n"
            + "      ,[IsCover]\n"
            + "      ,[RecipeID]\n"
            + "  FROM [dbo].[Picture]\n"
            + "  where RecipeID = ?";

    public static List<Picture> getPictureList (int recipeID) {
        List<Picture> listPicture = new ArrayList<>();
        Recipe recipe = new Recipe();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(SELECT_PICTURE_LIST);
            ptm.setInt(1, recipeID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                Picture picture = new Picture(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4));
                listPicture.add(picture);
            }
        } catch (Exception e) {
            System.out.println("System have error !!!");
            e.printStackTrace();
        }
        return listPicture;
    }

    private static final String UPDATE_PICTURE
            = "UPDATE [Picture]\n"
            + "   SET [Img] = ?, [IsCover] = ?\n"
            + " WHERE RecipeID = ? and ID = ?";

    /**
     * edit picture
     * if item image is null ignore image
     * <p>
     * if item image is null but is cover set that image cover</p>
     * <p>
     * if item have image update image</p>
     *
     * @param picture
     * @param cover
     * @param recipeId
     * @param conn
     * @param sc
     */
    private static boolean updatePictureRecipe (Part picture, boolean cover, int pictureIndex, int recipeId, int picid,
            Connection conn, ServletContext sc) throws SQLException {
        String filename = null;
        String sql = UPDATE_PICTURE;
        PreparedStatement ps = null;
        if (!picture.getSubmittedFileName().isEmpty())//picture is null ignore the whole function
        {
            ps = conn.prepareStatement(sql);
            filename = "picture_" + pictureIndex + "_" + recipeId;
            ps.setString(1, Tools.getFilePath(filename, picture));
            ps.setBoolean(2, cover);
            ps.setInt(3, recipeId);
            ps.setInt(4, picid);
        } else {
            sql = sql.replace("[Img] = ?,", "");
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, cover);
            ps.setInt(2, recipeId);
            ps.setInt(3, picid);
        }
        if (ps.executeUpdate() == 1) {
            System.out.println("Picture " + picid + " Updated");
            if (filename != null) {
                filename = Tools.saveFile(filename, picture, sc, filename);
                System.out.println(filename);
            }
        }
        return false;
    }

    /**
     * edit all picture
     * This method is a transaction from edit recipe that allow
     * user to update the picture section trong editrecipe.jsp
     * <hr>
     * <p>
     * if list is null do nothing and return true </p>
     * if image index is in the old list update it
     * if image index is larger than the old list add more
     * if new list is smaller than the old list delete the overflow part
     *
     * @param pictureList
     * @param cover
     * @param recipeId    our recipe
     * @param conn        Connection transaction
     * @param sc          Servlet contextD
     */
    static boolean updatePicturesRecipe (List<Part> pictureList, int cover, int recipeId, Connection conn,
            ServletContext sc) throws SQLException {
        List<Picture> oldPictureList = getPictureList(recipeId);
        int newSize = 0;
        int oldSize = 0;

        if (pictureList != null)
            newSize = pictureList.size();
        //do nothing
        if (oldPictureList != null)
            oldSize = oldPictureList.size();
        if (pictureList != null && cover >= pictureList.size())//if cover number bigger than the size() cover is set to 0
            cover = 0;

        int maxSize = Integer.max(newSize, oldSize);
        for (int i = 0; i < maxSize; i++) {
            boolean isCover = false;
            if (i == cover)//check cover
                isCover = true;

            if (i < newSize && i < oldSize) {//update picture
                Part picture = pictureList.get(i);
                Picture oldPicture = oldPictureList.get(i);
                updatePictureRecipe(picture, isCover, i, recipeId, oldPicture.getId(), conn, sc);
            }
            if (i < newSize && i >= oldSize) { //add picture
                Part picture = pictureList.get(i);
                addPictureRecipe(picture, isCover, i, recipeId, conn, sc);
            }
            if (i >= newSize && i < oldSize) { //delete picture
                deletePictureRecipe(oldPictureList.get(i).getId(), conn);
            }

        }
        return true;
    }
    private static final String REMOVE_PICTURE = "DELETE Picture\n"
            + "WHERE ID = ?";

    private static boolean deletePictureRecipe (int id, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(REMOVE_PICTURE);
        ps.setInt(1, id);
        if (ps.executeUpdate() == 1) {
            System.out.println("Deleted picture " + id);
            return true;
        }
        return false;
    }

}
