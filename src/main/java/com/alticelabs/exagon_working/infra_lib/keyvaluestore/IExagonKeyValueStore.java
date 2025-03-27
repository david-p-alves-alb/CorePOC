package com.alticelabs.exagon_working.infra_lib.keyvaluestore;

import com.alticelabs.exagon.infra_lib.InfraException;

/**
 * Interface representing a key-value store with support for various operations.
 *
 * @param <T> the type of the value stored in the key-value store
 */
public interface IExagonKeyValueStore<T> {

    /**
     * Stores a value associated with the specified key.
     *
     * @param key the key to store the value under
     * @param value the value to be stored
     * @throws InfraException if an error occurs while storing the value
     */
    void put(String key, T value) throws InfraException;

    /**
     * Stores a value with a specified time-to-live (TTL).
     *
     * @param key the key to store the value under
     * @param value the value to be stored
     * @param ttl the time-to-live in milliseconds. Must be greater than zero.
     * @throws InfraException if an error occurs while storing the value
     */
    void put(String key, T value, long ttl) throws InfraException;

    /**
     * Stores a value if the key is not already present, with a specified TTL.
     *
     * @param key the key to store the value under
     * @param value the value to be stored
     * @param ttl the time-to-live in milliseconds. Must be greater than zero.
     * @return {@code true} if the value was stored, {@code false} if the key already exists
     * @throws InfraException if an error occurs while storing the value
     */
    boolean putIfAbsent(String key, T value, long ttl) throws InfraException;

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key the key whose value is to be retrieved
     * @return the value associated with the key, or {@code null} if the key does not exist
     * @throws InfraException if an error occurs while retrieving the value
     */
    T get(String key) throws InfraException;

    /**
     * Deletes the specified key and its associated value.
     *
     * @param key the key to be deleted
     * @return {@code true} if the key was deleted, {@code false} if the key was not found
     * @throws InfraException if an error occurs while deleting the key
     */
    boolean delete(String key) throws InfraException;
}
