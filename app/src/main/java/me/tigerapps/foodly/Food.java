package me.tigerapps.foodly;

/**
 * Created by yui on 10/27/17.
 */

public class Food {

    private String name;
    private double calories;
    private double protein;
    private double fat;
    private double carbs;



    Food(String name, double calories, double protein, double fat, double carbs){
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;

    }
}
