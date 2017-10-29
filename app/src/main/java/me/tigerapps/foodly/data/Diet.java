package me.tigerapps.foodly.data;

import me.tigerapps.foodly.R;

public enum Diet {
    BALANCED("balanced", R.string.diet_balanced),
    HIGH_FIBER("high-fiber", R.string.diet_high_fiber),
    LOW_FAT("low-fat", R.string.diet_low_fat);

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
