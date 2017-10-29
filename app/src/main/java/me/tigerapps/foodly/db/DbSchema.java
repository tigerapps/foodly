package me.tigerapps.foodly.db;

import android.provider.BaseColumns;

import me.tigerapps.foodly.R;

final class DbSchema {
    public static final String SQL_CREATE_TABLES = "";

    private static final String SQL_CREATE_FOOD =
            "CREATE TABLE " + FoodTable.TABLE_NAME + " (" +
                    FoodTable._ID + " INTEGER PRIMARY KEY," +
                    FoodTable.COLUMN_NAME_NAME + " TEXT," +
                    FoodTable.COLUMN_NAME_CALORIES + " FLOAT," +
                    FoodTable.COLUMN_NAME_PROTEIN + " FLOAT," +
                    FoodTable.COLUMN_NAME_FAT + " FLOAT," +
                    FoodTable.COLUMN_NAME_CARBS + " FLOAT)";

    private DbSchema() {
        // Prevent instantiation.
    }
    public static class DietTable implements BaseColumns {
        public static final String TABLE_NAME = "diets";
        public static final String COLUMN_NAME_TYPE = "diet_type";
    }

    public static class FoodTable implements BaseColumns {
        static final String TABLE_NAME = "food";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_CALORIES = "calories";
        static final String COLUMN_NAME_PROTEIN = "protein";
        static final String COLUMN_NAME_FAT = "fat";
        static final String COLUMN_NAME_CARBS = "carbs";
    }

    public static class HealthTable implements BaseColumns {
        public static final String TABLE_NAME = "health";
        public static final String COLUMN_NAME_REQUIREMENT = "health_requirement";
    }

    public static class RecipeTable implements BaseColumns {
        public static final String TABLE_NAME = "recipes";
        public static final String COLUMN_NAME_INGREDIENT_NAME = "name";
    }

}
