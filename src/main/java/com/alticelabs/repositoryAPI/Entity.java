package com.alticelabs.repositoryAPI;

import org.bson.conversions.Bson;

import java.util.List;

/**
 * A base para entidades de uma arquitetura de Event Sourcing. Estas entidades podem ser reconstruída a partir de uma
 * sequência de eventos.
 */
public abstract class Entity extends EntityID implements Bson {
    public Entity() {
    }

    public Entity(String ID) {
        super(ID);
    }

    /**
     * Reconstrói o estado da entidade a partir de uma lista de eventos.
     * Cada evento representa uma mudança aplicada à entidade ao longo do tempo.
     *
     * @param events a lista de eventos usados ​​para restaurar o estado da entidade
     */
    public abstract void reconstruct(List<EntityEvent> events);
}
