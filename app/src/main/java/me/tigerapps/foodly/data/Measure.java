package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;

public class Measure {
    static Measure parseJson(final JsonReader reader) throws IOException {
        String label = null;
        String uri = null;

        reader.beginObject();
        while (reader.hasNext()) {
            final String property = reader.nextName();
            if ("label".equals(property))
                label = reader.nextString();
            else if ("uri".equals(property))
                uri = reader.nextString();
            else
                reader.skipValue();
        }
        reader.endObject();

        return new Measure(label, uri);
    }

    private final String label;
    private final String uri;

    private Measure(final String label, final String uri) {
        this.label = label;
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public String getUri() {
        return uri;
    }
}
