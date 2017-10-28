package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private final String id;
    private final List<Food> ingredients = new ArrayList<>();
    private final String name;

    public static Recipe parseJson(final JsonReader reader)throws IOException {
        String id = null;
        String name = null;

        reader.beginObject();
        while(reader.hasNext()){
            final String property = reader.nextName();
            if("uri".equals(property))
                id = reader.nextString();
            else if("label".equals(property))
                name = reader.nextString();
            else
                reader.skipValue();

        }
        reader.endObject();
        return new Recipe(id, name);
    }

    public Recipe(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public List<Food> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }
}
