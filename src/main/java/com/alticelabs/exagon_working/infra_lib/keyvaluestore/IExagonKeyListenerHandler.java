package com.alticelabs.exagon_working.infra_lib.keyvaluestore;

import com.alticelabs.exagon.infra_lib.InfraException;

/**
 * Interface for handling key-related events in an {@link IExagonKeyValueStore}.
 */
public interface IExagonKeyListenerHandler {

    /**
     * Executes an operation when a key expires.
     *
     * @param expiredKey the key that has expired
     * @throws InfraException if an error occurs during execution
     * TODO: Faz sentido o InfraException? Se a key expira e der exception o que acontece?
     */
    void executeOperation(String expiredKey) throws InfraException;
}