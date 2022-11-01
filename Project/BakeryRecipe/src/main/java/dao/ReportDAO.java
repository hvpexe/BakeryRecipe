/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import utils.DBUtils;

/**
 *
 * @author VO MINH MAN
 */
public class ReportDAO {
    
    private static final String ADD_REPORT = "insert into [dbo].[ReportRecipe]([DateReport],[Detail],[RecipeID],[UserID],[ReportType]) "
            + "values (?,?,?,?,?)";
    
    
    public static  boolean addReport(int bakerID, int recipeID,String detail,String reportType){
    Connection cnn;
        PreparedStatement ptm;
        ResultSet rs;
        boolean check = false; 
        int random_int = (int)Math.floor(Math.random()*(100-1+1)+1);
          Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String date = dateFormat.format(currentDate);
        try {
            cnn = DBUtils.getConnection();
            ptm = cnn.prepareCall(ADD_REPORT);
           
            ptm.setString(1, date);
            ptm.setString(2, detail);
            ptm.setInt(3, recipeID);
            ptm.setInt(4, bakerID);
            ptm.setString(5,reportType );
             check = ptm.executeUpdate() > 0 ? true : false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}

