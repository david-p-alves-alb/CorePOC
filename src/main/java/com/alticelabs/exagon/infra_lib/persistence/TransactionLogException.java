package com.alticelabs.exagon.infra_lib.persistence;

/**
 * Exception representing an error in the persistence layer.
 *
 * <p>This exception is thrown when an issue occurs while performing
 * persistence operations.</p>
 */
public class TransactionLogException extends PersistenceException {

    /**
     * Constructs a new {@link TransactionLogException} with no detail message.
     */
    public TransactionLogException() {}
}
