/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import static dto.Recipe.COVER_PATH;
import static dto.User.DEFAULT_AVATAR;
import static dto.User.IMG_PATH;
import java.sql.Date;

/**
 *
 * @author VO MINH MAN
 */
public class Report {
    
    public static final String IMG_PATH = User.IMG_PATH;
    public static final String DEFAULT_AVATAR = User.DEFAULT_AVATAR;
    public static final String COVER_PATH = Picture.IMG_PATH;

    private int id; //id cua report
    private Date DateReport;
    private String detail;
    private int userID; //id cua reporter
    private String reportType;
    private String status;
    private String reporter;
    private String comment;
    private String recipeTitle;
    private String cover;//anh chinh cua recipe
    private int recipeID;
    private int userid2; //id cua user
    private String username;
    private String avatar;//avatar cua user
    
    public Report() {
    }

    public Report(int id, Date DateReport, String detail, int userID, String reportType, String status, String reporter, String comment) {
        this.id = id;
        this.DateReport = DateReport;
        this.detail = detail;
        this.userID = userID;
        this.reportType = reportType;
        this.status = status;
        this.reporter = reporter;
        this.comment = comment;
        
    }

    public Report(int id, Date DateReport, String detail, int userID, String reportType, String status, String reporter, String recipeTitle, String cover, int recipeID) {
        this.id = id;
        this.DateReport = DateReport;
        this.detail = detail;
        this.userID = userID;
        this.reportType = reportType;
        this.status = status;
        this.reporter = reporter;
        this.recipeTitle = recipeTitle;
        this.cover = cover;
        this.recipeID = recipeID;
    }

    public Report(int id, Date DateReport, String detail, int userID, String reportType, String status, String reporter, int userid2, String username, String avatar) {
        this.id = id;
        this.DateReport = DateReport;
        this.detail = detail;
        this.userID = userID;
        this.reportType = reportType;
        this.status = status;
        this.reporter = reporter;
        this.userid2 = userid2;
        this.username = username;
        this.avatar = avatar;
    }

    
    
    

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public String getCover() {
        return COVER_PATH + cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getUserid2() {
        return userid2;
    }

    public void setUserid2(int userid2) {
        this.userid2 = userid2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        if (avatar == null) {
            return DEFAULT_AVATAR;
        }
        return IMG_PATH + avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
    public Date getDateReport() {
        return DateReport;
    }

    public void setDateReport(Date DateReport) {
        this.DateReport = DateReport;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public Report(int id, Date DateReport, String detail, int userID, String reportType) {
        this.id = id;
        this.DateReport = DateReport;
        this.detail = detail;
        this.userID = userID;
        this.reportType = reportType;
    }

}
