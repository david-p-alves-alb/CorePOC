package com.alticelabs.pubsub.api;


import java.util.Map;

public class PubSubTopic {
    private String destination;
    private CommitMode commitMode;

    protected PubSubTopic(String destination,CommitMode commitMode) {
        this.destination = destination;
        this.commitMode = commitMode;
    }

    public void publish(String key, Map<String, String> headers, String message) {}

    public void subscribe(PubSubHandler handler) {}
}
