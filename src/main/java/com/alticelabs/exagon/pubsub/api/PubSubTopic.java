package com.alticelabs.exagon.pubsub.api;


import java.util.List;
import java.util.Map;

public class PubSubTopic {
    private String destination;
    private CommitMode commitMode;
    private List<PubSubHandler> handlers;

    protected PubSubTopic(String destination,CommitMode commitMode) {
        this.destination = destination;
        this.commitMode = commitMode;
    }

    public void publish(String key, Map<String, String> headers, String message) {}

    public void subscribe(PubSubHandler handler) {
        handlers.add(handler);
    }

    public void rebalance(RebalanceListener rebalanceListener) {}
}
