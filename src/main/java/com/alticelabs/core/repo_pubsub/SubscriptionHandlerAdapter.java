package com.alticelabs.core.repo_pubsub;

import com.alticelabs.pubsub.api.PubSubHandler;
import com.alticelabs.repository.api.SubscriptionHandler;

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
