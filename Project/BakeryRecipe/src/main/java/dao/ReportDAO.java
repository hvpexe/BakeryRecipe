/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Report;
import dto.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author VO MINH MAN
 */
public class ReportDAO {

    private static final String ADD_REPORT_RECIPE = "insert into [dbo].[ReportRecipe]([DateReport],[Detail],[RecipeID],[UserID],[ReportType],[Status]) \n"
            + "            values (?,?,?,?,?,'Process')";

    public static boolean addReport(int bakerID, int recipeID, String detail, String reportType) throws SQLException {
        Connection cnn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean check = false;
        int random_int = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String date = dateFormat.format(currentDate);
        try {
            cnn = DBUtils.getConnection();
            ptm = cnn.prepareCall(ADD_REPORT_RECIPE);

            ptm.setString(1, date);
            ptm.setString(2, detail);
            ptm.setInt(3, recipeID);
            ptm.setInt(4, bakerID);
            ptm.setString(5, reportType);
            check = ptm.executeUpdate() > 0 ? true : false;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return check;
    }

    private static final String ADD_REPORT_COMMENT = "	insert into [dbo].[ReportComment]([DateReport],\n"
            + "             [Detail],[CommentID],[UserID],[ReportType],[Status]) values (?,?,?,?,?,'Process')";

    public static boolean reportCMT(String detailCMT, int CommentID, int userID, String reportType) throws SQLException {
        Connection cn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String date = dateFormat.format(currentDate);
        try {
            cn = DBUtils.getConnection();
            ptm = cn.prepareStatement(ADD_REPORT_COMMENT);
            ptm.setString(1, date);
            ptm.setString(2, detailCMT);
            ptm.setInt(3, CommentID);
            ptm.setInt(4, userID);
            ptm.setString(5, reportType);
            check = ptm.executeUpdate() > 0 ? true : false;
        } catch (Exception e) {
        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }

    private static final String REPORT_USER = "	 insert into [dbo].[ReportUser]([Detail],[UserID],[UserID2],[DateReport],[ReportType],[Status])\n"
            + "			 values (?,?,?,?,?,'Process')";

    public static boolean reportUser(String detailReport, int userReport, int userReported, String reportType) throws SQLException {
        boolean check = false;
        Connection cnn = null;
        PreparedStatement ptm = null;
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String date = dateFormat.format(currentDate);
        try {
            cnn = DBUtils.getConnection();
            ptm = cnn.prepareStatement(REPORT_USER);
            ptm.setString(1, detailReport);
            ptm.setInt(2, userReport);
            ptm.setInt(3, userReported);
            ptm.setString(4, date);
            ptm.setString(5, reportType);
            check = ptm.executeUpdate() > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return check;
    }

    private static final String SHOW_REPORT_COMM_LIST = "SELECT [ReportComment].ID, [ReportComment].Detail, \n"
            + "            [ReportComment].DateReport, [ReportComment].ReportType, \n"
            + "            [ReportComment].[Status], \n"
            + "            [ReportComment].UserID, [User].LastName + ' ' + [User].FirstName AS Reporter, \n"
            + "            [Comment].Comment, [Comment].ID AS commentID, Comment.IsDeleted\n"
            + "            FROM [ReportComment]\n"
            + "            JOIN [User] ON [ReportComment].UserID = [User].ID\n"
            + "            JOIN [Comment] ON [Comment].ID = [ReportComment].CommentID\n"
            + "            ORDER BY [ReportComment].DateReport ASC";

    public static List<Report> reportCMTList() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(SHOW_REPORT_COMM_LIST);
            rs = ps.executeQuery();
            List<Report> list = new ArrayList<>();
            while (rs.next()) {
                Report reportCMT = new Report(rs.getInt("ID"),
                        rs.getTimestamp("DateReport"),
                        rs.getString("Detail"),
                        rs.getInt("UserID"),
                        rs.getString("ReportType"),
                        rs.getString("Status"),
                        rs.getString("Reporter"),
                        rs.getString("Comment"),
                        rs.getInt("commentID"),
                        rs.getBoolean("IsActive"));
                list.add(reportCMT);
            }
            return list;
        } catch (Exception ex) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    private static final String SHOW_REPORT_RECIPE_LIST = "SELECT [ReportRecipe].ID, [ReportRecipe].DateReport, \n"
            + "            [ReportRecipe].Detail, [ReportRecipe].ReportType, \n"
            + "            [ReportRecipe].[Status], [ReportRecipe].UserID, \n"
            + "            [User].LastName + ' ' + [User].FirstName AS Reporter, [Recipe].[Name], \n"
            + "            [Picture].Img, [ReportRecipe].RecipeID, [Recipe].IsDeleted\n"
            + "            FROM [ReportRecipe]\n"
            + "            JOIN [User] ON [ReportRecipe].UserID = [User].ID\n"
            + "            JOIN [Recipe] ON [ReportRecipe].RecipeID = [Recipe].ID\n"
            + "            JOIN [Picture] ON [Picture].RecipeID = [Recipe].ID\n"
            + "            WHERE [Picture].IsCover = 1\n"
            + "            ORDER BY [ReportRecipe].DateReport ASC";

    public static List<Report> reportRecipeList() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(SHOW_REPORT_RECIPE_LIST);
            rs = ps.executeQuery();
            List<Report> list = new ArrayList<>();
            while (rs.next()) {
                Report report = new Report(rs.getInt("ID"),
                        rs.getTimestamp("DateReport"),
                        rs.getString("Detail"),
                        rs.getInt("UserID"),
                        rs.getString("ReportType"),
                        rs.getString("Status"),
                        rs.getString("Reporter"),
                        rs.getString("Name"),
                        rs.getString("Img"),
                        rs.getInt("RecipeID"),
                        rs.getBoolean("IsDeleted"));
                list.add(report);
            }
            return list;
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    private static final String SHOW_REPORT_USER_LIST = "SELECT [ReportUser].ID, [ReportUser].DateReport, \n"
            + "            [ReportUser].Detail, [ReportUser].ReportType, \n"
            + "            [ReportUser].[Status], [ReportUser].UserID AS ReporterID, \n"
            + "            [ReportUser].UserID2 AS UserID, [User].LastName + ' ' + [User].FirstName AS Username, \n"
            + "            [User].Avatar, [User].[Role], [User].IsActive\n"
            + "            FROM [ReportUser]\n"
            + "            JOIN [User] ON [ReportUser].UserID2 = [User].ID\n"
            + "            ORDER BY [ReportUser].DateReport ASC";

    public static List<Report> reportUserList() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(SHOW_REPORT_USER_LIST);
            rs = ps.executeQuery();
            List<Report> list = new ArrayList<>();
            while (rs.next()) {
                User reporter = UserDAO.getUserByID(rs.getInt("ReporterID"));
                String fullname = reporter.getLastName() + ' ' + reporter.getFirstName();
                Report report = new Report(rs.getInt("ID"),
                        rs.getTimestamp("DateReport"),
                        rs.getString("Detail"),
                        rs.getInt("ReporterID"),
                        rs.getString("ReportType"),
                        rs.getString("Status"),
                        fullname,
                        rs.getInt("UserID"),
                        rs.getString("Username"),
                        rs.getString("Avatar"),
                        rs.getString("Role"),
                        rs.getBoolean("IsActive"));
                list.add(report);
            }
            return list;
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
}
