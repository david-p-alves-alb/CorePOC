package com.alticelabs.repositoryAPI;

public abstract class EntityID {

    /** Identificador único da entidade. */
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

