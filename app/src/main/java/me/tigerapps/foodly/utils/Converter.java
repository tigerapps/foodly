package me.tigerapps.foodly.utils;

public final class Converter {
    public static double inchesToCm(final double inches) {
        return (inches * 2.54);
    }

    public static double CmToInches(final double cm) {
        return (cm / 2.54);
    }

    public static double LbsToKg(final double lbs) {
        return (lbs / 2.2);
    }

    public static double KgToLbs(final double kg) {
        return (kg * 2.2);
    }
}
