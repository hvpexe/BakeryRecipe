/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static void main(String[] args) {
        System.out.println(getNumberFollow());
    }
}
