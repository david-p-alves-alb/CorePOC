package com.alticelabs.repo_external_api;

public abstract class EntityID {
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EntityID(String id) {
        this.id = id;
    }

    public EntityID() {
    }
}

