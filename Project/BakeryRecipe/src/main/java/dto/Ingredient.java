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
    private int id;
    private String name;
    private String img;
    private String amount;

    public Ingredient (String name, String img, String amount) {//ajax constructer
        this.name = name;
        this.img = img;
        this.amount = amount;

    }

    public Ingredient (int id, String name, String img, String amount) {//RECIPE DAO constructer
        this.id = id;
        this.name = name;
        this.img = img;
        this.amount = amount;
    }

    public Ingredient (String name, String img) {
        this.name = name;
        this.img = img;
    }

    public Ingredient () {
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getAmount () {
        return amount;
    }

    public void setAmount (String amount) {
        this.amount = amount;
    }

    public String getImg () {
        return img != null ? IMG_PATH + img : DEFAULT_IMG;
    }

    public void setImg (String img) {
        this.img = img;
    }

    @Override
    public String toString () {
        return "Ingredient{" + "name=" + name + ", img=" + img + '}';
    }

}
