package com.alticelabs.exagon.infra_lib.persistence;

import java.util.List;

/**
 * Represents a filter for transactions, allowing transactions to be filtered by name and operation.
 */
public class TransactionFilter {
    /**
     * The name of the collection to be filtered.
     */
    String name;

    /**
     * A list of transaction operations to filter.
     */
    List<TransactionOperation> operations;

    /**
     * Default constructor for creating an empty {@link TransactionFilter}.
     */
    public TransactionFilter() {
    }

    /**
     * Constructs a {@link TransactionFilter} with the specified collection name and list of operations.
     *
     * @param name the name of the collection to be filtered
     * @param operations the list of transaction operations to filter
     */
    public TransactionFilter(String name, List<TransactionOperation> operations) {
        this.name = name;
        this.operations = operations;
    }
}
