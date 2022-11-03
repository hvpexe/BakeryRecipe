/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Date;

/**
 *
 * @author VO MINH MAN
 */
public class Report {

    private int id;
    private Date DateReport;
    private String detail;
    private int userID;
    private String reportType;
    private String status;
    private String reporter;
    private String comment;
    private int cmtID;
    public Report() {
    }

    public Report(int id, Date DateReport, String detail, int userID, String reportType, String status, String reporter, String comment, int cmtID) {
        this.id = id;
        this.DateReport = DateReport;
        this.detail = detail;
        this.userID = userID;
        this.reportType = reportType;
        this.status = status;
        this.reporter = reporter;
        this.comment = comment;
        this.cmtID = cmtID;
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

    public int getCmtID() {
        return cmtID;
    }

    public void setCmtID(int cmtID) {
        this.cmtID = cmtID;
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
