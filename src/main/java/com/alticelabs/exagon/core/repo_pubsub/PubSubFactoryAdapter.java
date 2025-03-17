package com.alticelabs.exagon.core.repo_pubsub;

import com.alticelabs.exagon.pubsub.api.PubSubTopic;
import com.alticelabs.exagon.repository.api.interfaces.PubSubChannel;
import com.alticelabs.exagon.repository.api.interfaces.PubSubFactory;

public class PubSubFactoryAdapter implements PubSubFactory {

    public PubSubFactoryAdapter() {

    }

    @Override
    public PubSubChannel getPriorityChannel(String destination) {
        PubSubTopic priorityChannel = com.alticelabs.exagon.pubsub.api.PubSubFactory.getINSTANCE().getPriorityChannel(destination);
        return new PubSubChannelAdapter(priorityChannel);
    }

    @Override
    public PubSubChannel getChannel(String destination) {
        PubSubTopic channel = com.alticelabs.exagon.pubsub.api.PubSubFactory.getINSTANCE().getChannel(destination);
        return new PubSubChannelAdapter(channel);
    }
}
