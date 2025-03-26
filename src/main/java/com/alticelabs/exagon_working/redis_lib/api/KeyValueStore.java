package com.alticelabs.exagon_working.redis_lib.api;

import com.alticelabs.exagon.infra_lib.InfraException;
import com.alticelabs.exagon_working.infra_lib.keyvaluestore.IExagonKeyValueStore;

import java.util.List;

/**
 * Implementation of the {@link IExagonKeyValueStore} interface.
 *
 * @param <T> the type of value stored in the key-value store
 */
public class KeyValueStore<T> implements IExagonKeyValueStore<T> {

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
    protected KeyValueStore(String name, Class<T> modelType) {
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
    public void put(String key, T value, long ttl) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean putIfAbsent(String key, T value, long ttl) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(String key) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean delete(String key) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void putSet(String key, String field, T value) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getAllKeysFromSet(String key) {
        return List.of();
    }
}