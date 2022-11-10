/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Date;
 

/**
 *
 * @author Admin
 */
public class Notify {

   
    private int notifyID;
    private int senderID ;
    private int recipeID;
    private int CommentID;

    public Notify(int notifyID, int senderID, int receiverID, String typeofNotify, Date DateReceive, boolean isSeen, boolean isDelete) {
        this.notifyID = notifyID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.typeofNotify = typeofNotify;
        this.DateReceive = DateReceive;
        this.isSeen = isSeen;
        this.isDelete = isDelete;
    }
    private int receiverID;
    private String typeofNotify;
    private Date DateReceive;
    private boolean isSeen;
    private boolean isDelete;
    private String  nameofSender;
    private String  coverfSender;
    private String nameofRecipe;

    public Notify(int notifyID, int senderID, int recipeID, int CommentID, int receiverID, String typeofNotify, Date DateReceive, boolean isSeen, boolean isDelete, String nameofSender, String coverfSender, String nameofRecipe) {
        this.notifyID = notifyID;
        this.senderID = senderID;
        this.recipeID = recipeID;
        this.CommentID = CommentID;
        this.receiverID = receiverID;
        this.typeofNotify = typeofNotify;
        this.DateReceive = DateReceive;
        this.isSeen = isSeen;
        this.isDelete = isDelete;
        this.nameofSender = nameofSender;
        this.coverfSender = coverfSender;
        this.nameofRecipe = nameofRecipe;
    }

    @Override
    public String toString() {
        return "Notify{" + "notifyID=" + notifyID + ", senderID=" + senderID + ", recipeID=" + recipeID + ", CommentID=" + CommentID + ", receiverID=" + receiverID + ", typeofNotify=" + typeofNotify + ", DateReceive=" + DateReceive + ", isSeen=" + isSeen + ", isDelete=" + isDelete + ", nameofSender=" + nameofSender + ", coverfSender=" + coverfSender + ", nameofRecipe=" + nameofRecipe + '}';
    }

    public String getNameofRecipe() {
        return nameofRecipe;
    }

    public void setNameofRecipe(String nameofRecipe) {
        this.nameofRecipe = nameofRecipe;
    }

    public String getNameofSender() {
        return nameofSender;
    }

    public void setNameofSender(String nameofSender) {
        this.nameofSender = nameofSender;
    }

    public String getCoverfSender() {
        return coverfSender;
    }

    public void setCoverfSender(String coverfSender) {
        this.coverfSender = coverfSender;
    }

    public Notify(int notifyID, int senderID, int recipeID, int CommentID, int receiverID, String typeofNotify, Date DateReceive, boolean isSeen, boolean isDelete, String nameofSender, String coverfSender) {
        this.notifyID = notifyID;
        this.senderID = senderID;
        this.recipeID = recipeID;
        this.CommentID = CommentID;
        this.receiverID = receiverID;
        this.typeofNotify = typeofNotify;
        this.DateReceive = DateReceive;
        this.isSeen = isSeen;
        this.isDelete = isDelete;
        this.nameofSender = nameofSender;
        this.coverfSender = coverfSender;
    }

    public Notify(int notifyID, int senderID, int recipeID, int CommentID, int receiverID, String typeofNotify, Date DateReceive, boolean isSeen, boolean isDelete) {
        this.notifyID = notifyID;
        this.senderID = senderID;
        this.recipeID = recipeID;
        this.CommentID = CommentID;
        this.receiverID = receiverID;
        this.typeofNotify = typeofNotify;
        this.DateReceive = DateReceive;
        this.isSeen = isSeen;
        this.isDelete = isDelete;
    }

    public Notify(int notifyID, int senderID, int recipeID, int receiverID, String typeofNotify, Date DateReceive, boolean isSeen, boolean isDelete) {
        this.notifyID = notifyID;
        this.senderID = senderID;
        this.recipeID = recipeID;
        this.receiverID = receiverID;
        this.typeofNotify = typeofNotify;
        this.DateReceive = DateReceive;
        this.isSeen = isSeen;
        this.isDelete = isDelete;
    }

    public Notify() {
    }

    public int getNotifyID() {
        return notifyID;
    }

    public void setNotifyID(int notifyID) {
        this.notifyID = notifyID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int CommentID) {
        this.CommentID = CommentID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public String getTypeofNotify() {
        return typeofNotify;
    }

    public void setTypeofNotify(String typeofNotify) {
        this.typeofNotify = typeofNotify;
    }

    public Date getDateReceive() {
        return DateReceive;
    }

    public void setDateReceive(Date DateReceive) {
        this.DateReceive = DateReceive;
    }

    public boolean isIsSeen() {
        return isSeen;
    }

    public void setIsSeen(boolean isSeen) {
        this.isSeen = isSeen;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

   
    
    

}
