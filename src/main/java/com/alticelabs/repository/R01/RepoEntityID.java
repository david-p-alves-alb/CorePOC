package com.alticelabs.repository.R01;

public abstract class RepoEntityID {
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RepoEntityID(String id) {
        this.id = id;
    }

    public RepoEntityID() {
    }
}