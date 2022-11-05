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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import utils.DBUtils;
import utils.Tools;

/**
 *
 * @author Admin
 */
public class PictureDAO {

    private static final String INSERT_PICTURE = "INSERT INTO [Picture]\n"
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
            filePath = Tools.getFileType(filename, picture);
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
        return true;
    }

    private static final String SELECT_PICTURE_LIST = "SELECT [ID]\n"
            + "      ,[Img]\n"
            + "      ,[IsCover]\n"
            + "      ,[RecipeID]\n"
            + "  FROM [Picture]\n"
            + "  where RecipeID = ?";

    public static List<Picture> getPictureList (int recipeID) throws SQLException {
        List<Picture> listPicture = new ArrayList<>();
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
    private static boolean updatePictureRecipe (Part picture, boolean cover, int nPicIndex, int recipeId, Picture oldPicture,
            Connection conn, ServletContext sc) throws SQLException {
        String filename = null;
        String sql = UPDATE_PICTURE;
        PreparedStatement ps = null;
        try {
            int picid = oldPicture.getId();
            filename = "picture_" + nPicIndex + "_" + recipeId;
            //case 1
            ps = conn.prepareStatement(sql);

            {
                if (picture.getSubmittedFileName().isEmpty()) //case 1
                    ps.setString(1, Tools.getFileType(filename, oldPicture.getImg()));
                else {
                    ps.setString(1, Tools.getFileType(filename, picture));
                }
                System.out.println(Tools.getFileType(filename, oldPicture.getImg()));
                System.out.println(Tools.getFileType(filename, picture));
                ps.setBoolean(2, cover);
                ps.setInt(3, recipeId);
                ps.setInt(4, picid);
            }

            if (ps.executeUpdate() == 1) {
                System.out.println("Picture " + picid + " Updated, Cover:" + cover);
                if (picture.getSubmittedFileName().isEmpty()) {//case 1
                    filename = Tools.renameFile(oldPicture.getImg(), filename, sc, Picture.IMG_PATH);
                } else {//case 2
                    filename = Tools.saveFile(filename, picture, sc, Picture.IMG_PATH);
                }
                System.out.println(filename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                ps.close();
        }
        return false;
    }

    /**
     * edit all picture
     * This method is a transaction from edit recipe that allow
     * user to update the picture section trong editrecipe.jsp
     * <hr>
     * <p>
     * make a flow from 0 to newImgs size and another increasing index
     * (npicIndex) +1 every update,add,delete
     * take the name=video-image-n -> number as picIndex
     * <p>
     * if picIndex is in the oldList (picIndex &st oldSize) we have update
     * <p>
     * update:
     * - case 1: newImg file is null
     * rename the oldImg to picture_npicIndex_recipeId.*
     * - case 2: newImg file is not null
     * replace img to new img with the name picture_npicIndex_recipeId.*
     * and also delete the oldimg from db
     * <p>
     * if picIndex is outside of oldList (picIndex &lt oldSize)
     * <p>
     * add:
     * add the newImg with name picture_npicIndex_recipeId.*
     *
     *
     * @param pictureList
     * @param cover
     * @param recipeId    our recipe
     * @param conn        Connection transaction
     * @param sc          Servlet contextD
     */
    static boolean updatePicturesRecipe (List<Part> pictureList, String[] pictureListPath, int cover, int recipeId, Connection conn,
            ServletContext sc) throws SQLException {
        List<Picture> oldPictureList = getPictureList(recipeId);
        int newSize = 0;
        int oldSize = 0;
        int oldRemainSize = 0;

        if (pictureList != null)
            newSize = pictureList.size();
        if (oldPictureList != null)
            oldSize = oldPictureList.size();
        if (pictureListPath != null)
            oldRemainSize = pictureListPath.length;

        int maxSize = Integer.max(newSize, oldSize);

//        for (int i = 0; i < maxSize; i++) {
//            boolean isCover = false;
//            if (i == cover)//check cover
//                isCover = true;
//            Part picture = null;
//            Picture oldPicture = null;
//            if (i < newSize)
//                picture = pictureList.get(i); //get new image upload
//            if (i < oldSize)
//                oldPicture = oldPictureList.get(i);// get old image
//
//            if (i < newSize && i < oldSize) {//update picture
//                updatePictureRecipe(picture, isCover, i, recipeId, oldPicture.getId(), conn, sc);
//            }
//            if (i < newSize && i >= oldSize) { //add picture
//                addPictureRecipe(picture, isCover, i, recipeId, conn, sc);
//            }
//            if (i >= newSize && i < oldSize) { //delete picture
//                deletePictureRecipe(oldPictureList.get(i).getId(), conn);
//            }
//        }
        int j = 0;
        int picIndex = -1;
        for (int i = 0; i < newSize; i++) {
            //initializing
            boolean isCover = false;
            Part picture = null;
            Picture oldPicture = null;
            picIndex = -1;
            System.out.println("-- i:" + i + " " + cover);
            if (i == cover)//check cover
                isCover = true;

            picture = pictureList.get(i); //get newImg
            picIndex = Integer.parseInt(picture.getName().replaceAll("[^0-9]", "")); //get picIndex
            while (j++ < picIndex) {
                deletePictureRecipe(oldPictureList.get(j-1).getId(), conn);
            }
            if (picIndex < oldSize) {
                oldPicture = oldPictureList.get(picIndex);// get old image
                updatePictureRecipe(picture, isCover, i, recipeId, oldPicture, conn, sc);//update
            } else {
                addPictureRecipe(picture, isCover, i, recipeId, conn, sc);
            }
        }
        if (oldSize > picIndex+1)
            for (int i = picIndex+1; i < maxSize; i++) {
                if (i >= newSize && i < oldSize) { //delete picture
                    deletePictureRecipe(oldPictureList.get(i).getId(), conn);
                }
            }
        return true;
    }
    private static final String REMOVE_PICTURE = "DELETE FROM [Picture]\n"
            + "WHERE ID = ?";

    private static boolean deletePictureRecipe (int id, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(REMOVE_PICTURE);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                System.out.println("Deleted Picture Recipe " + id);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                ps.close();
        }

        return false;
    }

}
