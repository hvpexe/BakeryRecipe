/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author VO MINH MAN
 */
public class Instruction {

    

    public static final String IMG_PATH= "assets/images/recipe/instruction/";
   
    private int insstep;
    private String detail;
    private String img;

    public Instruction() {
    }

    public Instruction(int insstep, String detail, String img) {
        this.insstep = insstep;
        this.detail = detail;
        this.img = img;
    }

    public int getInsstep() {
        return insstep;
    }

    public void setInsstep(int insstep) {
        this.insstep = insstep;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImg() {
        if(img == null)  return null;
        return IMG_PATH+img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString () {
        return "Instruction{" + "insstep=" + insstep + ", detail=" + detail + ", img=" + img + '}';
    }

}
