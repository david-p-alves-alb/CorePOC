package com.alticelabs.exagon_working.pubsub_lib.api;

import com.alticelabs.exagon_working.infra_lib.pubsub.*;

import java.util.Map;

/**
 *  Implementation of the {@link IExagonMessagingChannel} interface.
 */
public class MessagingChannel implements IExagonMessagingChannel {

    /** The name of the messaging channel. */
    private final String name;
    /** The source of the messaging channel. */
    private final MessagingSource source;
    /** The priority of the messaging channel. */
    private final MessagingChannelPriority priority;

    /**
     * Constructs a new messaging channel with the specified name.
     *
     * @param name the name of the messaging channel
     * @param source the source of the messaging channel
     * @param priority the priority of the messaging channel
     */
    protected MessagingChannel(String name, MessagingSource source, MessagingChannelPriority priority) {
        this.name = name;
        this.source = source;
        this.priority = priority;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void publish(String key, Map<String, String> headers, String message) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void subscribe(IExagonMessagingHandler handler, MessagingHandlerPriority priority) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerRebalanceListener(IExagonRebalanceListener listener) {}
}
