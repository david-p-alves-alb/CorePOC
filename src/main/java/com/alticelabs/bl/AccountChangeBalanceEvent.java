package com.alticelabs.bl;

import org.bson.Document;
import org.bson.conversions.Bson;

public class AccountChangeBalanceEvent extends AccountEvents {
    private final int balanceChange;

    public AccountChangeBalanceEvent(int balanceChange) {
        this.balanceChange = balanceChange;
    }

    public int getBalanceChange() {
        return balanceChange;
    }

    @Override
    public Bson toBson() {
        Document doc = new Document();
        doc.append("balanceChange", balanceChange);
        return doc;
    }
}
