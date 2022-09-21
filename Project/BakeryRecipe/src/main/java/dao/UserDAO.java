/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

<<<<<<< Updated upstream
=======
<<<<<<< HEAD
import com.demo.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
=======
>>>>>>> Stashed changes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import model.User;
import utilities.DBUtils;
<<<<<<< Updated upstream
=======
>>>>>>> 8867fc6919734c17ec8a23ba68a9f48b149010a7
>>>>>>> Stashed changes

/**
 *
 * @author kichi
 */
public class UserDAO {
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
    public static boolean changePassword(String ID, String password) {
        String sql = "UPDATE [User]\n" +
                     "SET Password = ?\n" +
                     "WHERE ID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ID);
            ps.setString(2, password);
            boolean check = ps.executeUpdate() > 0;
            if(check){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error at changePassword: " + e.toString());
        }
        return false;
    }
    public static boolean checkOldPassword(String ID, String password) {
        String sql = "SELECT ID\n" +
                     "FROM [User]\n" +
                     "WHERE ID = ? AND Password = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ID);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error at checkOldPassword: " + e.toString());
=======
>>>>>>> Stashed changes

    private static final String[] USER_COLUMN_NAME_LIST
            = {"ID", "Role", "Email", "Password", "Avatar", "FirstName",
                "LastName", "Gender", "Phone", "Address", "DateRegister", "IsActive", "StoreID"};
    private static final Class[] USER_COLUMN_NAME_CLASS
            = {Integer.class, String.class, String.class, String.class, String.class, String.class,
                String.class, Boolean.class, String.class, String.class, Timestamp.class, String.class, Integer.class};
    private static final String UPDATE_USER_PASSWORD = " UPDATE [User] SET Password = ? WHERE ID= ?";

    public static boolean changePassword(String memberID, String password) {
        String sql = UPDATE_USER_PASSWORD;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setString(1, password);
            ps.setString(2, memberID);
            //run ps
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Change Password error:");
            e.printStackTrace();
<<<<<<< Updated upstream
=======
>>>>>>> 8867fc6919734c17ec8a23ba68a9f48b149010a7
>>>>>>> Stashed changes
        }
        return false;
    }

    private static final String SELECT_LOGIN = " SELECT ID from [User]\n"
            + "WHERE Email = ? AND Password = ?";

    public static User login(String email, String password) {
        String sql = UPDATE_USER_PASSWORD;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setString(1, email);
            ps.setString(2, password);
            //run ps
            ResultSet rs = ps.executeQuery();
            int id = rs.getInt("id");
            return getUserByID(id);
        } catch (Exception e) {
            System.out.println("Login error:");
            e.printStackTrace();
        }
        return null;
    }

    private static final String SELECT_USER_BY_ID = "SELECT "
            + " [ID],[Role],[Email],[Password],[Avatar]"
            + ",[FirstName],[LastName],[Gender],[Phone]"
            + ",[Address],[DateRegister],[IsActive][StoreID]"
            + " FROM [BakeryRecipe].[dbo].[User]"
            + " WHERE [ID] = ?";
    public static User getUserByID(int id) {

        String sql = SELECT_USER_BY_ID;
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setInt(1, id);
            //run ps
            ResultSet rs = ps.executeQuery();
            String[] l = USER_COLUMN_NAME_LIST;
            Class[] c = USER_COLUMN_NAME_CLASS;
            User user = new User();
            user.setID((String) rs.getObject(l[0],c[0]));
            return user;
        } catch (Exception e) {
            System.out.println("Login error:");
            e.printStackTrace();
        }
        return null;
    }
    
}
