package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.tigerapps.foodly.R;

public enum DietLabel {
    BALANCED("balanced", R.string.diet_balanced),
    HIGH_FIBER("high-fiber", R.string.diet_high_fiber),
    LOW_FAT("low-fat", R.string.diet_low_fat);

    static DietLabel fromName(final String name) {
        for (final DietLabel dietLabel : DietLabel.values())
            if (dietLabel.getName().equals(name))
                return dietLabel;
        return null;
    }

    static List<DietLabel> parseJsonArray(final JsonReader reader) throws IOException {
        final List<DietLabel> dietLabels = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext())
            dietLabels.add(DietLabel.fromName(reader.nextString()));
        reader.endArray();

        return dietLabels;
    }

    private final int labelResId;
    private final String name;

    DietLabel(final String name, final int labelResId) {
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
