package com.alticelabs.exagon_working.redis_lib.api;

import com.alticelabs.exagon.infra_lib.IExagonDefaultAPI;
import com.alticelabs.exagon.infra_lib.InfraException;
import com.alticelabs.exagon_working.infra_lib.keyvaluestore.IExagonKeyListenerHandler;
import com.alticelabs.exagon_working.infra_lib.keyvaluestore.IExagonKeyValueStore;
import com.alticelabs.exagon_working.infra_lib.keyvaluestore.IExagonSetValueStore;
import com.alticelabs.exagon_working.infra_lib.keyvaluestore.IExagonValueStoreManager;

/**
 * Implementation of the {@link IExagonValueStoreManager} and {@link IExagonDefaultAPI} interfaces.
 * Manages key-value store instances and provides lifecycle management.
 */
public class ValueStoreManager implements IExagonValueStoreManager, IExagonDefaultAPI {

    /** The singleton instance of the ValueStoreManager. */
    private static final ValueStoreManager keyValueStoreManager = new ValueStoreManager();

    /**
     * Private constructor to initialize the list of created datasources.
     * This constructor is used internally and ensures the Singleton pattern.
     */
    private ValueStoreManager() { }

    /**
     * Retrieves the singleton instance of ValueStoreManager.
     *
     * @return the singleton instance of ValueStoreManager
     */
    public static ValueStoreManager getInstance() {
        return keyValueStoreManager;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Starts the ValueStoreManager.
     *
     * @throws InfraException if an error occurs during startup
     */
    @Override
    public void start() throws InfraException {

    }

    /**
     * {@inheritDoc}
     * <p>
     * Stops the ValueStoreManager.
     *
     * @throws InfraException if an error occurs during shutdown
     */
    @Override
    public void stop() throws InfraException {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> IExagonKeyValueStore<T> getKeyValueStore(String name, Class<T> modelType) {
        return null;
    }

    /**
     * {@inheritDoc}
     * If a key expires and no handler is registered, the expiration event will be lost.
     */
    @Override
    public <T> IExagonKeyValueStore<T> getKeyValueStore(String name, Class<T> modelType, IExagonKeyListenerHandler handler) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> IExagonSetValueStore<T> getSetValueStore(String name, Class<T> modelType) {
        return null;
    }
}
