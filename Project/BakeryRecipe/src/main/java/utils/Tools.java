/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.checkerframework.checker.units.qual.A;

/**
 *
 * @author Admin
 */
public class Tools {

    public static String toUTF8 (String input) {
        try {
            String result = URLEncoder.encode(input, "ISO-8859-1");
            result = URLDecoder.decode(result, "UTF-8");
            return result;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static String[] toUTF8 (String[] inputs) {

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = toUTF8(inputs[i]);
            System.out.println(inputs[i] + "+A");
        }
        return inputs;
    }

    public static File getFolderUpload (String filePath) {
        File folderUpload = new File(filePath);
        if (!folderUpload.exists())
            folderUpload.mkdirs();
        return folderUpload;
    }

//    public static String getTodayDate() {
//        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//    }
    public static Timestamp getCurrentDateTime () {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp dateToTimestamp (Date date) {
        return new Timestamp(date.getTime());
    }

    public static Date timestampToDate (Timestamp time) {
        return new Date(time.getTime());
    }

    public static String formatDate (Timestamp time) {
        SimpleDateFormat dt = new SimpleDateFormat("mm:HH E dd-MM-yyyy");
        return dt.format(time);
    }

    /**
     * do exactly what the function said
     */
    public static Boolean isNullOrEmpty (String string) {
        return string == null || string.trim().isEmpty();
    }

    public static String saveFile (String fileName, Part partFile, ServletContext sc, String filePath) throws IOException {
        InputStream is = null;
        String savedFilePath;
        try {
            is = partFile.getInputStream();
            savedFilePath = "/" + filePath ;
            if (fileName == null)
                return null;
            fileName = getFileType(fileName, partFile);
            String webFilePath = sc.getRealPath(savedFilePath);
            String buildFilePath = webFilePath.
                    replace("\\target\\BakeryRecipe-1.0-SNAPSHOT\\", "\\src\\main\\webapp\\");
            Tools.getFolderUpload(webFilePath);
//absoluteFilepath = D:\learning in FPT\Ky_5\SWP391\BakeryRecipe\Project\BakeryRecipe\target\BakeryRecipe-1.0-SNAPSHOT\assets\images\avt
//webFilepath = D:\learning in FPT\Ky_5\SWP391\BakeryRecipe\Project\BakeryRecipe\src\main\webapp\assets\images\avt

            File f = new File(webFilePath);
            if (!f.exists())
                f.mkdirs();
            f = new File(buildFilePath);
            partFile.write(webFilePath+fileName);
            if (f.exists())
                partFile.write(buildFilePath+fileName);
            System.out.println("path: " + savedFilePath+fileName);

            return fileName;
        } catch (IOException ex) {
            System.out.println("Error Cant Save to " + filePath + fileName + "! " + ex.getMessage());
        } finally {
            if (is != null) {
                is.close();
            }
        }
        return null;
    }

    public static String saveImagefromURL (String imageUrl, String savedFileName, ServletContext sc, String imagePath) throws IOException {
        BufferedImage image = null;
        String webFilePath = null;
        String buildFilePath = null;
        File imageFile = null;

        try {

            URL url = new URL(imageUrl);
            // read the url
            image = ImageIO.read(url);
            webFilePath = sc.getRealPath(imagePath);
            imageFile = new File(webFilePath + savedFileName);
            System.out.println(webFilePath + savedFileName);
            ImageIO.write(image, "png", imageFile);

            buildFilePath = webFilePath.replace("\\target\\BakeryRecipe-1.0-SNAPSHOT\\", "\\src\\main\\webapp\\");
            imageFile = new File(buildFilePath + savedFileName);
            if (new File(buildFilePath).exists())
                ImageIO.write(image, "png", imageFile);
            return savedFileName;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }

    public static String getFileType (String filename, Part partFile) {
        String submittedFileName = null;
        File f = null;
        submittedFileName = partFile.getSubmittedFileName();
        f = new File(submittedFileName);
        if (submittedFileName.isEmpty())
            return null;
        // refines the fileName in case it is an absolute path
        submittedFileName = f.getName();
        filename += submittedFileName.substring(submittedFileName.indexOf('.'), submittedFileName.length());//get the '.' part
        return filename;

    }
}
