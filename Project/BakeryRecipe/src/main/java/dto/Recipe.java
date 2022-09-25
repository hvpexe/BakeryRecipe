/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import net.sourceforge.jtds.jdbc.DateTime;

/**
 *
 * @author kichi
 */
public class Recipe {
    private int id;
    private String name;
    private String description;
    private int like;
    private int dislike;
    private DateTime datePost;
    private DateTime lastDateEdit;
    private int prepTime;
    private int cookTime;
    private int saved;
    private boolean isDeleted;
    private int userID;

    public Recipe() {
    }

    public Recipe(int id, String name, String description, int like, int dislike, DateTime datePost, DateTime lastDateEdit, int prepTime, int cookTime, int saved, boolean isDeleted, int userID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.like = like;
        this.dislike = dislike;
        this.datePost = datePost;
        this.lastDateEdit = lastDateEdit;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.saved = saved;
        this.isDeleted = isDeleted;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public DateTime getDatePost() {
        return datePost;
    }

    public void setDatePost(DateTime datePost) {
        this.datePost = datePost;
    }

    public DateTime getLastDateEdit() {
        return lastDateEdit;
    }

    public void setLastDateEdit(DateTime lastDateEdit) {
        this.lastDateEdit = lastDateEdit;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getSaved() {
        return saved;
    }

    public void setSaved(int saved) {
        this.saved = saved;
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
    
}
