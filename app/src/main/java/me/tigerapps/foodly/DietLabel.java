package me.tigerapps.foodly;

/**
 * Created by yui on 10/28/17.
 */

public enum DietLabel {
    BALANCED("balanced"),
    HIGH_PROTEIN("high-protein"),
    LOW_FAT("low-fat"),
    LOW_CARB("low-arb");

    public static DietLabel fromName(String labelName) {
        for (DietLabel label : DietLabel.values())
            if (label.getLabelName().equals(labelName))
                return label;
        return null;
    }

    private final String labelName;

    DietLabel(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelName() {
        return labelName;
    }
}