package com.alticelabs.core.R02PS01;

import com.alticelabs.pubsub.PS01.PubSubManager;
import com.alticelabs.repository.R02.RepoPubSub;
import com.alticelabs.repository.R02.RepoSubscriptionHandler;

import java.util.Map;

public class CorePubSubAdapter implements RepoPubSub {
    private final PubSubManager pubSubManager;

    public CorePubSubAdapter(PubSubManager pubSubManager) {
        this.pubSubManager = pubSubManager;
    }

    @Override
    public void publish(String destination, String key, Map<String, String> headers, String message) {
        pubSubManager.publish(destination, key, headers, message);
    }

    @Override
    public void subscribe(String destination, RepoSubscriptionHandler handler) {
        pubSubManager.subscribe(destination,new CoreHandlerAdapter(handler));
    }
}
