package me.tigerapps.foodly.user;

/**
 * Created by chris on 10/27/17.
 */

public class User {
    private int weight; // In kilograms
    private int height; // In centimeters
    private int age;
    private double calories; // Kilocalories
    private Sex sex;

    public User(){}
    
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
