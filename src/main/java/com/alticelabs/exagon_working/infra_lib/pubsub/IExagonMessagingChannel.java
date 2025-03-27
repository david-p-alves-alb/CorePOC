package com.alticelabs.exagon_working.infra_lib.pubsub;


import java.util.Map;

/**
 * Interface representing a messaging channel.
 * This interface provides methods for publishing messages, subscribing handlers, and registering rebalance listeners.
 */
public interface IExagonMessagingChannel {

    /**
     * Publishes a message to the channel with a specific key, headers, and content.
     *
     * @param key the key associated with the message
     * @param headers the headers of the message, represented as a key-value map
     * @param message the content of the message
     */
    void publish(String key, Map<String, String> headers, String message);

    /**
     * Subscribes a handler to the channel with a specified priority for message processing.
     *
     * @param handler the handler that will process the messages
     * @param priority the priority level for message delivery, as defined by {@link MessagingHandlerPriority}
     */
    void subscribe(IExagonMessagingHandler handler, MessagingHandlerPriority priority);

    /**
     * Registers a rebalance listener to handle partition revocation and assignment events.
     *
     * @param listener the listener that will respond to rebalancing events
     */
    void registerRebalanceListener(IExagonRebalanceListener listener);
}
