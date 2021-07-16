package com.example.weather2;

public class Station {
    private String id;
    private String name;

    public Station (String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return getName();
    }
}
