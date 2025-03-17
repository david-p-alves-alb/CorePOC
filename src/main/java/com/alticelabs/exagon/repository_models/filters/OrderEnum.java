package com.alticelabs.exagon.repository_models.filters;


public enum OrderEnum {
    ASC("Ascending"),
    DESC("Descending");

    private final String name;

    private OrderEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
