package com.alticelabs.repository.R01;

import org.bson.conversions.Bson;

public abstract class RepoEntityEvent extends RepoEntityID implements Bson {
    private String childClass;

    public RepoEntityEvent() {
    }

    public RepoEntityEvent(String ID) {
        super(ID);
    }

    public String getChildClass() {
        return this.childClass;
    }

    public void setChildClass(String childClass) {
        this.childClass = childClass;
    }

}