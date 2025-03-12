package com.alticelabs.core.repo_pubsub;

import com.alticelabs.pubsub.api.PubSubTopic;
import com.alticelabs.repository.api.PubSubChannel;
import com.alticelabs.repository.api.SubscriptionHandler;

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
