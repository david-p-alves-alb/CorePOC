package com.alticelabs.exagon_working.infra_lib.keyvaluestore;

/**
 * Interface for managing instances of {@link IExagonKeyValueStore}.
 * Provides methods to create and retrieve key-value store instances based on a specified name and model type.
 */
public interface IExagonKeyValueStoreManager {

    /**
     * Creates and returns a new instance of {@link IExagonKeyValueStore} based on the specified key-value name.
     * If a key-value store for the given name already exists, the same instance is returned.
     *
     * @param name the name of the collection for which the data source will be created
     * @param modelType the class type of the model stored in the key-value store
     * @param <T> the type of the model
     * @return an instance of {@link IExagonKeyValueStore} associated with the given key-value name
     */
    <T> IExagonKeyValueStore<T> getValueStore(String name, Class<T> modelType);

    /**
     * Creates and returns a new instance of {@link IExagonKeyValueStore} based on the specified key-value name,
     * with an additional key listener handler.
     * If a key-value store for the given name already exists, the same instance is returned.
     *
     * @param name the name of the collection for which the data source will be created
     * @param modelType the class type of the model stored in the key-value store
     * @param handler an instance of {@link IExagonKeyListenerHandler} to handle key-related events
     * @param <T> the type of the model
     * @return an instance of {@link IExagonKeyValueStore} associated with the given key-value name
     */
    <T> IExagonKeyValueStore<T> getValueStore(String name, Class<T> modelType, IExagonKeyListenerHandler handler);
}