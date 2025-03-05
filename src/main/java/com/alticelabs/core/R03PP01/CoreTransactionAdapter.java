package com.alticelabs.core.R03PP01;

import com.alticelabs.persistenceprovider.PP01.Transaction;
import com.alticelabs.repository.R03.RepoTransaction;
import org.bson.conversions.Bson;

public class CoreTransactionAdapter implements RepoTransaction {
    private final Transaction transaction;

    public CoreTransactionAdapter(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String getToken() {
        return this.transaction.getToken();
    }

    @Override
    public String getCollection() {
        return transaction.getCollection();
    }

    @Override
    public Bson getDocument() {
        return transaction.getDocument();
    }
}
