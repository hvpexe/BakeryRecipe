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
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import utils.Tools;

/**
 *
 * @author Admin
 */
public class IntructionDAO {

    private static final String ADD_INSTRUCTION = "INSERT INTO [dbo].[Instruction]\n"
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
        try{
            sql = ADD_INSTRUCTION;
            
            
            ps = conn.prepareStatement(sql);
            filename = "instruction_"+(index+1)+"_"+recipeId;
            //set prepare value
            ps.setInt(1, index+1);
            ps.setString(2, detail);
            ps.setString(3, filename);
            ps.setInt(4, recipeId);
            if(ps.executeUpdate()==0) {
                throw new SQLException("Add Recipe Failed!");
            }
            Tools.saveFile(filename, instImg, sc, Instruction.IMG_PATH);
        }finally{
            if(ps!= null){
                ps.close();
            }
            if(rs!= null){
                rs.close();
            }
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

}
