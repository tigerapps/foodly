package me.tigerapps.foodly.data;

public class Ingredient {
    private final Food food;
    private final double mass;
    private final Measure measure;
    private final double quantity;

    public Ingredient(final Food food, final double mass, final Measure measure,
                      final double quantity) {
        this.food = food;
        this.mass = mass;
        this.measure = measure;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public double getMass() {
        return mass;
    }

    public Measure getMeasure() {
        return measure;
    }

    public double getQuantity() {
        return quantity;
    }
}
