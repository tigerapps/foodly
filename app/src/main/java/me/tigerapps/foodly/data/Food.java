package me.tigerapps.foodly.data;

public class Food {
    private final long id;
    private final String name;

    public Food(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
