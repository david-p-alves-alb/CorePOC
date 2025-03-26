package com.alticelabs.exagon2.core.repo_pubsub;

import com.alticelabs.exagon2.core.api.PubSubChannel;
import com.alticelabs.exagon2.core.repository.api.interfaces.SubscriptionHandler;

import java.util.Map;

public class PubSubChannelAdapter implements com.alticelabs.exagon.repository.api.interfaces.PubSubChannel {
    private final PubSubChannel topic;

    public PubSubChannelAdapter(PubSubChannel topic) {
        this.topic = topic;
    }

    @Override
    public void publish(String key, Map<String, String> headers, String message) {
        this.topic.publish(key,headers,message);
    }

    @Override
    public void subscribe(SubscriptionHandler handler,boolean priority) {
        this.topic.subscribe(new SubscriptionHandlerAdapter(handler),priority);
    }
}
