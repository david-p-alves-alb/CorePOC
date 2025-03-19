package com.alticelabs.exagon.core.repo_persistence;

import com.alticelabs.exagon.repository.api.interfaces.Transaction;
import com.alticelabs.exagon.repository.api.interfaces.TransactionLog;

public class TransactionLogAdapter implements TransactionLog {
    private final com.alticelabs.exagon.persistence_provider.api.TransactionLog transactionLog;

    public TransactionLogAdapter(com.alticelabs.exagon.persistence_provider.api.TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    @Override
    public void start(String token) {
        transactionLog.start(token);
    }

    @Override
    public Transaction getNext() {
        com.alticelabs.exagon.persistence_provider.api.Transaction logNext = transactionLog.getNext();
        TransactionAdapter transaction = new TransactionAdapter(logNext);
        return transaction;
    }
}
