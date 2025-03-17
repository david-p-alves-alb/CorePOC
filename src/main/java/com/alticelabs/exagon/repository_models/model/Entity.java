package com.alticelabs.exagon.repository_models.model;

import org.bson.conversions.Bson;

import java.util.List;

/**
 * A base para entidades de uma arquitetura de Event Sourcing. Estas entidades podem ser reconstruída a partir de uma
 * sequência de eventos.
 */
public abstract class Entity {
    private String id;

    public Entity(String ID) {
        this.id = ID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Reconstrói o estado da entidade a partir de uma lista de eventos.
     * Cada evento representa uma mudança aplicada à entidade ao longo do tempo.
     *
     * @param events a lista de eventos usados para restaurar o estado da entidade
     */
    public abstract void reconstruct(List<EntityEvent> events);
    public abstract Bson toBson();
}
