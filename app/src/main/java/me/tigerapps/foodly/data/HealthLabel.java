package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.tigerapps.foodly.R;

public enum HealthLabel implements Labeled {
    VEGETARIAN("vegetarian", R.string.vegetarian),
    GLUTEN_FREE("gluten-free", R.string.gluten_free),
    FAT_FREE("fat-free", R.string.fat_free),
    PEANUT_FREE("peanut-free", R.string.peanut_free);

    static HealthLabel fromName(final String name) {
        for (final HealthLabel diet : HealthLabel.values())
            if (diet.getName().equals(name))
                return diet;
        return null;
    }

    static List<HealthLabel> parseJsonArray(final JsonReader reader) throws IOException {
        final List<HealthLabel> healthLabels = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext())
            healthLabels.add(HealthLabel.fromName(reader.nextString()));
        reader.endArray();

        return healthLabels;
    }

    private final int labelResId;
    private final String name;

    HealthLabel(final String name, final int labelResId) {
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
