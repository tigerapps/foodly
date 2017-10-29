package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;
import java.util.List;

public class Recipe {
    public static Recipe parseJson(final JsonReader reader) throws IOException {
        List<Ingredient> ingredients = null;
        String label = null;
        String uri = null;

        reader.beginObject();
        while (reader.hasNext()) {
            final String property = reader.nextName();
            if ("ingredients".equals(property))
                ingredients = Ingredient.parseJsonArray(reader);
            else if ("label".equals(property))
                label = reader.nextString();
            else if ("uri".equals(property))
                uri = reader.nextString();
            else
                reader.skipValue();
        }
        reader.endObject();

        return new Recipe(ingredients, label, uri);
    }

    private final String uri;
    private final List<Ingredient> ingredients;
    private final String label;

    public Recipe(final List<Ingredient> ingredients, final String label, final String uri) {
        this.ingredients = ingredients;
        this.label = label;
        this.uri = uri;
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
}
