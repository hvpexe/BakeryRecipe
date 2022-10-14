/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author VO MINH MAN
 */
public class Ingredient {

    private static final String IMG_PATH = "assets/images/ingredients/";
    private static final String DEFAULT_IMG = IMG_PATH + "default.png";
    private String name;
    private String img;
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Ingredient(String name, String img, String amount) {
        this.name = name;
        this.img = img;
        this.amount = amount;
    }

    public Ingredient(String name, String img) {
        this.name = name;
        this.img = img;
    }

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img != null ? IMG_PATH + img : DEFAULT_IMG;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "name=" + name + ", img=" + img + '}';
    }

}
