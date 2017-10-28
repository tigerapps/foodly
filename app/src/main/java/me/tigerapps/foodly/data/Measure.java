package me.tigerapps.foodly.data;

public enum Measure {
    ;

    private final long id;
    private final String name;

    private Measure(final long id, final String name) {
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
