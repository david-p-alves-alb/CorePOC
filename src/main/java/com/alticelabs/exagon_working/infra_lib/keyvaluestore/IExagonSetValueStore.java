package com.alticelabs.exagon_working.infra_lib.keyvaluestore;

import com.alticelabs.exagon.infra_lib.InfraException;

import java.util.List;

/**
 * Interface representing a set-value store that supports set-based operations.
 *
 * @param <T> the type of values stored in the set-value store
 */
public interface IExagonSetValueStore<T> extends IExagonKeyValueStore<T> {

    /**
     * Retrieves all keys from a set associated with the specified key.
     *
     * @return a list of all keys within the set, or an empty list if the set does not exist or no keys are found
     * @throws InfraException if an error occurs while retrieving the keys
     */
    List<String> getAllKeys() throws InfraException;
}
