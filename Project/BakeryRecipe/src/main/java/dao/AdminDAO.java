/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.json.simple.JSONValue;
import utils.DBUtils;

/**
 *
 * @author PhuHV
 */
public class AdminDAO {

    private static Connection conn = DBUtils.getConnection();

    public static int getNumberUserActive () throws SQLException {
        String sql = "SELECT COUNT(U.ID)\n"
                + "FROM [User] U\n"
                + "WHERE U.IsActive = 1";
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberUserActive error:");
            e.printStackTrace();
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
        return count;
    }

    public static int getNumberRecipeAvailable () throws SQLException {
        String sql = "SELECT COUNT(ID)\n"
                + "FROM Recipe\n"
                + "WHERE IsDeleted = 0";
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberRecipeAvailable error:");
            e.printStackTrace();
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
        return count;
    }

    public static int getNumberCommentAvailable () throws SQLException {
        String sql = "SELECT COUNT(ID)\n"
                + "FROM Comment\n"
                + "WHERE IsDeleted = 0";
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberCommentAvailable error:");
            e.printStackTrace();
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
        return count;
    }

    public static int getNumberLike () throws SQLException {
        String sql = "SELECT COUNT(*)\n"
                + "FROM [Like]";
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberLike error:");
            e.printStackTrace();
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
        return count;
    }

    public static int getNumberSave () throws SQLException {
        String sql = "SELECT COUNT(*)\n"
                + "FROM [Save]";
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberSave error:");
            e.printStackTrace();
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
        return count;
    }

    public static int getNumberFollow () throws SQLException {
        String sql = "SELECT COUNT(*)\n"
                + "FROM Follow";
        int count = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberFollow error:");
            e.printStackTrace();
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
        return count;
    }

    public static String getSumUserRegisterInMonthByYear (int year) throws SQLException {
        String sql = "SELECT YEAR(U.DateRegister) as yyyy,\n"
                + "       MONTH(U.DateRegister) as mm,\n"
                + "       COUNT(U.ID) as NoUser \n"
                + "FROM [User] U\n"
                + "WHERE YEAR(U.DateRegister) = ?\n"
                + "GROUP BY YEAR(U.DateRegister), MONTH(U.DateRegister)\n"
                + "ORDER BY YEAR(U.DateRegister), MONTH(U.DateRegister);";
        List<Integer> noUserByMonth = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, year);
            rs = ps.executeQuery();
            int[] noUserByMonthTemp = new int[12];
            while (rs.next()) {
                int mm = (Integer) rs.getInt("mm");
                int noUser = (Integer) rs.getInt("noUser");
                noUserByMonthTemp[mm - 1] = noUser;
            }
            int maxMonth;
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (year < currentYear) {
                maxMonth = 11;
            } else {
                maxMonth = Calendar.getInstance().get(Calendar.MONTH);
            }
            for (int i = 0; i <= maxMonth; i++) {
                noUserByMonth.add(noUserByMonthTemp[i]);
            }
            String jsonText = JSONValue.toJSONString(noUserByMonth);
            return jsonText;
        } catch (Exception e) {
            System.out.println("getSumUserRegisterInMonthByYear error:");
            e.printStackTrace();
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

    public static boolean updateStatusReport(int id, String status) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE [ReportComment]\n"
                        + "SET [Status] = ?\n"
                        + "WHERE [ReportComment].ID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, status);
                ps.setInt(2, id);
                check = ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println("Error at updateStatusReport: " + e.toString());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }

    public static void main (String[] args) throws SQLException {
        System.out.println(getSumUserRegisterInMonthByYear(2021));
    }
}
