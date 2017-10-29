package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    public static Recipe parseJson(final JsonReader reader) throws IOException {
        List<Ingredient> ingredients = null;
        String label = null;
        String uri = null;
        String yield = null;
        double calories = 0;
        List<Diet> diets = null;

        reader.beginObject();
        while (reader.hasNext()) {
            final String property = reader.nextName();
            if ("ingredients".equals(property))
                ingredients = Ingredient.parseJsonArray(reader);
            else if ("label".equals(property))
                label = reader.nextString();
            else if ("uri".equals(property))
                uri = reader.nextString();
            else if("yield".equals(property))
                yield = reader.nextString();
            else if ("calories".equals(property))
                calories = reader.nextDouble();
            else if ("dietLabels".equals(property))
                diets = Diet.parseJsonArray(reader);
            else
                reader.skipValue();
        }
        reader.endObject();

        return new Recipe(ingredients, label, uri, yield, calories, diets);
    }

    private final String uri;
    private final List<Ingredient> ingredients;
    private final String label;
    private final String yield;
    private final double calories;
    private final List<Diet> dietLabels;

    private Recipe(final List<Ingredient> ingredients, final String label, final String uri,
                   final String yield, final double calories, final List<Diet> dietLabels) {
        this.ingredients = ingredients;
        this.label = label;
        this.uri = uri;
        this.yield = yield;
        this.calories = calories;
        this.dietLabels = dietLabels;
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

    public String getYield(){ return yield;}

    public double getCalories(){ return calories;}

    public List<Diet> getDietLabels(){ return dietLabels;}
}
