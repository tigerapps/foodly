/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.util.ArrayList;

/**
 *
 * @author yui
 */
public class RecommendMeal {


       public void recommendMeal(ArrayList<Food> foodate, String goal){ 
      
//        this.goal = DietLabel.fromName("low-fat");
//        System.out.println(goal + " it's a test");
        
        double totalCalories = 0;
        double totalProtein = 0;
        double totalFat = 0;
        double totalCarbs = 0;
        for(int i = 0; i < foodate.size(); i++){
            totalCalories += foodate.calories;
            totalProtein += foodate.protein;
            totalFat += foodate.fat;
            fotalCarbs += foodate.carbs;


        }

        //let's call the recommended nutrition value - the value user consumed = V
        //V will be the total amount that the user can/should take, so we look through the recipe array, anything
        //not providing excessive value can be taken into consideration
        for(int i = 0; i < allRecipe.size(); i++){
            if(recommendedCalories - totalCalories < allRecipe.calories)
                continue;
            if(recommendedProtein - totalProtein < allRecipe.protein)
                continue;
            if(recommendedFat - totalFat < allRecipe.fat)
                continue;
            if(recommendedCarbs - totalCarbs < allRecipe.Carbs)
                continue;
        
            recommendList.add(allRecipe[i]);
        }
        
        return recommendList;
        
        
        
    }
    
    
    
}
