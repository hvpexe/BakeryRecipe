/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Timestamp;

/**
 *
 * @author VO MINH MAN
 */
public class Comment {

    private int commentID;
    private String comment;
    private boolean rate;
    private Timestamp DateComment;
    private Timestamp LastDateEdit;
    private boolean isDeleted;
    private int userID;
    private int recipeID;
    private String avatar;
private String chefName;

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Comment(int commentID, String comment, String avatar) {
        this.commentID = commentID;
        this.comment = comment;
        this.avatar = avatar;
    }

    public Comment(int commentID, String comment, String avatar, String chefName) {
        this.commentID = commentID;
        this.comment = comment;
        this.avatar = avatar;
        this.chefName = chefName;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isRate() {
        return rate;
    }

    public void setRate(boolean rate) {
        this.rate = rate;
    }

    public Timestamp getDateComment() {
        return DateComment;
    }

    public void setDateComment(Timestamp DateComment) {
        this.DateComment = DateComment;
    }

    public Timestamp getLastDateEdit() {
        return LastDateEdit;
    }

    public void setLastDateEdit(Timestamp LastDateEdit) {
        this.LastDateEdit = LastDateEdit;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public Comment(int commentID, String comment, boolean rate, Timestamp DateComment, Timestamp LastDateEdit, boolean isDeleted, int userID, int recipeID) {
        this.commentID = commentID;
        this.comment = comment;
        this.rate = rate;
        this.DateComment = DateComment;
        this.LastDateEdit = LastDateEdit;
        this.isDeleted = isDeleted;
        this.userID = userID;
        this.recipeID = recipeID;
    }

    public Comment() {
    }

}
