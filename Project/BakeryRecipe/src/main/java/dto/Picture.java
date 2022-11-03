/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Admin
 */
public class Picture {

    public static final String IMG_PATH = "assets/images/recipe/picture/";
    private int id;
    private String img;
    private boolean isCover;
    private String recipeID;

    public Picture (String img, boolean isCover, String recipeID) {
        this.img = img;
        this.isCover = isCover;
        this.recipeID = recipeID;
    }

    public Picture (int id, String img, boolean isCover, String recipeID) {
        this.id = id;
        this.img = img;
        this.isCover = isCover;
        this.recipeID = recipeID;
    }

    public Picture () {
    }

    public String getImg () {
        if (img == null)
            return null;
        return IMG_PATH + img;
        //:assets/images/recipe/picture/picture_0_2017.jpg
    }

    public void setImg (String Img) {
        this.img = Img;
    }

    public boolean getIsCover () {
        return isCover;
    }

    public void setIsCover (boolean IsCover) {
        this.isCover = IsCover;
    }

    public String getRecipeID () {
        return recipeID;
    }

    public void setRecipeID (String RecipeID) {
        this.recipeID = RecipeID;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }
    
}
