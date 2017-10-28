package me.tigerapps.foodly.user;

public class User {
    private int age; // In years
    private double calories; // Kilocalories
    private double carbs;    // In grams
    private double fat;      // In grams
    private int height; // In centimeters
    private double protein;  // In grams
    private Sex sex;
    private int weight; // In kilograms

    /**
     * Sets up the User object with given values
     *
     * @param weight Weight in Kilograms
     * @param height Height in Centimeters
     * @param age    Age
     * @param sex    MALE or FEMALE
     */
    public User(final int weight, final int height, final int age, final Sex sex) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        calculateCalories();
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
    }

    public int getAge() {
        return age;
    }

    public double getCalories() {
        return calories;
    }

    public int getHeight() {
        return height;
    }

    public Sex getSex() {
        return sex;
    }

    public int getWeight() {
        return weight;
    }

    public void setAge(final int age) {
        this.age = age;
        calculateCalories();
    }

    public void setHeight(final int height) {
        this.height = height;
        calculateCalories();
    }

    /**
     * Set the amount of macronutrients required to meet a Calorie goal given ratios of proteins,
     * carbs, and fats to total intake. Ratios should add up to 1.00, but this is not checked in the
     * method currently.
     *
     * @param fat     The portion of the diet that should be fat
     * @param carbs   The portion of the diet that should be carbs
     * @param protein The portion of the diet that should be protein
     */
    public void setMacronutrients(final double fat, final double carbs, final double protein) {
        this.fat = (calories * fat) / 9;
        this.carbs = (calories * carbs) / 4;
        this.protein = (calories * protein) / 4;
    }

    public void setSex(final Sex sex) {
        this.sex = sex;
        calculateCalories();
    }

    public void setWeight(final int weight) {
        this.weight = weight;
        calculateCalories();
    }
}
