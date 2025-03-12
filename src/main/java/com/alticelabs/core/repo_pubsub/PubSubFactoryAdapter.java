package com.alticelabs.core.repo_pubsub;

import com.alticelabs.pubsub.api.PubSubTopic;
import com.alticelabs.repository.api.PubSubChannel;
import com.alticelabs.repository.api.PubSubFactory;

public class PubSubFactoryAdapter implements PubSubFactory {

    public PubSubFactoryAdapter() {

    }

    @Override
    public PubSubChannel getPriorityChannel(String destination) {
        PubSubTopic priorityChannel = com.alticelabs.pubsub.api.PubSubFactory.getINSTANCE().getPriorityChannel(destination);
        return new PubSubChannelAdapter(priorityChannel);
    }

    @Override
    public PubSubChannel getChannel(String destination) {
        PubSubTopic channel = com.alticelabs.pubsub.api.PubSubFactory.getINSTANCE().getChannel(destination);
        return new PubSubChannelAdapter(channel);
    }
}
