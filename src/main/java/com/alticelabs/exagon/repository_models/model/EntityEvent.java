package com.alticelabs.exagon.repository_models.model;

import org.bson.conversions.Bson;

/**
 * A base para eventos que representam uma alteração a ser aplicada a uma entidade.
 * Cada evento está associado a uma entidade.
 */
public abstract class EntityEvent {

    /** O nome da classe da entidade afetada por este evento. */
    private String childClass;
    private String id;


    public EntityEvent(String ID) {
        this.id = ID;
    }

    public String getChildClass() {
        return this.childClass;
    }

    public void setChildClass(String childClass) {
        this.childClass = childClass;
    }

    public abstract Bson toBson();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
