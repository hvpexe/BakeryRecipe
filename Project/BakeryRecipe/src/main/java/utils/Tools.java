/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.sql.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class Tools {

    /**
     * To UTF-8 format
     * this method change the format of a ISO-8859-1 to UTF-8 String
     *
     * @param input an ISO-8859-1 format string
     *
     * @return UTF-8 String
     */
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

    /**
     * To UTF-8 format
     * this method change the format of an array of String[] ISO-8859-1 to
     * an UTF-8 String[]
     *
     * @param input an ISO-8859-1 format String[]
     *
     * @return UTF-8 String[]
     */
    public static String[] toUTF8 (String[] inputs) {

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = toUTF8(inputs[i]);
            System.out.println(inputs[i] + "+A");
        }
        return inputs;
    }

    /**
     * Create a folder if folder empty
     *
     * @param filePath
     *
     * @return the Folder created
     */
    public static File getFolderUpload (String filePath) {
        File folderUpload = new File(filePath);
        if (!folderUpload.exists())
            folderUpload.mkdirs();
        return folderUpload;
    }

//    public static String getTodayDate() {
//        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//    }
    /**
     * Get Current Date
     *
     * @return TimeStamp of Current Date
     */
    public static Timestamp getCurrentDateTime () {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * Cast Date class to Timestamp Class
     *
     * @return the TimeStamp
     */
    public static Timestamp dateToTimestamp (Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * Cast Timestamp class to Date Class
     *
     * @return the Date
     */
    public static Date timestampToDate (Timestamp time) {
        return new Date(time.getTime());
    }

    private static final long SECOND = 1000;
    private static final long MINUTE = SECOND * 60;
    private static final long HOUR = MINUTE * 60;
    private static final long DAY = HOUR * 24;
    private static final long WEEK = DAY * 7;
    private static final long MONTH = DAY * 30;
    private static final long YEAR = DAY * 365;
    /** Format Date
     * this method return the string that told us 
     * how long the time has passed
     * @param time the time when it's started
     * @return number + times + ago
     */
    public static String formatDate (Timestamp time) {
        if (time == null)
            return null;

        String seperatedTimeString = "Just Now";
        Long seperatedTime = null;
        Timestamp currentTime = getCurrentDateTime();
        String timeText = null;
        Long resultTime = null;

        seperatedTime = (currentTime.getTime() - time.getTime());
        if (seperatedTime > 10 * SECOND) {
            timeText = "seconds";
            resultTime = seperatedTime / SECOND;
        } else {
            return seperatedTimeString;
        }
        if (seperatedTime >= MINUTE) {
            timeText = "minute" + (seperatedTime >= 2 * MINUTE ? "s" : "");
            resultTime = seperatedTime / MINUTE;

        }
        if (seperatedTime >= HOUR) {
            timeText = "hour" + (seperatedTime >= 2 * HOUR ? "s" : "");
            resultTime = seperatedTime / HOUR;
        }
        if (seperatedTime >= DAY) {
            timeText = "day" + (seperatedTime >= 2 * DAY ? "s" : "");
            resultTime = seperatedTime / DAY;
        }
        if (seperatedTime >= WEEK) {
            timeText = "week" + (seperatedTime >= 2 * WEEK ? "s" : "");
            resultTime = seperatedTime / WEEK;
        }

        if (seperatedTime >= MONTH) {
            timeText = "month" + (seperatedTime >= 2 * MONTH ? "s" : "");
            resultTime = seperatedTime / MONTH;
        }
        if (seperatedTime >= YEAR) {
            timeText = "year" + (seperatedTime >= 2 * YEAR ? "s" : "");
            resultTime = seperatedTime / YEAR;
        }
        seperatedTimeString = resultTime + " " + timeText + " ago";
        return seperatedTimeString;
    }

    /** Check string is null or empty
     * do exactly what the function said
     * @param string the String
     * @return True or false
     */
    public static Boolean isNullOrEmpty (String string) {
        return string == null || string.trim().isEmpty();
    }
    /** Save File
     * Save a file with <code>filename</code> to a <code>filepath</code>
     * @param fileName the file name that we want to save
     * @param partFile the input stream of the file 
     * @param sc the servlet context to get the absolute path
     * @param filePath the path to save the file
     * @return <b>filename</b> with png, jpeg,... format
     * @throws IOException  
     */
    public static String saveFile (String fileName, Part partFile, ServletContext sc, String filePath) throws IOException {
        InputStream is = null;
        String savedFilePath;
        try {
            is = partFile.getInputStream();
            savedFilePath = "/" + filePath;
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

            f = new File(buildFilePath);
            partFile.write(webFilePath + fileName);
            if (f.exists())
                partFile.write(buildFilePath + fileName);
            System.out.println("path: " + savedFilePath + fileName);

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
    /**Save Image from URL
     * Save a file with <code>filename</code> to a <code>filepath</code>
     * @param imageUrl the URL
     * @param savedFileName the saved filename
     * @param sc the servlet context
     * @param imagePath the file path
     * @return a filename with png, jpeg, ... format
     * @throws IOException 
     */
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
    /** Get File Type
     * get the file type
     * @param filename
     * @param file
     * @return the filename with the file type
     */
    public static String getFileType (String filename, String file) {
        if (file == null)
            return null;
        file = new File(file).getName();
        filename += file.substring(file.indexOf('.'), file.length());//get the '.' part
        return filename;
    }
/** Get File Type
     * get the file type
     * @param filename
     * @param partFile 
     * @return the filename with the file type
     */
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

    public static String renameFile (String oldname, String newname, ServletContext sc, String filePath) throws IOException {
        // File (or directory) with old name
        if (oldname == null)
            return null;
        oldname = new File(oldname).getName();// in case of file with path name 
        String webFilePath = sc.getRealPath(filePath);
        String buildFilePath = webFilePath.
                replace("\\target\\BakeryRecipe-1.0-SNAPSHOT\\", "\\src\\main\\webapp\\");
        File fileo1 = new File(webFilePath + oldname);

        newname += oldname.substring(oldname.indexOf('.'), oldname.length());//get the '.' part
        if (oldname.equals(newname)) {
            return null;
        }
        Tools.getFolderUpload(webFilePath);
        Tools.getFolderUpload(buildFilePath);
//        System.out.println(webFilePath + oldname);
        File fileo2 = new File(buildFilePath);
        if (!fileo2.exists()) {
//            System.out.println("file not exist");
            return null;
        }
        // File (or directory) with new name
        File fileRename = new File(webFilePath + newname);
        System.out.println("o: " + oldname);
        System.out.println("n: " + newname);
        // Rename file (or directory)
        if (fileRename.exists()) {
            System.out.println(fileRename.getAbsoluteFile());
            fileRename.delete();
        }
        boolean success1 = fileo1.renameTo(fileRename);

        fileRename = new File(buildFilePath + newname);
        boolean success2 = fileo2.renameTo(fileRename);
        if (!success1 || !success2) {
            // File was not successfully renamed
            throw new IOException("File " + oldname + " was not successfully renamed");
        }
        return newname;
    }

}
