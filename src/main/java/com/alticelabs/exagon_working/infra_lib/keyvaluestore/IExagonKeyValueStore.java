package com.alticelabs.exagon_working.infra_lib.keyvaluestore;

import com.alticelabs.exagon.infra_lib.InfraException;

import java.util.List;

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

    /**
     * Stores a value in a set associated with the specified key and field.
     *
     * @param key the key of the set
     * @param field the field within the set
     * @param value the value to be stored
     * @throws InfraException if an error occurs while storing the value
     */
    void putSet(String key, String field, T value) throws InfraException;

    /**
     * Retrieves all keys from a set associated with the specified key.
     *
     * @param key the key of the set
     * @return a list of all keys within the set, or an empty list if the set does not exist or no keys are found
     * @throws InfraException if an error occurs while retrieving the keys
     */
    List<String> getAllKeysFromSet(String key) throws InfraException;
}
