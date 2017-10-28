/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author yui
 */
public class GenerateShoppingList {

    public ShoppingListTable generateShoppingList(RecipeDatabase rdb, enum shoppingType){
        double totalCalories = 0;
        double totalProtein = 0;
        double totalFat = 0;
        double totalCarbs = 0;


        this.shoppingType = DietLabel.fromName(shoppingType);
        switch(this.shoppingType){
            case BY_MEAL:
                //import from recommend meal list
                //add the user's selection into table

                break;
            case BY_INGREDIENTS:
                //add the user's selection into table
                break;
            default:


        }
        //table - everything on table "items on hand"

    }
}
