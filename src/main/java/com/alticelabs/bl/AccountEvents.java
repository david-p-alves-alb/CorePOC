package com.alticelabs.bl;

import com.alticelabs.exagon.repository_models.model.EntityEvent;

public abstract class AccountEvents extends EntityEvent {
    public AccountEvents(String ID) {
        super(ID);
    }
}
