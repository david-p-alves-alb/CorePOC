package com.alticelabs.pubsub.api;

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
        return new PubSubTopic(channelName,CommitMode.BEFORE_HANDLER);
    }

    public PubSubTopic getPriorityChannel(String channelName) {
        return new PubSubTopic(channelName,CommitMode.AFTER_HANDLER);
    }

    public void start() {}
}
