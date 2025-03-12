package com.alticelabs.repositoryAPI;

import org.bson.conversions.Bson;

/**
 * A base para eventos que representam uma alteração a ser aplicada a uma entidade.
 * Cada evento está associado a uma entidade.
 */
public abstract class EntityEvent extends EntityID implements Bson {

    /** O nome da classe da entidade afetada por este evento. */
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
