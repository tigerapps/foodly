package me.tigerapps.foodly.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import me.tigerapps.foodly.BR;

public class User extends BaseObservable {
    private int age;                   // In years
    private double calories;           // Kilocalories
    private double carbs;              // In grams
    private double carbsRatio = .50;   // Percent (0-100)
    private double fat;                // In grams
    private double fatRatio = .25;     // Percent (0-100)
    private int height;                // In centimeters
    private double protein;            // In grams
    private double proteinRatio = .25; // Percent (0-100)
    private Sex sex;
    private int weight;               // In kilograms

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
     * Calculates amounts of macronutrients in grams needed to meet the Calorie goal
     */
    public void calculateMacronutrients() {
        this.fat = (calories * fatRatio) / 9;
        this.carbs = (calories * carbsRatio) / 4;
        this.protein = (calories * proteinRatio) / 4;
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
    public double getCarbsRatio() {
        return carbsRatio;
    }

    @Bindable
    public double getFat() {
        return fat;
    }

    @Bindable
    public double getFatRatio() {
        return fatRatio;
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
    public double getProteinRatio() {
        return proteinRatio;
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

    public void setCarbsRatio(final double carbsRatio) {
        final double delta = this.carbsRatio - carbsRatio;
        this.fatRatio += delta / 2;
        this.proteinRatio += delta / 2;
        this.carbsRatio -= delta;
        calculateMacronutrients();
    }

    public void setFatRatio(final double fatRatio) {
        final double delta = this.fatRatio - fatRatio;
        this.carbsRatio += delta / 2;
        this.proteinRatio += delta / 2;
        this.fatRatio -= delta;
        calculateMacronutrients();
    }

    public void setHeight(final int height) {
        this.height = height;
        notifyPropertyChanged(BR.height);
        calculateCalories();
        calculateMacronutrients();
    }

    public void setProteinRatio(final double proteinRatio) {
        final double delta = this.proteinRatio - proteinRatio;
        this.carbsRatio += delta / 2;
        this.fatRatio += delta / 2;
        this.proteinRatio -= delta;
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
