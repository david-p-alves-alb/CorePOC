package com.alticelabs.exagon2.core.repo_pubsub;

import com.alticelabs.exagon2.core.api.PubSubHandler;
import com.alticelabs.exagon.repository.api.interfaces.SubscriptionHandler;

import java.util.Map;

public class SubscriptionHandlerAdapter implements PubSubHandler {
    private final SubscriptionHandler subscriptionHandler;

    public SubscriptionHandlerAdapter(SubscriptionHandler subscriptionHandler) {
        this.subscriptionHandler = subscriptionHandler;
    }

    @Override
    public void execute(String key, Map<String, String> headers, String message) {
        subscriptionHandler.execute(key,headers,message);
    }
}
