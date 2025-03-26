package com.alticelabs.exagon2.core.repo_pubsub;

import com.alticelabs.exagon2.core.api.PubSubChannel;
import com.alticelabs.exagon.repository.api.interfaces.PubSubFactory;

public class PubSubFactoryAdapter implements PubSubFactory {

    public PubSubFactoryAdapter() {

    }

    @Override
    public com.alticelabs.exagon.repository.api.interfaces.PubSubChannel getPriorityChannel(String destination) {
        PubSubChannel priorityChannel = com.alticelabs.exagon2.core.api.PubSubFactory.getINSTANCE().getPriorityChannel(destination);
        return new PubSubChannelAdapter(priorityChannel);
    }

    @Override
    public com.alticelabs.exagon.repository.api.interfaces.PubSubChannel getChannel(String destination) {
        PubSubChannel channel = com.alticelabs.exagon2.core.api.PubSubFactory.getINSTANCE().getChannel(destination);
        return new PubSubChannelAdapter(channel);
    }
}
