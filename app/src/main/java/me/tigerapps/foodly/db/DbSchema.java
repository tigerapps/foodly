package me.tigerapps.foodly.db;

final class DbSchema {
    public static final String SQL_CREATE_TABLES = "";

    private DbSchema() {
        // Prevent instantiation.
    }

    public static class RecipeTable {
        public static final String TABLE_NAME = "recipes";
    }
}
