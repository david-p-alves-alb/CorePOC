package com.alticelabs.repo_external_api;


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
