package com.alticelabs.exagon.infra_lib.persistence;

import java.util.Map;

/**
 * Represents a modification in a repository, containing information about the token, collection, and associated document.
 * This class encapsulates modification data for use in repository operations.
 */

public class Transaction {

    /** The name of the collection associated with the transaction. */
    private final String name;

    /** The type of transaction operation performed. */
    private final TransactionOperation operation;

    /** The document modified in the transaction. */
    private final Map<String, Object> data;

    /**
     * Constructs a new modification with the specified collection name, operation, and document.
     *
     * @param name      the name of the collection
     * @param operation the type of operation performed
     * @param data      the document modified
     */
    public Transaction(String name, TransactionOperation operation, Map<String, Object> data) {
        this.name = name;
        this.operation = operation;
        this.data = data;
    }

    /**
     * Retrieves the document of the modification.
     *
     * @return the document of the modification
     */

    public Map<String, Object> getData() {
        return data;
    }

    /**
     * Retrieves the name of the collection associated with the modification.
     *
     * @return the name of the collection
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the type of transaction operation performed.
     *
     * @return the transaction operation
     */
    public TransactionOperation getOperation() {
        return operation;
    }
}
