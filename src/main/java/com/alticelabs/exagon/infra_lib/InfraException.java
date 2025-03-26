package com.alticelabs.exagon.infra_lib;

/**
 * Exception thrown when Exagon infra encounters a problem.
 */
public abstract class InfraException extends Exception {

    /**
     * Constructs a new InfraException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public InfraException(String message) {
        super(message);
    }

    /**
     * Constructs a new InfraException with the specified detail message and cause.
     *
     * @param message the detail message explaining the reason for the exception
     * @param cause the cause of the exception
     */
    public InfraException(String message, Throwable cause) {
        super(message, cause);
    }

}
