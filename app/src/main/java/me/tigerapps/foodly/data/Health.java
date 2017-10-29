package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.tigerapps.foodly.R;

public enum Health {
    VEGETARIAN("vegetarian", R.string.vegeterian),
    GLUTEN_FREE("gluten-free", R.string.gluten_free),
    FAT_FREE("fat-free", R.string.fat_free),
    PEANUT_FREE("peanut-free", R.string.peanut_free);

    static Health fromName(final String name) {
        for (final Health diet : Health.values())
            if (diet.getName().equals(name))
                return diet;
        return null;
    }

    static List<Health> parseJsonArray(final JsonReader reader) throws IOException {
        final List<Health> healthLabels = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext())
            healthLabels.add(Health.fromName(reader.nextString()));
        reader.endArray();

        return healthLabels;
    }

    private final int labelResId;
    private final String name;

    Health(final String name, final int labelResId) {
        this.labelResId = labelResId;
        this.name = name;
    }

    public int getLabelResId() {
        return labelResId;
    }

    public String getName() {
        return name;
    }
}
