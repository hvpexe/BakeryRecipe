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

    private String id;
    private Date DateReport;
    private String detasil;
    private int userID;
    private String reportType;

    public Report() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Report(String id, Date DateReport, String detail, int userID, String reportType) {
        this.id = id;
        this.DateReport = DateReport;
        this.detail = detail;
        this.userID = userID;
        this.reportType = reportType;
    }

}
