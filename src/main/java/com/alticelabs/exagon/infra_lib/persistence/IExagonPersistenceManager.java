package com.alticelabs.exagon.infra_lib.persistence;

import com.alticelabs.exagon.mongo_lib.api.TransactionLog;

import java.util.List;

/**
 * Interface representing the Persistence Manager for managing datasources and transaction logs.
 * <p>
 * This interface provides methods for creating and retrieving datasources and transaction logs, which can be used for
 * performing CRUD operations and tracking transactions.
 */
public interface IExagonPersistenceManager {

    /**
     * Creates and returns a new instance of {@link IExagonDatasource} based on the specified collection name.
     * If a datasource for the given name already exists, the same instance is returned.
     *
     * @param name the name of the collection for which the datasource will be created
     * @param modelType the class type of the model stored in the datasource
     * @param <T> the type of the model
     * @return an instance of {@link IExagonDatasource} associated with the given collection name
     */
    <T> IExagonDatasource<T> getDatasource(String name, Class<T> modelType);

    /**
     * Creates and returns an instance of {@link TransactionLog}.
     * This method can only be called once; subsequent calls will throw an exception.
     *
     * @param filters a list of filters to be applied to the Transaction Log. Transactions that do not meet the filters will be ignored.
     * @return an instance of {@link IExagonTransactionLog}
     * @throws TransactionLogException if {@code getTransactionLog} is called more than once
     */
    IExagonTransactionLog getTransactionLog(List<TransactionFilter> filters) throws TransactionLogException;

}
