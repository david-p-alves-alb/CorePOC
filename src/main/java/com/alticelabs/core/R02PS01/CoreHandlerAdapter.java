package com.alticelabs.core.R02PS01;

import com.alticelabs.pubsub.PS01.PubSubHandler;
import com.alticelabs.repository.R02.RepoSubscriptionHandler;

import java.util.Map;

public class CoreHandlerAdapter implements PubSubHandler {
    private final RepoSubscriptionHandler subscriptionHandler;

    public CoreHandlerAdapter(RepoSubscriptionHandler subscriptionHandler) {
        this.subscriptionHandler = subscriptionHandler;
    }

    @Override
    public void execute(String key, Map<String, String> headers, String message) {
        subscriptionHandler.execute(key,headers,message);
    }
}
