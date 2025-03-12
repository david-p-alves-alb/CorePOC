package com.alticelabs.core.repo_persistence;

import com.alticelabs.repository.api.Transaction;
import com.alticelabs.repository.api.TransactionLog;

public class TransactionLogAdapter implements TransactionLog {
    private final com.alticelabs.persistenceprovider.api.TransactionLog transactionLog;

    public TransactionLogAdapter(com.alticelabs.persistenceprovider.api.TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    @Override
    public void start(String token) {
        transactionLog.start(token);
    }

    @Override
    public Transaction getNext() {
        com.alticelabs.persistenceprovider.api.Transaction logNext = transactionLog.getNext();
        TransactionAdapter transaction = new TransactionAdapter(logNext);
        return transaction;
    }
}
