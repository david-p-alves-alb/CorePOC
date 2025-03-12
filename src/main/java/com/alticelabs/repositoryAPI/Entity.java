package com.alticelabs.repositoryAPI;

import org.bson.conversions.Bson;

import java.util.List;

public abstract class Entity extends EntityID implements Bson {
    public Entity() {
    }

    public Entity(String ID) {
        super(ID);
    }

    public abstract void reconstruct(List<EntityEvent> var1);
}
