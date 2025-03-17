package com.alticelabs.exagon.core.repo_pubsub;

import com.alticelabs.exagon.pubsub.api.PubSubTopic;
import com.alticelabs.exagon.repository.api.interfaces.PubSubChannel;
import com.alticelabs.exagon.repository.api.interfaces.SubscriptionHandler;

import java.util.Map;

public class PubSubChannelAdapter implements PubSubChannel {
    private final PubSubTopic topic;

    public PubSubChannelAdapter(PubSubTopic topic) {
        this.topic = topic;
    }

    @Override
    public void publish(String key, Map<String, String> headers, String message) {
        this.topic.publish(key,headers,message);
    }

    @Override
    public void subscribe(SubscriptionHandler handler) {
        this.topic.subscribe(new SubscriptionHandlerAdapter(handler));
    }
}
