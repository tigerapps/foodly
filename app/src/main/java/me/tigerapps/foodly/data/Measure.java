package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;

public enum Measure {
    ;

    private final String id;
    private final String name;

    public static Measure parseJson(final JsonReader reader) throws IOException {
        String id = null;
        String name = null;
        reader.beginObject();

        while(reader.hasNext()){
            final String property = reader.nextName();
            if("uri".equals(property))
                id = reader.nextString();
            else if( "label".equals(property))
                name = reader.nextString();
            else
                reader.skipValue();
        }

        reader.endObject();
        return null;
    }
    Measure(final String id, final String name) {
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
