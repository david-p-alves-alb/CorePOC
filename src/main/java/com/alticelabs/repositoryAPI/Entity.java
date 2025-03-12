package com.alticelabs.repositoryAPI;

import org.bson.conversions.Bson;

import java.util.List;

/**
 * The base for domain entities in an Event Sourcing architecture that can be reconstructed from a sequence of events.
 */
public abstract class Entity extends EntityID implements Bson {
    public Entity() {
    }

    public Entity(String ID) {
        super(ID);
    }

    /**
     * Reconstructs the entity's state from a list of events.
     * Each event represents a change applied to the entity over time.
     *
     * @param events the list of events used to restore the entity's state
     */
    public abstract void reconstruct(List<EntityEvent> events);
}
