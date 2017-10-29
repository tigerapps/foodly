package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;
import java.util.List;

public class Recipe {
    public static Recipe parseJson(final JsonReader reader) throws IOException {
        double calories = 0;
        List<Diet> dietLabels = null;
        List<Health> healthLabels = null;
        List<Ingredient> ingredients = null;
        String label = null;
        String uri = null;
        String yield = null;

        reader.beginObject();
        while (reader.hasNext()) {
            final String property = reader.nextName();
            if ("calories".equals(property))
                calories = reader.nextDouble();
            else if ("dietLabels".equals(property))
                dietLabels = Diet.parseJsonArray(reader);
            else if ("healthLabels".equals(property))
                healthLabels = Health.parseJsonArray(reader);
            else if ("ingredients".equals(property))
                ingredients = Ingredient.parseJsonArray(reader);
            else if ("label".equals(property))
                label = reader.nextString();
            else if ("uri".equals(property))
                uri = reader.nextString();
            else if ("yield".equals(property))
                yield = reader.nextString();
            else
                reader.skipValue();
        }
        reader.endObject();

        return new Recipe(calories, dietLabels, healthLabels, ingredients, label, uri, yield);
    }

    private final double calories;
    private final List<Diet> dietLabels;
    private final List<Health> healthLabels;
    private final List<Ingredient> ingredients;
    private final String label;
    private final String uri;
    private final String yield;

    private Recipe(final double calories, final List<Diet> dietLabels,
                   final List<Health> healthLabels, final List<Ingredient> ingredients,
                   final String label, final String uri, final String yield) {
        this.calories = calories;
        this.dietLabels = dietLabels;
        this.healthLabels = healthLabels;
        this.ingredients = ingredients;
        this.label = label;
        this.uri = uri;
        this.yield = yield;
    }

    public double getCalories() {
        return calories;
    }

    public List<Diet> getDietLabels() {
        return dietLabels;
    }

    public List<Health> getHealthLabels() {
        return healthLabels;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getLabel() {
        return label;
    }

    public String getUri() {
        return uri;
    }

    public String getYield() {
        return yield;
    }
}
