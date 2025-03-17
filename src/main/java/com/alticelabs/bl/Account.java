package com.alticelabs.bl;

import com.alticelabs.exagon.repository_models.model.Entity;
import com.alticelabs.exagon.repository_models.model.EntityEvent;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public class Account extends Entity {

    private String name;
    private int balance;

    public Account(String ID, String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    @Override
    public void reconstruct(List<EntityEvent> events) {
        for (EntityEvent event : events) {
            if (event instanceof AccountChangeBalanceEvent accountChangeBalanceEvent) {
                this.balance = accountChangeBalanceEvent.getBalanceChange();
            }
        }
    }

    @Override
    public Bson toBson() {
        Document doc = new Document();
        doc.put("name", name);
        doc.put("balance", balance);
        return doc;
    }

    public int getBalance() {
        return balance;
    }
}
