package com.alticelabs.exagon_working.pubsub_lib.api;

import com.alticelabs.exagon_working.infra_lib.pubsub.IExagonMessagingChannel;
import com.alticelabs.exagon_working.infra_lib.pubsub.IExagonMessagingHandler;
import com.alticelabs.exagon_working.infra_lib.pubsub.IExagonRebalanceListener;
import com.alticelabs.exagon_working.infra_lib.pubsub.MessagingHandlerPriority;

import java.util.Map;

/**
 *  Implementation of the {@link IExagonMessagingChannel} interface.
 */
public class MessagingChannel implements IExagonMessagingChannel {

    /** The name of the messaging channel. */
    private final String name;

    /**
     * Constructs a new messaging channel with the specified name.
     *
     * @param name the name of the messaging channel
     */
    protected MessagingChannel(String name) {
        this.name = name;
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
