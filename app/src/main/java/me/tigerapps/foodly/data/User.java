package me.tigerapps.foodly.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import me.tigerapps.foodly.BR;

public class User extends BaseObservable {
    private int age; // In years
    private double calories; // Kilocalories
    private double carbs;    // In grams
    private double carbs_ratio;
    private double fat;      // In grams
    private double fat_ratio;
    private int height; // In centimeters
    private double protein;  // In grams
    private double protein_ratio;
    private Sex sex;
    private int weight; // In kilograms

    /**
     * Calculate calorie needs using the Mifflin-St Jeor Equation.
     */
    private void calculateCalories() {
        if (sex == Sex.MALE) {
            calories = ((10 * weight) + (6.25 * height) - (5 * age) + 5);
        } else {
            calories = ((10 * weight) + (6.25 * height) - (5 * age) - 161);
        }
        notifyPropertyChanged(BR.calories);
    }

    /**
     * Set the amount of macronutrients required to meet a Calorie goal given ratios of proteins,
     * carbs, and fats to total intake. Ratios should add up to 1.00, but this is not checked in the
     * method currently.
     */
    public void calculateMacronutrients() {
        this.fat = (calories * fat_ratio) / 9;
        this.carbs = (calories * carbs_ratio) / 4;
        this.protein = (calories * protein_ratio) / 4;
        notifyPropertyChanged(BR.fat);
        notifyPropertyChanged(BR.carbs);
        notifyPropertyChanged(BR.protein);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    @Bindable
    public double getCalories() {
        return calories;
    }

    @Bindable
    public double getCarbs() {
        return carbs;
    }

    @Bindable
    public double getCarbs_ratio() {
        return carbs_ratio;
    }

    @Bindable
    public double getFat() {
        return fat;
    }

    @Bindable
    public double getFat_ratio() {
        return fat_ratio;
    }

    @Bindable
    public int getHeight() {
        return height;
    }

    @Bindable
    public double getProtein() {
        return protein;
    }

    @Bindable
    public double getProtein_ratio() {
        return protein_ratio;
    }

    @Bindable
    public Sex getSex() {
        return sex;
    }

    @Bindable
    public int getWeight() {
        return weight;
    }

    public void setAge(final int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
        calculateCalories();
        calculateMacronutrients();
    }

    public void setCarbs_ratio(double carbs_ratio) {
        this.carbs_ratio = carbs_ratio;
        calculateMacronutrients();
    }

    public void setFat_ratio(double fat_ratio) {
        this.fat_ratio = fat_ratio;
        calculateMacronutrients();
    }

    public void setHeight(final int height) {
        this.height = height;
        notifyPropertyChanged(BR.height);
        calculateCalories();
        calculateMacronutrients();
    }

    public void setProtein_ratio(double protein_ratio) {
        this.protein_ratio = protein_ratio;
        calculateMacronutrients();
    }

    public void setSex(final Sex sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
        calculateCalories();
        calculateMacronutrients();
    }

    public void setWeight(final int weight) {
        this.weight = weight;
        notifyPropertyChanged(BR.weight);
        calculateCalories();
        calculateMacronutrients();
    }
}
