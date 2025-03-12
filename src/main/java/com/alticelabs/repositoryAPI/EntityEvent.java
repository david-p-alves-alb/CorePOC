package com.alticelabs.repositoryAPI;

import org.bson.conversions.Bson;

/**
 * The base for events that represent a change to be applied to an entity.
 * Each event is associated with an entity.
 */
public abstract class EntityEvent extends EntityID implements Bson {

    /** The class name of the entity affected by this event. */
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
