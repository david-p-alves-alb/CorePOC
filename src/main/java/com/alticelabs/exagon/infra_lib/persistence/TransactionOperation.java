package com.alticelabs.exagon.infra_lib.persistence;

/**
 * Enumerates the available transaction operations on the {@link IExagonTransactionLog} .
 * <p>
 * This enumeration defines the types of operations that a transaction can have:
 * <ul>
 *   <li>{@link #INSERT} - Represents the insertion of a new record.</li>
 *   <li>{@link #UPDATE} - Represents the update of an existing record.</li>
 *   <li>{@link #DELETE} - Represents the removal of a record.</li>
 * </ul>
 *
 */
public enum TransactionOperation {
    /**
     * Operation for inserting a new record.
     */
    INSERT,

    /**
     * Operation for updating an existing record.
     */
    UPDATE,

    /**
     * Operation for deleting a record.
     */
    DELETE
}
