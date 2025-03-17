package com.alticelabs.exagon.core.repo_persistence;

import com.alticelabs.exagon.repository.api.interfaces.Transaction;
import com.alticelabs.exagon.repository.api.interfaces.TransactionLog;

public class TransactionLogAdapter implements TransactionLog {
    private final com.alticelabs.exagon.persistenceprovider.api.TransactionLog transactionLog;

    public TransactionLogAdapter(com.alticelabs.exagon.persistenceprovider.api.TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    @Override
    public void start(String token) {
        transactionLog.start(token);
    }

    @Override
    public Transaction getNext() {
        com.alticelabs.exagon.persistenceprovider.api.Transaction logNext = transactionLog.getNext();
        TransactionAdapter transaction = new TransactionAdapter(logNext);
        return transaction;
    }
}
