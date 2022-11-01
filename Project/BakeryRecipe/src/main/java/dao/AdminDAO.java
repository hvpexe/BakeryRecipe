/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static int getNumberUserActive() {
        String sql = "SELECT COUNT(U.ID)\n"
                + "FROM [User] U\n"
                + "WHERE U.IsActive = 1";
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberUserActive error:");
            e.printStackTrace();
        }
        return count;
    }

    public static int getNumberRecipeAvailable() {
        String sql = "SELECT COUNT(ID)\n"
                + "FROM Recipe\n"
                + "WHERE IsDeleted = 0";
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberRecipeAvailable error:");
            e.printStackTrace();
        }
        return count;
    }

    public static int getNumberCommentAvailable() {
        String sql = "SELECT COUNT(ID)\n"
                + "FROM Comment\n"
                + "WHERE IsDeleted = 0";
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberCommentAvailable error:");
            e.printStackTrace();
        }
        return count;
    }

    public static int getNumberLike() {
        String sql = "SELECT COUNT(*)\n"
                + "FROM [Like]";
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberLike error:");
            e.printStackTrace();
        }
        return count;
    }

    public static int getNumberSave() {
        String sql = "SELECT COUNT(*)\n"
                + "FROM [Save]";
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberSave error:");
            e.printStackTrace();
        }
        return count;
    }

    public static int getNumberFollow() {
        String sql = "SELECT COUNT(*)\n"
                + "FROM Follow";
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getNumberFollow error:");
            e.printStackTrace();
        }
        return count;
    }

    public static String getSumUserRegisterInMonthByYear(int year) {
        String sql = "SELECT YEAR(U.DateRegister) as yyyy,\n"
                + "       MONTH(U.DateRegister) as mm,\n"
                + "       COUNT(U.ID) as NoUser \n"
                + "FROM [User] U\n"
                + "WHERE YEAR(U.DateRegister) = ?\n"
                + "GROUP BY YEAR(U.DateRegister), MONTH(U.DateRegister)\n"
                + "ORDER BY YEAR(U.DateRegister), MONTH(U.DateRegister);";
        List<Integer> noUserByMonth = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();
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
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getSumUserRegisterInMonthByYear(2021));
    }
}
