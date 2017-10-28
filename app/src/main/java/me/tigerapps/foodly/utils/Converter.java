package me.tigerapps.foodly.utils;

/**
 * Created by chris on 10/28/17.
 */

public final class Converter {
    public static double inchesToCm(double inches) {
        return (inches * 2.54);
    }

    public static double CmToInches(double cm) {
        return (cm / 2.54);
    }

    public static double LbsToKg(double lbs) {
        return (lbs / 2.2);
    }

    public static double KgToLbs(double kg) {
        return (kg * 2.2);
    }
}