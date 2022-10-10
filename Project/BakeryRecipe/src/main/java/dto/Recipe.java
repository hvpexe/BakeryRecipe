/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import static dto.User.DEFAULT_AVATAR;
import static dto.User.IMG_PATH;
import java.sql.Timestamp;
import java.util.ArrayList;
import utils.Tools;

/**
 *
 * @author kichi
 */
public class Recipe {

    public static final String COVER_PATH = "assets/images/recipe/";

    private int id;
    private String name;
    private String description;
    private int like;
    private int save;
    private int comment;
    private Timestamp datePost; //timestamp mới thể hiện hết giờ phút giây, class Date ko làm đc
    private Timestamp lastDateEdit;
    private int prepTime;
    private int cookTime;
    private boolean isDeleted;
    private ArrayList<String> img; //field này dùng để lưu danh sách ảnh của recipe, dành cho trang detail
    private ArrayList<String> video; //field này dùng để lưu danh sách video oecipe, dành cho trang detail
    private String cover; //field này dùng để lưu ảnh cover
    private int userID; //id người đăng recipe
    private String avatar; //avatar của người đăng recipe
    private String username; //dùng để lưu cả lastname + firstname của user

    public Recipe() {
    }

    public Recipe(String name,String  cover, String username) {
        this.name = name;
        this.cover = cover;
        this.username = username;
    }

    public Recipe(int id, String name, String description, int like, int save, int comment, Timestamp datePost, Timestamp lastDateEdit, String cover, int userID, String username) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.like = like;
        this.save = save;
        this.comment = comment;
        this.datePost = datePost;
        this.lastDateEdit = lastDateEdit;
        this.cover = cover;
        this.userID = userID;
        this.username = username;
    }

    public Recipe(String name, int like, int comment, String cover, String username) {
        this.name = name;
        this.like = like;
        this.comment = comment;
        this.cover = cover;
        this.username = username;
    }

    public Recipe(String name, String description, int like, int save, int comment, int prepTime, int cookTime) {
        this.name = name;
        this.description = description;
        this.like = like;
        this.save = save;
        this.comment = comment;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
    }
    
    /**
     * constructor này dành cho post recipe trên trang home
     */
    public Recipe(int id, String name, String description, int like, int save, int comment, Timestamp datePost, String cover, int userID, String avatar, String username) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.like = like;
        this.save = save;
        this.comment = comment;
        this.datePost = datePost;
        this.cover = cover;
        this.userID = userID;
        this.avatar = avatar;
        this.username = username;
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

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public Timestamp getDatePost() {
        return datePost;
    }
    
    public String getDatePostFormat() {
        return Tools.formatDate(datePost);
    }

    public void setDatePost(Timestamp datePost) {
        this.datePost = datePost;
    }

    public Timestamp getLastDateEdit() {
        return lastDateEdit;
    }

    public void setLastDateEdit(Timestamp lastDateEdit) {
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

    public ArrayList<String> getImg() {
        return img;
    }

    public void setImg(ArrayList<String> img) {
        this.img = img;
    }

    public String getCover() {
        return COVER_PATH + cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getVideo() {
        return video;
    }

    public void setVideo(ArrayList<String> video) {
        this.video = video;
    }
    
    public String getAvatar() {
        if(avatar==null) return DEFAULT_AVATAR;
        return IMG_PATH + avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    
    @Override
    public String toString() {
        return "Recipe{" + "id=" + id + ", name=" + name + ", description=" + description + ", like=" + like + ", save=" + save + ", comment=" + comment + ", datePost=" + datePost + ", lastDateEdit=" + lastDateEdit + ", prepTime=" + prepTime + ", cookTime=" + cookTime + ", isDeleted=" + isDeleted + ", userID=" + userID + ", img=" + img + ", cover=" + cover + ", username=" + username + '}';
    }
}
