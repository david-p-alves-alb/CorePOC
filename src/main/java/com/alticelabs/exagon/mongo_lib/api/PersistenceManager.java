package com.alticelabs.exagon.mongo_lib.api;

import com.alticelabs.exagon.infra_lib.IExagonDefaultAPI;
import com.alticelabs.exagon.infra_lib.InfraException;
import com.alticelabs.exagon.infra_lib.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Persistence API Manager.
 *
 * <p>This class implements the Singleton pattern to ensure a single global instance and provides methods to obtain {@link IExagonDatasource} and {@link IExagonTransactionLog}.</p>
 */

public class PersistenceManager implements IExagonPersistenceManager, IExagonDefaultAPI {

    /** The singleton instance of the PersistenceManager. */
    private static final PersistenceManager persistenceManager = new PersistenceManager();

    /** List of already created Datasources, mapped by their name. */
    private final Map<String, IExagonDatasource> createdDatasources;

    /**
     * Private constructor to initialize the list of created datasources.
     * This constructor is used internally and ensures the Singleton pattern.
     */
    private PersistenceManager() {
        this.createdDatasources = new HashMap<>();
    }

    /**
     * Retrieves the singleton instance of PersistenceManager.
     *
     * @return the singleton instance of PersistenceManager
     */
    public static PersistenceManager getInstance() {
        return persistenceManager;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Starts the PersistenceManager, initializing all necessary components.
     * This method should be called after all datasources and the TransactionLog are obtained.
     *
     * <p>If the manager is unable to connect to the persistence provider (e.g., MongoDB), it will throw an {@link InfraException}.</p>
     */
    public void start() {}

    /**
     * {@inheritDoc}
     * <p>
     * Stops the PersistenceManager and releases resources.
     * This method stops all ongoing processes and closes connections to the datasource.
     */
    public void stop() {}

    public <T> IExagonDatasource<T> getDatasource(String name, Class<T> modelType) {
        return null;
    }

    public IExagonTransactionLog getTransactionLog(List<TransactionFilter> filters) {
        return null;
    }


}
