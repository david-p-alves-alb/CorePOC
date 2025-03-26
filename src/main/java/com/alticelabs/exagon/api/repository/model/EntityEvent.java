package com.alticelabs.exagon.api.repository.model;

/**
 * Represents an abstract event related to an entity.
 * This class provides a structure for tracking changes in entity instances.
 */
public abstract class EntityEvent {

    /**
     * The unique identifier of the event.
     */
    private String id;

    /**
     * The name of the class of the entity affected by this event.
     */
    private String childClass;

    /**
     * Constructs an entity event with the given identifier.
     *
     * @param ID the unique identifier of the event
     */
    public EntityEvent(String ID) {
        this.id = ID;
    }

    /**
     * Retrieves the class name of the affected entity.
     *
     * @return the entity's class name
     */
    public String getChildClass() {
        return this.childClass;
    }

    /**
     * Sets the class name of the affected entity.
     *
     * @param childClass the class name to set
     */
    public void setChildClass(String childClass) {
        this.childClass = childClass;
    }

    /**
     * Retrieves the unique identifier of the event.
     *
     * @return the event's ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the event.
     *
     * @param id the new identifier to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
