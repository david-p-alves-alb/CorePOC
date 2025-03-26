package com.alticelabs.exagon2.core.repo_persistence;

import com.alticelabs.exagon2.core.repository.api.interfaces.Transaction;
import com.alticelabs.exagon2.core.repository.api.interfaces.TransactionLog;

public class TransactionLogAdapter implements TransactionLog {
    private final com.alticelabs.exagon.mongo_lib.api.TransactionLog transactionLog;

    public TransactionLogAdapter(com.alticelabs.exagon.mongo_lib.api.TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    @Override
    public void start(String token) {
        transactionLog.start(token);
    }

    @Override
    public Transaction getNext() {
        com.alticelabs.exagon.infra_lib.persistence.Transaction logNext = transactionLog.getNext();
        TransactionAdapter transaction = new TransactionAdapter(logNext);
        return transaction;
    }
}
