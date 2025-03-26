package com.alticelabs.exagon.api.repository.model;

import java.util.List;

/**
 * Represents an abstract entity with a unique identifier.
 * This class provides a mechanism to reconstruct the entity's state from a list of events.
 */
public abstract class Entity {

    /**
     * The unique identifier of the entity.
     */
    private String id;

    /**
     * Constructs an entity with the given identifier.
     *
     * @param ID the unique identifier of the entity
     */
    public Entity(String ID) {
        this.id = ID;
    }

    /**
     * Retrieves the unique identifier of the entity.
     *
     * @return the entity's ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the unique identifier of the entity.
     *
     * @param id the new identifier to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Reconstructs the entity's state from a list of events.
     * Each event represents a change applied to the entity over time.
     *
     * @param events the list of events used to restore the entity's state
     */
    public abstract void reconstruct(List<EntityEvent> events);

}
