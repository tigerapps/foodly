package me.tigerapps.foodly.data;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private final int id;
    private final List<Food> ingredients = new ArrayList<Food>();
    private final String name;

    public Recipe(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public List<Food> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }
}
