package com.alticelabs.exagon.infra_lib.persistence;

/**
 * Exception representing an error in the persistence layer.
 *
 * <p>This exception is thrown when an issue occurs while performing
 * persistence operations.</p>
 */
public class PersistenceException extends Throwable {
    /**
     * Constructs a new {@link PersistenceException} with no detail message.
     */
    public PersistenceException() {}

    /**
     * Constructs a new {@link PersistenceException} with the specified detail message.
     *
     * @param message the detail message that describes the cause of the exception
     */
    public PersistenceException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@link PersistenceException} with the specified detail message
     * and cause.
     *
     * @param message the detail message that describes the cause of the exception
     * @param cause the cause of the exception (a {@link Throwable} object which is saved for later retrieval)
     */
    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new {@link PersistenceException} with the specified cause.
     *
     * @param cause the cause of the exception (a {@link Throwable} object which is saved for later retrieval)
     */
    public PersistenceException(Throwable cause) {
        super(cause);
    }
}
