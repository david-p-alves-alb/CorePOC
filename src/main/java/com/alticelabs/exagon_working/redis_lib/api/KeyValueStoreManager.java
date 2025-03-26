package com.alticelabs.exagon_working.redis_lib.api;

import com.alticelabs.exagon.infra_lib.IExagonDefaultAPI;
import com.alticelabs.exagon.infra_lib.InfraException;
import com.alticelabs.exagon_working.infra_lib.keyvaluestore.IExagonKeyListenerHandler;
import com.alticelabs.exagon_working.infra_lib.keyvaluestore.IExagonKeyValueStore;
import com.alticelabs.exagon_working.infra_lib.keyvaluestore.IExagonKeyValueStoreManager;

/**
 * Implementation of the {@link IExagonKeyValueStoreManager} and {@link IExagonDefaultAPI} interfaces.
 * Manages key-value store instances and provides lifecycle management.
 */
public class KeyValueStoreManager implements IExagonKeyValueStoreManager, IExagonDefaultAPI {

    /** The singleton instance of the KeyValueStoreManager. */
    private static final KeyValueStoreManager keyValueStoreManager = new KeyValueStoreManager();

    /**
     * Private constructor to initialize the list of created datasources.
     * This constructor is used internally and ensures the Singleton pattern.
     */
    private KeyValueStoreManager() { }

    /**
     * Retrieves the singleton instance of KeyValueStoreManager.
     *
     * @return the singleton instance of KeyValueStoreManager
     */
    public static KeyValueStoreManager getInstance() {
        return keyValueStoreManager;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Starts the KeyValueStoreManager.
     *
     * @throws InfraException if an error occurs during startup
     */
    @Override
    public void start() throws InfraException {

    }

    /**
     * {@inheritDoc}
     * <p>
     * Stops the KeyValueStoreManager.
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
    public <T> IExagonKeyValueStore<T> getValueStore(String name, Class<T> modelType) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> IExagonKeyValueStore<T> getValueStore(String name, Class<T> modelType, IExagonKeyListenerHandler handler) {
        return null;
    }
}
