/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Admin
 */
public class IngredientRecipe {

    private int RecipeID;
    private int IngredientID;
    private int Amount;

    public int getRecipeID () {
        return RecipeID;
    }

    public void setRecipeID (int RecipeID) {
        this.RecipeID = RecipeID;
    }

    public int getIngredientID () {
        return IngredientID;
    }

    public void setIngredientID (int IngredientID) {
        this.IngredientID = IngredientID;
    }

    public int getAmount () {
        return Amount;
    }

    public void setAmount (int Amount) {
        this.Amount = Amount;
    }

    public IngredientRecipe (int RecipeID, int IngredientID, int Amount) {
        this.RecipeID = RecipeID;
        this.IngredientID = IngredientID;
        this.Amount = Amount;
    }

    public IngredientRecipe () {
    }
}
