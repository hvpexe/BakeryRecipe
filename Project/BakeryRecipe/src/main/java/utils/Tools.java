/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

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

    /**
     * do exactly what the function said
     */
    public static Boolean isNullOrEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

    public static String saveFile(String filename, Part file, ServletContext sc, String filePath) {
        try {
            String fileName = file.getSubmittedFileName();
            if (fileName.isEmpty()) {
                return null;
            }
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            filename += fileName.substring(fileName.indexOf('.'), fileName.length());
            String absoluteFilepath = sc.getRealPath("/" + filePath);
            //D:\learning in FPT\Tools\UploadFile\build\web\images
            String webFilepath = absoluteFilepath.replace("\\build", "");
//            Tools.getFolderUpload(absoluteFilepath);
//            Tools.getFolderUpload(webFilepath);
//            System.out.println(id + "\n-" + absoluteFilepath + id + "\n-" + webFilepath + id);
//        C:\Users\Admin\Documents\Github2\prj301-se1609-05\BOOKZ\Bookz\build\web\assets\images\bookCover\
            file.write(absoluteFilepath + filename);
            file.write(webFilepath + filename);
            System.out.println("path: " + filePath + filename);
            return filePath + filename;
        } catch (IOException ex) {
            System.out.println("Error Cant Save to " + filePath + filename + "! " + ex.getMessage());
        }
        return null;
    }

    public static String saveImagefromURL(String imageUrl, String fileName, ServletContext sc, String imagePath) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();//get inputstream
        String realPath = sc.getRealPath(imagePath);
        String savedPath = realPath + fileName;
        //new type of file writer
        OutputStream os = new FileOutputStream(savedPath);
        byte[] b = new byte[2048];
        int length;
        //write the file 
        //it's not long this is what the saveFile function do to
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
        return fileName;
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);
    }
}
