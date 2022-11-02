/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Instruction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import utils.Tools;

/**
 *
 * @author Admin
 */
public class IntructionDAO {

    private static final String ADD_INSTRUCTION = "INSERT INTO [Instruction]\n"
            + "           ([InsStep],[Detail]\n"
            + "           ,[Img],[RecipeID])\n"
            + "     VALUES\n"
            + "           (?,?,?,?)";

    static boolean addInstructionRecipe (Part instImg, String detail, int recipeId, int index,
            Connection conn, ServletContext sc) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        String filename = null;
        String filePath = null;

        try {
            sql = ADD_INSTRUCTION;

            ps = conn.prepareStatement(sql);
            filename = "instruction_" + (index + 1) + "_" + recipeId;
            filePath = Tools.getFilePath(filename, instImg);
            //set prepare value
            ps.setInt(1, index + 1);
            ps.setString(2, detail);
            ps.setString(3, filePath);
            ps.setInt(4, recipeId);
            if (ps.executeUpdate() == 0)
                throw new SQLException("Add Recipe Failed!");
            Tools.saveFile(filename, instImg, sc, Instruction.IMG_PATH);
        } finally {
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
        }
        return true;
    }

    static boolean addInstructionsRecipe (List<Part> instImgList, String[] instDescription, int recipeId,
            Connection conn, ServletContext sc) throws SQLException {
        conn.setAutoCommit(false);
        for (int i = 0; i < instImgList.size(); i++) {
            Part instImg = instImgList.get(i);
            addInstructionRecipe(instImg, instDescription[i], recipeId, i, conn, sc);
        }
        conn.commit();
        return true;
    }

    static boolean updateInstructionsRecipe (List<Part> instImgList, String[] instDescription, int recipeId,
            Connection conn, ServletContext sc) throws SQLException {
        List<Instruction> oldList = IntructionDAO.getInstructionRecipeList(recipeId);
        int oldSize = 0;
        int newSize = 0;
        if (oldList != null)
            oldSize = oldList.size();
        if (instImgList != null)
            newSize = instImgList.size();

        int maxSize = Integer.max(oldSize, newSize);
        for (int i = 0; i < maxSize; i++) {
            if (i < newSize && i < oldSize) {//update Instruction

                Instruction oldInstruction = oldList.get(i);
                updateInstructionRecipe(instImgList.get(i), instDescription[i], recipeId, oldInstruction.getInsstep(), i, conn, sc);
            }
            if (i < newSize && i >= oldSize) { //add Instruction
                addInstructionRecipe(instImgList.get(i), instDescription[i], recipeId, i, conn, sc);
            }
            if (i >= newSize && i < oldSize) { //delete Instruction
                deleteInstructionRecipe(oldList.get(i).getInsstep(), recipeId, conn);
            }
        }
        return true;
    }
    private static final String SELECT_ALL_INSTRUCTION = "SELECT [ID]\n"
            + "      ,[InsStep]\n"
            + "      ,[Detail]\n"
            + "      ,[Img]\n"
            + "      ,[RecipeID]\n"
            + "  FROM [Instruction]\n"
            + "  Where RecipeID = ?";

    private static List<Instruction> getInstructionRecipeList (int recipeId) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Instruction> list = null;
        try {
            ps = conn.prepareStatement(SELECT_ALL_INSTRUCTION);
            ps.setInt(1, recipeId);

            rs = ps.executeQuery();
            list = new LinkedList<>();
            while (rs.next()) {
                Instruction inst
                        = new Instruction(rs.getInt("InsStep"),
                                rs.getString("Detail"),
                                rs.getString("Img"));
                list.add(inst);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
        }
        return null;
    }
    private static final String UPDATE_INSTRUCTION
            = "UPDATE [Instruction]\n"
            + "   SET [Detail] = ? ,[Img] = ?\n"
            + " WHERE [RecipeID] = ? and InsStep = ?";

    private static boolean updateInstructionRecipe (Part instImg, String detail, int recipeId,
            int insStep, int index, Connection conn, ServletContext sc) throws SQLException {
        String filename = null;
        String sql = UPDATE_INSTRUCTION;
        PreparedStatement ps = null;
        if (!instImg.getSubmittedFileName().isEmpty())//instImg is null ignore add picture
        {
            ps = conn.prepareStatement(sql);
            filename = "instruction_" + (index + 1) + "_" + recipeId;
            ps.setString(1, detail);
            ps.setString(2, Tools.getFilePath(filename, instImg));
            ps.setInt(3, recipeId);
            ps.setInt(4, insStep);
        } else {
            sql = sql.replace(",[Img] = ?", "");
            ps = conn.prepareStatement(sql);
            ps.setString(1, detail);
            ps.setInt(2, recipeId);
            ps.setInt(3, insStep);
        }
        if (ps.executeUpdate() == 1) {
            System.out.println("Instruction " + insStep + "_" + recipeId + " Updated");
            if (filename != null) {
                filename = Tools.saveFile(filename, instImg, sc, filename);
                System.out.println(filename);
            }
        }
        return false;
    }
    private static final String DELETE_INSTRUCTION
            = "DELETE FROM [Instruction]\n"
            + "      WHERE RecipeID= ? and InsStep = ?";

    private static boolean deleteInstructionRecipe (int insStep, int recipeId, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(DELETE_INSTRUCTION);
            ps.setInt(1, recipeId);
            ps.setInt(2, insStep);
            if (ps.executeUpdate() == 1) {
                System.out.println("DELETED Instruction  " + insStep+" "+recipeId);
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
