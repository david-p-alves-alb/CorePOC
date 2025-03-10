package com.alticelabs.api;

import org.bson.conversions.Bson;

import java.util.List;

public abstract class ExagonEntity extends ExagonEntityID implements Bson {
    public ExagonEntity() {
    }

    public ExagonEntity(String ID) {
        super(ID);
    }

    public abstract void reconstruct(List<ExagonEntityEvent> var1);
}
