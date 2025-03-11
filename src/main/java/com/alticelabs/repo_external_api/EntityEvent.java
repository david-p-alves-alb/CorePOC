package com.alticelabs.repo_external_api;

import org.bson.conversions.Bson;

public abstract class EntityEvent extends EntityID implements Bson {
    private String childClass;

    public EntityEvent() {
    }

    public EntityEvent(String ID) {
        super(ID);
    }

    public String getChildClass() {
        return this.childClass;
    }

    public void setChildClass(String childClass) {
        this.childClass = childClass;
    }
}
