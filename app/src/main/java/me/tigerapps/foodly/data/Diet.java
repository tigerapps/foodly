package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.tigerapps.foodly.R;

public enum Diet {
    BALANCED("balanced", R.string.diet_balanced),
    HIGH_FIBER("high-fiber", R.string.diet_high_fiber),
    LOW_FAT("low-fat", R.string.diet_low_fat);

    static Diet fromName(final String name) {
        for (final Diet diet : Diet.values())
            if (diet.getName().equals(name))
                return diet;
        return null;
    }

    static List<Diet> parseJsonArray(final JsonReader reader) throws IOException {
        final List<Diet> dietLabels = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext())
            dietLabels.add(Diet.fromName(reader.nextString()));
        reader.endArray();

        return dietLabels;
    }

    private final int labelResId;
    private final String name;

    Diet(final String name, final int labelResId) {
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
