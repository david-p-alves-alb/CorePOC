package com.alticelabs.exagon2.core.api;


import java.util.List;
import java.util.Map;

public class PubSubChannel {
    private String id;
    private CommitMode commitMode;
    private List<PubSubHandler> priorityHandlers;
    private List<PubSubHandler> handlers;

    protected PubSubChannel(String id, CommitMode commitMode) {
        this.id = id;
        this.commitMode = commitMode;
    }

    public void publish(String key, Map<String, String> headers, String message) {}

    public void subscribe(PubSubHandler handler,boolean priority) {
        if (priority) {
            priorityHandlers.add(handler);
        } else {
            handlers.add(handler);
        }
    }

    public void rebalance(RebalanceListener rebalanceListener) {}
}
