package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;

import javax.lang.model.element.NestingKind;

public class Food {
    private final String id;
    private final String name;

    public static Food parseJson(final JsonReader reader) throws IOException {

        String id = null;
        String name = null;

        reader.beginObject();
        while(reader.hasNext()) {
            final String property = reader.nextName();

            if ("label".equals(property))
                name = reader.nextString();
            else if ("uri".equals(property))
                id = reader.nextString();
            else
                reader.skipValue();
        }

        reader.endObject();
        return new Food(id, name);
    }

    public Food(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
