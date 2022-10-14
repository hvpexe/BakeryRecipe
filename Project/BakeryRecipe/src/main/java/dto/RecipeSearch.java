/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import static dto.Recipe.COVER_PATH;
import java.sql.Timestamp;
import java.util.ArrayList;
import utils.Tools;

/**
 *
 * @author PhuHV dto này dùng để lưu các recipe kèm ingredient và match, dùng
 * cho recipe search by ingre
 */
public class RecipeSearch implements Comparable<RecipeSearch> {

    public static final String COVER_PATH = "assets/images/recipe/";

    private int id;
    private String name;
    private String description;
    private int like;
    private int comment;
    private Timestamp datePost; //timestamp mới thể hiện hết giờ phút giây, class Date ko làm đc
    private ArrayList<String> ingre;
    private float match; //field này lưu điểm đánh giá giữa tập ingre của recipe này với tập ingre của search (dùng trong searchByIngre)
    private String cover; //field này dùng để lưu ảnh cover
    private int userID; //id người đăng recipe
    private String username; //dùng để lưu cả lastname + firstname của user

    public RecipeSearch() {
    }

    /**
     * constructor nay dung de hien recipe tren search by ingre
     */
    public RecipeSearch(int id, String name, String description, Timestamp datePost, ArrayList<String> ingre, String cover) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.datePost = datePost;
        this.ingre = ingre;
        this.cover = cover;
    }

    public RecipeSearch(int id, String name, String description, int like, int comment, Timestamp datePost, ArrayList<String> ingre, String cover, int userID, String username) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.like = like;
        this.comment = comment;
        this.datePost = datePost;
        this.ingre = ingre;
        this.match = match;
        this.cover = cover;
        this.userID = userID;
        this.username = username;
    }
    
    public ArrayList<String> getIngre() {
        return ingre;
    }

    public void setIngre(ArrayList<String> ingre) {
        this.ingre = ingre;
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

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public Timestamp getDatePost() {
        return datePost;
    }

    public void setDatePost(Timestamp datePost) {
        this.datePost = datePost;
    }

    public String getDatePostFormat() {
        return Tools.formatDate(datePost);
    }

    public float getMatch() {
        return match;
    }

    public void setMatch(float match) {
        this.match = match;
    }

    public String getCover() {
        return COVER_PATH + cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int compareTo(RecipeSearch that) {
        if ((this.match - that.match) < 0) {
            return 1;
        } else if ((this.match - that.match) > 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
