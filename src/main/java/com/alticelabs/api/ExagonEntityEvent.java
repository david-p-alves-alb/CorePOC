package com.alticelabs.api;

import org.bson.conversions.Bson;

public abstract class ExagonEntityEvent extends ExagonEntityID implements Bson {
    private String childClass;

    public ExagonEntityEvent() {
    }

    public ExagonEntityEvent(String ID) {
        super(ID);
    }

    public String getChildClass() {
        return this.childClass;
    }

    public void setChildClass(String childClass) {
        this.childClass = childClass;
    }
}
