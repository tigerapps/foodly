package me.tigerapps.foodly.data;

import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import me.tigerapps.foodly.BR;

public class User extends BaseObservable {
    private static final String USER_AGE = "user_age";
    private static final String USER_SEX = "user_sex";
    private static final String USER_HEIGHT = "user_height";
    private static final String USER_WEIGHT = "user_weight";
    private static final String MACRO_FAT = "macro_fat";
    private static final String MACRO_CARBS = "macro_carbs";
    private static final String MACRO_PROTEIN = "macro_protein";

    private int age;              // In years
    private double calories;      // Kilocalories per day
    private double carbs;         // In grams per day
    private float carbsRatio;     // Percent (0-100)
    private double fat;           // In grams per day
    private float fatRatio;       // Percent (0-100)
    private int height;           // In centimeters
    private double protein;       // In grams per day
    private float proteinRatio;   // Percent (0-100)
    private Sex sex;
    private int weight;           // In kilograms
    private final SharedPreferences preferences;

    public User(SharedPreferences preferences) {
        this.preferences = preferences;
        age = preferences.getInt(USER_AGE, 20);
        sex = Sex.valueOf(preferences.getString(USER_SEX, "MALE"));
        height = preferences.getInt(USER_HEIGHT, 150);
        weight = preferences.getInt(USER_WEIGHT, 45);
        fatRatio = preferences.getFloat(MACRO_FAT, 30);
        carbsRatio = preferences.getFloat(MACRO_CARBS, 40);
        proteinRatio = preferences.getFloat(MACRO_PROTEIN, 30);
        calculateCalories();
        calculateMacronutrients();
    }

    /**
     * Calculate calorie needs using the Mifflin-St Jeor Equation.
     */
    private void calculateCalories() {
        if (sex == Sex.MALE) {
            calories = ((10 * weight) + (6.25 * height) - (5 * age) + 5);
        } else {
            calories = ((10 * weight) + (6.25 * height) - (5 * age) - 161);
        }
        notifyPropertyChanged(BR.caloriesPerDay);
        notifyPropertyChanged(BR.caloriesPerWeek);
    }

    /**
     * Calculates amounts of macronutrients in grams needed to meet the Calorie goal
     */
    public void calculateMacronutrients() {
        this.fat = (calories * fatRatio) / 900;
        this.carbs = (calories * carbsRatio) / 400;
        this.protein = (calories * proteinRatio) / 400;
        notifyPropertyChanged(BR.fatPerDay);
        notifyPropertyChanged(BR.carbsPerDay);
        notifyPropertyChanged(BR.proteinPerDay);
        notifyPropertyChanged(BR.fatPerWeek);
        notifyPropertyChanged(BR.carbsPerWeek);
        notifyPropertyChanged(BR.proteinPerWeek);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    @Bindable
    public double getCaloriesPerDay() {
        return calories;
    }

    @Bindable
    public double getCaloriesPerWeek() {
        return calories * 7;
    }

    @Bindable
    public double getCarbsPerDay() {
        return carbs;
    }

    @Bindable
    public double getCarbsPerWeek() {
        return carbs * 7;
    }

    @Bindable
    public float getCarbsRatio() {
        return carbsRatio;
    }

    @Bindable
    public double getFatPerDay() {
        return fat;
    }

    @Bindable
    public double getFatPerWeek() {
        return fat * 7;
    }

    @Bindable
    public float getFatRatio() {
        return fatRatio;
    }

    @Bindable
    public int getHeight() {
        return height;
    }

    @Bindable
    public double getProteinPerDay() {
        return protein;
    }

    @Bindable
    public double getProteinPerWeek() {
        return protein * 7;
    }

    @Bindable
    public float getProteinRatio() {
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
        SharedPreferences.Editor ed = preferences.edit();
        ed.putInt(USER_AGE, age);
        ed.commit();
        notifyPropertyChanged(BR.age);
        calculateCalories();
        calculateMacronutrients();
    }

    public void setCarbsRatio(final float carbsRatio) {
        final double delta = this.carbsRatio - carbsRatio;
        this.fatRatio += delta / 2;
        this.proteinRatio += delta / 2;
        this.carbsRatio -= delta;
        updateMacronutrients(this.carbsRatio, this.fatRatio, this.proteinRatio);
    }

    public void setFatRatio(final float fatRatio) {
        final double delta = this.fatRatio - fatRatio;
        this.carbsRatio += delta / 2;
        this.proteinRatio += delta / 2;
        this.fatRatio -= delta;
        updateMacronutrients(this.carbsRatio, this.fatRatio, this.proteinRatio);
    }

    public void setHeight(final int height) {
        this.height = height;
        SharedPreferences.Editor ed = preferences.edit();
        ed.putInt(USER_HEIGHT, height);
        ed.commit();
        notifyPropertyChanged(BR.height);
        calculateCalories();
        calculateMacronutrients();
    }

    public void setProteinRatio(final float proteinRatio) {
        final double delta = this.proteinRatio - proteinRatio;
        this.carbsRatio += delta / 2;
        this.fatRatio += delta / 2;
        this.proteinRatio -= delta;
        updateMacronutrients(this.carbsRatio, this.fatRatio, this.proteinRatio);
    }

    public void setSex(final Sex sex) {
        this.sex = sex;
        SharedPreferences.Editor ed = preferences.edit();
        ed.putString(USER_SEX, sex.name());
        ed.commit();
        notifyPropertyChanged(BR.sex);
        calculateCalories();
        calculateMacronutrients();
    }

    public void setWeight(final int weight) {
        this.weight = weight;
        SharedPreferences.Editor ed = preferences.edit();
        ed.putInt(USER_WEIGHT, weight);
        ed.commit();
        notifyPropertyChanged(BR.weight);
        calculateCalories();
        calculateMacronutrients();
    }

    private void updateMacronutrients(final float carbsRatio, final float fatRatio, final float proteinRatio) {
        this.carbsRatio = carbsRatio;
        this.fatRatio = fatRatio;
        this.proteinRatio = proteinRatio;
        SharedPreferences.Editor ed = preferences.edit();
        ed.putFloat(MACRO_CARBS, carbsRatio);
        ed.putFloat(MACRO_FAT, fatRatio);
        ed.putFloat(MACRO_PROTEIN, proteinRatio);
        ed.commit();
        notifyPropertyChanged(BR.carbsRatio);
        notifyPropertyChanged(BR.fatRatio);
        notifyPropertyChanged(BR.proteinRatio);
        calculateMacronutrients();
    }
}
