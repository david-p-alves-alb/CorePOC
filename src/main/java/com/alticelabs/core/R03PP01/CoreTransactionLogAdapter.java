package com.alticelabs.core.R03PP01;

import com.alticelabs.persistenceprovider.PP01.Transaction;
import com.alticelabs.persistenceprovider.PP01.TransactionLog;
import com.alticelabs.repository.R03.RepoTransaction;
import com.alticelabs.repository.R03.RepoTransactionLog;

public class CoreTransactionLogAdapter implements RepoTransactionLog {
    private final TransactionLog transactionLog;

    public CoreTransactionLogAdapter(TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    @Override
    public void start(String token) {
        transactionLog.start(token);
    }

    @Override
    public RepoTransaction getNext() {
        Transaction logNext = transactionLog.getNext();
        CoreTransactionAdapter transaction = new CoreTransactionAdapter(logNext);
        return transaction;
    }
}
