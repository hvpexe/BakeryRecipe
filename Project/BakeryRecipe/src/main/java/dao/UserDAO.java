/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import dto.User;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import utils.DBUtils;
import utils.Tools;

/**
 *
 * @author kichi
 */
public class UserDAO {

    private static Connection conn = DBUtils.getConnection();
    private static final String[] USER_COLUMN_NAME_LIST
            = {"ID", "Role", "Email", "Password", "Avatar", "FirstName",
                "LastName", "Gender", "Phone", "Address", "DateRegister", "IsActive", "StoreID", "Birthday"};
    private static final Class[] USER_COLUMN_NAME_CLASS
            = {Integer.class, String.class, String.class, String.class, String.class, String.class,
                String.class, Boolean.class, String.class, String.class, Timestamp.class, String.class, Integer.class};

    //ay da ko xem database code sai r
    public static boolean checkOldPassword(String userID, String password) {
        String sql = "SELECT ID\n"
                + "FROM [User]\n"
                + "WHERE ID = ? AND Password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error at checkOldPassword: " + e.toString());
        }
        return false;
    }
    private static final String UPDATE_USER_PASSWORD = " UPDATE [User] SET Password = ? WHERE ID= ?";

    public static boolean changePassword(String userID, String password) {
        String sql = UPDATE_USER_PASSWORD;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setString(1, password);
            ps.setString(2, userID);
            //run ps
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Change Password error:");
            e.printStackTrace();
        }
        return false;
    }

    private static final String SELECT_LOGIN = " SELECT ID from [User]"
            + "WHERE Email = ? AND Password = ?";

    public static User loginWithGoogle(String email) {
        String sql = SELECT_LOGIN.replace(" AND Password = ?", "");
        try {
            System.out.println(conn);
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setString(1, email);
            //run ps
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                return getUserByID(id);
            }
            return null;
        } catch (Exception e) {
            System.out.println("loginWithGoogle error:");
            e.printStackTrace();
        }
        return null;
    }

    public static User login(String email, String password) {
        String sql = SELECT_LOGIN;
        try {
            System.out.println(conn);
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setString(1, email);
            ps.setString(2, password);
            //run ps
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                return getUserByID(id);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Login error:");
            e.printStackTrace();
        }
        return null;
    }

    private static final String SELECT_ALL_USER = "SELECT "
            + " [ID],[Role],[Email],[Password],[Avatar]"
            + ",[FirstName],[LastName],[Gender],[Phone]"
            + ",[Address],[DateRegister],[IsActive][StoreID], [Birthday]"
            + " FROM [BakeryRecipe].[dbo].[User]";

    /**
     * Get All User this <b>method</b> select all the <b>User</b>
     *
     * @param id the <b>id</b> of the <b>User</b>
     * @return the User Object with the same <b>id</b> as the inputted <b>id</b>
     */
    public static List<User> getAllUser() {
        String sql = SELECT_ALL_USER;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String[] l = USER_COLUMN_NAME_LIST;
            List<User> list = new ArrayList<>();
            User user = null;
            while (rs.next()) {
                user = new User(rs.getInt(l[0]), rs.getString(l[1]), rs.getString(l[2]), rs.getString(l[3]), rs.getString(l[4]), rs.getString(l[5]),
                        rs.getString(l[6]), rs.getString(l[7]), rs.getString(l[8]), rs.getString(l[9]), rs.getDate(l[10]), rs.getInt(l[12]), rs.getDate(l[13]));
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            System.out.println("Login error:");
            e.printStackTrace();
        }
        return null;
    }
    private static final String SELECT_USER_BY_ID = "SELECT "
            + " [ID],[Role],[Email],[Password],[Avatar]"
            + ",[FirstName],[LastName],[Gender],[Phone]"
            + ",[Address],[DateRegister],[IsActive][StoreID], [Birthday]"
            + " FROM [BakeryRecipe].[dbo].[User]"
            + " WHERE [ID] = ? and IsActive = ?";
    /** Get User by ID
     *  but this <b>method</b> only select the <b>User</b> that <b>not banned</b>
     * @param id the <b>id</b> of the <b>User</b>
     * @return the User Object with the same <b>id</b> as the inputted <b>id</b>
     */
    public static User getUserByID(int id) {
        String sql = SELECT_USER_BY_ID;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //Set ps
            ps.setInt(1, id);
            ps.setInt(2, 1);
            //run ps
            ResultSet rs = ps.executeQuery();
            String[] l = USER_COLUMN_NAME_LIST;
            User user = null;
            if (rs.next()) {
                user = new User(rs.getInt(l[0]), rs.getString(l[1]), rs.getString(l[2]), rs.getString(l[3]), rs.getString(l[4]), rs.getString(l[5]),
                        rs.getString(l[6]), rs.getString(l[7]), rs.getString(l[8]), rs.getString(l[9]), rs.getDate(l[10]), rs.getInt(l[12]), rs.getDate(l[13]));
            }
            return user;
        } catch (Exception e) {
            System.out.println("Login error:");
            e.printStackTrace();
        }
        return null;
    }

    private static final String CHECK_EMAIL_EXIST = "SELECT ID FROM [User] WHERE Email = ?";

    //ham nay dung de kiem tra email co bi trung ko, ap dung khi tao tk moi
    public static boolean checkDuplicateEmail(String email) {
        String sql = CHECK_EMAIL_EXIST;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("checkDuplicateEmail error!" + ex.getMessage());
        }
        return false;
    }

    private static final String INSERT_NEW_USER = "INSERT INTO [User](Role, Email, Password, FirstName, LastName, DateRegister, IsActive) VALUES \n"
            + "(?, ?, ?, ?, ?, ?, 1);";

    //dang ki mot tk moi
    public static boolean register(String email, String password, String firstname, String lastname) {
        String sql = INSERT_NEW_USER;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "baker");
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, firstname);
            ps.setString(5, lastname);
            ps.setDate(6, new Date(System.currentTimeMillis()));
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Register error");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * user register with avatar
     *
     * @param avatar the avatar of the user
     * @return true if login success
     */
    public static boolean register(String email, String password, String firstname, String lastname, String avatar) {
        if (register(email, password, firstname, lastname)) {
            updateAvatar(email, avatar);
            return true;
        }
        return false;
    }
    private static final String UPDATE_USER_IMAGE = "UPDATE [User] SET [Avatar] = ? WHERE Email= ?";
    public static boolean updateAvatar(String email, String avatar) {
        String sql = UPDATE_USER_IMAGE;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, avatar);//set avatar path
            ps.setString(2, email);//where user have this email 
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Update Avatar error");
            e.printStackTrace();
        }
        return false;
    }

     private static final String SEARCH_CHEFNAME = "SELECT [ID],[Role],[Email],[Password],"
            + "[Avatar],[FirstName],[LastName],[Gender],[Phone]"
            + ",[Address],[DateRegister],[IsActive],[StoreID]\n"
            + "FROM [dbo].[User]\n"
            + "WHERE  [LastName] like ? or [FirstName] like ?";

    public  List<User> searchName(String search) throws SQLException {
        ArrayList<User> listName = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH_CHEFNAME);
                ptm.setString(1,  "%"+search+"%" );
                ptm.setString(2, "%"+search+"%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                   
                    int ID = rs.getInt("ID");
                    String role = rs.getString("Role");
                    String email = rs.getString("Email");
                    String avatar = rs.getString("Avatar");
                    String password = rs.getString("Password");
                    String FirstName = rs.getString("FirstName");
                    String LastName = rs.getString("LastName");
                    String Gender = rs.getString("Gender");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    Date DateRegister = rs.getDate("DateRegister");
                    boolean isActive = rs.getBoolean("IsActive");
                    int StoreId = rs.getInt("StoreID");
                    User user = new User(ID, role, email, password, avatar, FirstName, LastName, Gender, phone, address, DateRegister, isActive, StoreId);
                    listName.add(user);
                }
            }
        } catch (Exception e) {
            System.out.println("System have problem !!!");
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
        return listName;
    }
    
    public static boolean EditInfo(User user){
        String sql = "UPDATE [User]\n" +
                     "SET FirstName = ?,\n" +
                     "    LastName = ?,\n" +
                     "	  Phone = ?,\n" +
                     "	  Birthday = ?,\n" +
                     "	  Gender = ?,\n" +
                     "	  [Address] = ?,\n" +
                     "	  Avatar = ?\n" +
                     "WHERE ID = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            int i = 1;
            //System.out.println(user.getAvatar());
            //ps.setString(i++, user.getAvatar());
            ps.setString(i++, user.getFirstName());
            ps.setString(i++, user.getLastName());
            ps.setDate(i++, user.getBirthday());
            ps.setString(i++, user.getGender());
            ps.setString(i++, user.getPhone());
            ps.setString(i++, user.getAddress());
            //ps.setInt(i++, user.getId());
            ResultSet rs = ps.executeQuery();
            
            boolean check = ps.executeUpdate() > 0;
            if (check) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error at editInfo: " + e.toString());
        }
        return false;
    }
    
   /* public static String saveAvatar(String id, Part part, ServletContext sc) {

        try {
            String fileName = part.getSubmittedFileName();
            if (fileName.isEmpty()) {
                return null;
            }
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            id += fileName.substring(fileName.indexOf('.'), fileName.length());
            String absoluteFilepath = sc.getRealPath("/" + User.IMG_PATH);
//            System.out.println(absoluteFilepath);
            //D:\learning in FPT\Tools\UploadFile\build\web\images
            String webFilepath = absoluteFilepath.replace("\\build", "");
            Tools.getFolderUpload(absoluteFilepath);
            Tools.getFolderUpload(webFilepath);
//        D:\learning in FPT\Tools\UploadFile\web\assets\images
            part.write(absoluteFilepath + id);
            part.write(webFilepath + id);
            return id;
        } catch (IOException ex) {
            System.out.println("Error Cant Save Avatar!" + ex.getMessage());
        }
        return null;
    }*/
    
      private static final String LIST_USER = "select[Email], [LastName],[FirstName] ,[Avatar]\n"
            + "from [dbo].[User] join [dbo].[Recipe]\n"
            + "on [dbo].[User].ID =[dbo].[Recipe].[UserID]\n"
            + "where [dbo].[Recipe].[ID]= ?";
     public  User listUser(int recipeID) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_USER);
                ptm.setInt(1, recipeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String lastName = rs.getString("LastName");
                    String email = rs.getString("Email");
                    String firstName = rs.getString("FirstName");
                    String Avatar = rs.getString("Avatar");
                    user = new User(email, Avatar, firstName, lastName);
                }
            }
        } catch (Exception e) {
            System.out.println("System have a problem");
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
        return user;
    }
    
    public static void main(String[] args) {
        getUserByID(3);
    }

}
