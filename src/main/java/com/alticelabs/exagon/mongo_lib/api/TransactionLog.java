package com.alticelabs.exagon.mongo_lib.api;

import com.alticelabs.exagon.infra_lib.IExagonDefaultAPI;
import com.alticelabs.exagon.infra_lib.persistence.*;

import java.util.List;

/**
 * Represents a transaction log for tracking modifications in all the Datasources.
 * This class provides methods to start the log and retrieve the next recorded modification.
 *
 */
public class TransactionLog implements IExagonTransactionLog, IExagonDefaultAPI {

    /**
     * Constructs a TransactionLog with a list of transaction filters.
     * This is only called by the PersistenceManager
     *
     * @param filters a list of filters to apply to the transaction log
     */
    protected TransactionLog(List<TransactionFilter> filters) {

    }

    public void start() {}

    public void stop() {}

    public Transaction getNext() {
        return null;
    }

    public void commit() throws PersistenceException {}
}
