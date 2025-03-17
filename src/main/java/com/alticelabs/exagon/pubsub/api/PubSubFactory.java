package com.alticelabs.exagon.pubsub.api;

import java.util.HashMap;
import java.util.Map;

public class PubSubFactory {
    private static PubSubFactory INSTANCE = new PubSubFactory();
    private final Map<String, PubSubTopic> createdChannels;
    private PubSubFactory() {
        this.createdChannels = new HashMap<>();
    }

    public static PubSubFactory getINSTANCE() {
        return INSTANCE;
    }

    public PubSubTopic getChannel(String channelName) {
        if (createdChannels.containsKey(channelName)) {
            return createdChannels.get(channelName);
        }
        PubSubTopic pubSubTopic = new PubSubTopic(channelName, CommitMode.BEFORE_HANDLER);
        createdChannels.put(channelName, pubSubTopic);
        return pubSubTopic;
    }

    public PubSubTopic getPriorityChannel(String channelName) {
        if (createdChannels.containsKey(channelName)) {
            return createdChannels.get(channelName);
        }
        PubSubTopic pubSubTopic = new PubSubTopic(channelName, CommitMode.AFTER_HANDLER);
        createdChannels.put(channelName, pubSubTopic);
        return pubSubTopic;
    }

    public void start() {}
}
