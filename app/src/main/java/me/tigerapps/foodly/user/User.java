package me.tigerapps.foodly.user;

public class User {
    private int weight; // In kilograms
    private int height; // In centimeters
    private int age;
    private double calories; // Kilocalories
    private double protein;  // In grams
    private double carbs;    // In grams
    private double fat;      // In grams
    private Sex sex;

    /**
     * Sets up the User object with given values
     *
     * @param weight Weight in Kilograms
     * @param height Height in Centimeters
     * @param age    Age
     * @param sex    MALE or FEMALE
     */
    public User(int weight, int height, int age, Sex sex) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        calculateCalories();
    }

    // Calculate calories using Mifflin-St Jeor Equation
    private void calculateCalories() {
        if (sex == Sex.MALE) {
            calories = ((10 * weight) + (6.25 * height) - (5 * age) + 5);
        } else {
            calories = ((10 * weight) + (6.25 * height) - (5 * age) - 161);
        }
    }

    /**
     * Sets the amount of macros required to meet a Calorie goal given ratios of
     * proteins, carbs, and fats. Ratios should add up to 1.00, but this is not
     * checked in the method currently
     *
     * @param protein The ratio of protein
     * @param carbs   The ratio of carbs
     * @param fat     The ratio of fat
     */
    public void setMacros(double protein, double carbs, double fat) {
        this.protein = (calories * protein) / 4;
        this.carbs = (calories * carbs) / 4;
        this.fat = (calories * fat) / 9;
    }

    // Setters and getters
    public double getCalories() {
        return (calories);
    }

    public void setWeight(int weight) {
        this.weight = weight;
        calculateCalories();
    }

    public int getWeight() {
        return (weight);
    }

    public void setHeight(int height) {
        this.height = height;
        calculateCalories();
    }

    public int getHeight() {
        return (height);
    }

    public void setAge(int age) {
        this.age = age;
        calculateCalories();
    }

    public int getAge() {
        return (age);
    }

    public void setSex(Sex sex) {
        this.sex = sex;
        calculateCalories();
    }

    public Sex getSex() {
        return (sex);
    }
}
