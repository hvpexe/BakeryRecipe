/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.sql.Date;
import java.util.ArrayList;


/**
 *
 * @author kichi
 */
public class Recipe {
    private int ID;
    private String Name;
    private String Description;
    private int Like;
    private int Dislike;
    private Date DatePost;
    private Date LastDateEdit;
    private int PrepTime;
    private int CookTime;
    private int Saved;
    private boolean IsDeleted;
    private int UserID;
    private ArrayList<String> img;
    private ArrayList<String> video;

    public ArrayList<String> getVideo() {
        return video;
    }

    public void setVideo(ArrayList<String> video) {
        this.video = video;
    }
    private String username;

    public Recipe() {
    }

    public Recipe(int ID, String Name, String Description, int Like, int Dislike, Date DatePost, Date LastDateEdit, int PrepTime, int CookTime, int Saved, int UserID, ArrayList<String> img, String username) {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.Like = Like;
        this.Dislike = Dislike;
        this.DatePost = DatePost;
        this.LastDateEdit = LastDateEdit;
        this.PrepTime = PrepTime;
        this.CookTime = CookTime;
        this.Saved = Saved;
        this.UserID = UserID;
        this.img = img;
        this.username = username;
    }

    

    public ArrayList<String> getImg() {
        return img;
    }

    public void setImg(ArrayList<String> img) {
        this.img = img;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getLike() {
        return Like;
    }

    public void setLike(int Like) {
        this.Like = Like;
    }

    public int getDislike() {
        return Dislike;
    }

    public void setDislike(int Dislike) {
        this.Dislike = Dislike;
    }

    public Date getDatePost() {
        return DatePost;
    }

    public void setDatePost(Date DatePost) {
        this.DatePost = DatePost;
    }

    public Date getLastDateEdit() {
        return LastDateEdit;
    }

    public void setLastDateEdit(Date LastDateEdit) {
        this.LastDateEdit = LastDateEdit;
    }

    public int getPrepTime() {
        return PrepTime;
    }

    public void setPrepTime(int PrepTime) {
        this.PrepTime = PrepTime;
    }

    public int getCookTime() {
        return CookTime;
    }

    public void setCookTime(int CookTime) {
        this.CookTime = CookTime;
    }

    public int getSaved() {
        return Saved;
    }

    public void setSaved(int Saved) {
        this.Saved = Saved;
    }

    public boolean isIsDeleted() {
        return IsDeleted;
    }

    public void setIsDeleted(boolean IsDeleted) {
        this.IsDeleted = IsDeleted;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    @Override
    public String toString() {
        return "Recipe{" + "ID=" + ID + ", Name=" + Name + ", Description=" + Description + ", Like=" + Like + ", Dislike=" + Dislike + ", DatePost=" + DatePost + ", LastDateEdit=" + LastDateEdit + ", PrepTime=" + PrepTime + ", CookTime=" + CookTime + ", Saved=" + Saved + ", IsDeleted=" + IsDeleted + ", UserID=" + UserID + ", img=" + img + ", username=" + username + '}';
    }

    
    
}
