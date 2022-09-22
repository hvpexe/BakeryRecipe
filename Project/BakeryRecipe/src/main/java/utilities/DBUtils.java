package utilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DUNGHUYNH
 */
public class DBUtils {

    private static Connection conn;
    private final static String serverName = "localhost";
    private final static String dbName = "BakeryRecipe";
    private final static String portNumber = "1433";
    private final static String instance = "";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final static String userID = "sa";
    private final static String password = "12345";

    public static Connection getConnection() {
        try {
            if (conn != null) {
                return conn;
            }
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
            if (instance == null || instance.trim().isEmpty()) {
                url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
            }
            url += ";encrypt=true;trustServerCertificate=true;CharacterSet=UTF-8";//important to add UTF-8 format
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return (conn = DriverManager.getConnection(url, userID, password)) != null ? conn : null;
        } catch (SQLException ex) {
            System.out.println("Connection error! " + ex.getMessage());
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Connection error! " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(
                "-------------------------\n\n\n\n\n" + DBUtils.getConnection()+"\n\"-------------------------\\n\\n\\n\\n\\n\"");
    }
}
