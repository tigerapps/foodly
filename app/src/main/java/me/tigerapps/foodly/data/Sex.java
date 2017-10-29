package me.tigerapps.foodly.data;

import me.tigerapps.foodly.R;

public enum Sex {
    MALE(R.string.male),
    FEMALE(R.string.female);

    private final int labelResId;

    Sex(final int labelResId) {
        this.labelResId = labelResId;
    }

    public int getLabelResId() {
        return labelResId;
    }
}
