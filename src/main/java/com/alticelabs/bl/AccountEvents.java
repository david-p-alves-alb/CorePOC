package com.alticelabs.bl;

import com.alticelabs.exagon.api.repository.model.EntityEvent;

public abstract class AccountEvents extends EntityEvent {
    public AccountEvents(String ID) {
        super(ID);
    }
}
