package com.alticelabs.exagon.infra_lib.persistence;

/**
 * Interface for a TransactionLog, allowing for retrieval, and committing of transactions.
 * <p>
 * This interface provides methods to manage a transaction log, including starting and stopping the log,
 * retrieving the next transaction, and committing the transactions. The transaction log helps in tracking
 * modifications over time and ensuring the persistence layer remains consistent.
 */
public interface IExagonTransactionLog {

    /**
     * Starts the transaction log.
     * <p>
     * This method begins the process of recording modifications in the transaction log.
     * It allows for retrieving transactions using {@link #getNext()}.
     * @throws PersistenceException if an error occurs while starting the transaction log
     */
    void start() throws PersistenceException;

    /**
     * Stops the transaction log.
     * This method stops the TransactionLog but does not commit ongoing transactions.
     */
    void stop();

    /**
     * Retrieves the next recorded modification in the transaction log.
     *
     * @return the next transaction recorded in the log, or null if no transactions are available.
     * @throws PersistenceException if an error occurs while retrieving the transaction,
     * or if called at an invalid time (before {@link #start()} or after {@link #stop()}).
     */
    Transaction getNext() throws PersistenceException;;

    /**
     * Instructs the TransactionLog to acknowledge all transactions received since the last commit.
     * If the commit is not called the same transaction may be duplicated
     *
     * @throws PersistenceException if an error occurs during commit
     */
    void commit() throws PersistenceException;

}
