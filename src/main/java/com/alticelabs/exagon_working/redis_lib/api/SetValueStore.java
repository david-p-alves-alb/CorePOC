package com.alticelabs.exagon_working.redis_lib.api;

import com.alticelabs.exagon.infra_lib.InfraException;
import com.alticelabs.exagon_working.infra_lib.keyvaluestore.IExagonSetValueStore;

import java.util.List;

/**
 * Implementation of the {@link IExagonSetValueStore} interface.
 *
 * @param <T> the type of value stored in the key-value store
 */
public class SetValueStore<T> implements IExagonSetValueStore<T> {

    /** The name of the key-value store. */
    private String name;

    /** The type of model managed by the datasource. */
    private final Class<T> modelType;

    /**
     * Constructs a new KeyValueStore instance.
     *
     * @param name the name of the key-value store
     * @param modelType the class type of the model stored in the key-value store
     */
    protected SetValueStore(String name, Class<T> modelType) {
        this.name = name;
        this.modelType = modelType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void put(String key, T value) throws InfraException {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void put(String key, T value, long ttl) throws InfraException {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean putIfAbsent(String key, T value, long ttl) throws InfraException {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(String key) throws InfraException {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(String key) throws InfraException {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getAllKeys() throws InfraException {
        return List.of();
    }
}