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
    private String img;
    private String isCover;
    private String recipeID;

    public Picture (String img, String isCover, String recipeID) {
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
    }

    public void setImg (String Img) {
        this.img = Img;
    }

    public String getIsCover () {
        return isCover;
    }

    public void setIsCover (String IsCover) {
        this.isCover = IsCover;
    }

    public String getRecipeID () {
        return recipeID;
    }

    public void setRecipeID (String RecipeID) {
        this.recipeID = RecipeID;
    }
}
