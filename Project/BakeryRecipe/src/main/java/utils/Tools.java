/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Tools {

    public static String toUTF8(String firstname) {
        try {
            String result = URLEncoder.encode(firstname, "ISO-8859-1");
            result = URLDecoder.decode(result, "UTF-8");
            return result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static File getFolderUpload(String filePath) {
        File folderUpload = new File(filePath);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

//    public static String getTodayDate() {
//        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//    }
    public static Timestamp getCurrentDateTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp dateToTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    public static Date timestampToDate(Timestamp time) {
        return new Date(time.getTime());
    }

    public static String formatDate(Timestamp time) {
        SimpleDateFormat dt = new SimpleDateFormat("mm:HH E dd-MM-yyyy");
        return dt.format(time);
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println(toUTF8("Nguá»?n"));
    }
}
