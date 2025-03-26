package com.alticelabs.exagon.infra_lib;

/**
 * Default interface for starting and stopping Exagon modules.
 * This interface should be extended by other specific interfaces of the specific modules.
 */
public interface IExagonDefaultAPI {

    /**
     * Method to start a module.
     * Imperative use after any configuration needed.
     *
     * @throws InfraException if the module has any problem starting
     */
    void start() throws InfraException;


    /**
     * Method to stop a module.
     *
     * @throws InfraException if the module has any problem stopping
     */
    void stop() throws InfraException;

}
