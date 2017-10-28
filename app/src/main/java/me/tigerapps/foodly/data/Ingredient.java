package me.tigerapps.foodly.data;

import android.util.JsonReader;

import java.io.IOException;

public class Ingredient {
    private final Food food;
    private final double mass;
    private final Measure measure;
    private final double quantity;

    public static Ingredient parseJson(final JsonReader reader) throws IOException {

        Food food = null;
        double mass = 0;
        Measure measure = null;
        double quantity = 0;

        reader.beginObject();
        while(reader.hasNext()) {
            final String property = reader.nextName();

            if("food".equals(property))
                food = Food.parseJson(reader);
            else if ("weight".equals(property))
                mass= reader.nextDouble();
            else if("measure".equals(property))
                measure = Measure.parseJson(reader);
            else if ("quantity".equals(property))
                quantity = reader.nextDouble();
            else
                reader.skipValue();
        }

        reader.endObject();
        return new Ingredient(food, mass, measure, quantity);
    }

    public Ingredient(final Food food, final double mass, final Measure measure,
                      final double quantity) {
        this.food = food;
        this.mass = mass;
        this.measure = measure;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public double getMass() {
        return mass;
    }

    public Measure getMeasure() {
        return measure;
    }

    public double getQuantity() {
        return quantity;
    }

}


