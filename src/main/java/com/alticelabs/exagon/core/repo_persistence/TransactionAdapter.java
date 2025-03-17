package com.alticelabs.exagon.core.repo_persistence;

import com.alticelabs.exagon.repository.api.interfaces.Transaction;
import org.bson.conversions.Bson;

public class TransactionAdapter implements Transaction {
    private final com.alticelabs.exagon.persistenceprovider.api.Transaction transaction;

    public TransactionAdapter(com.alticelabs.exagon.persistenceprovider.api.Transaction transaction) {
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
