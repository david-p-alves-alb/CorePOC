package com.alticelabs.exagon.pubsub.api;

import java.util.HashMap;
import java.util.Map;

public class PubSubFactory {
    private static PubSubFactory INSTANCE = new PubSubFactory();
    private final Map<String, PubSubChannel> createdChannels;
    private PubSubFactory() {
        this.createdChannels = new HashMap<>();
    }

    public static PubSubFactory getINSTANCE() {
        return INSTANCE;
    }

    public PubSubChannel getChannel(String id) {
        if (createdChannels.containsKey(id)) {
            return createdChannels.get(id);
        }
        PubSubChannel pubSubChannel = new PubSubChannel(id, CommitMode.BEFORE_HANDLER);
        createdChannels.put(id, pubSubChannel);
        return pubSubChannel;
    }

    public PubSubChannel getPriorityChannel(String id) {
        if (createdChannels.containsKey(id)) {
            return createdChannels.get(id);
        }
        PubSubChannel pubSubChannel = new PubSubChannel(id, CommitMode.AFTER_HANDLER);
        createdChannels.put(id, pubSubChannel);
        return pubSubChannel;
    }

    public void start() {}
}
