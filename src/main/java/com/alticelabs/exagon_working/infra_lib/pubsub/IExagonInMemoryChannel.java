package com.alticelabs.exagon_working.infra_lib.pubsub;


/**
 * Interface representing an in-memory pub-sub channel.
 * This interface allows publishing messages and subscribing messages using handlers to process them.
 *
 */
public interface IExagonInMemoryChannel {

    /**
     * Publishes a message to the channel with a specific key.
     *
     * @param message the content of the message
     */
    void publish(String message);

    /**
     * Subscribes messages from the channel using a handler to process received messages.
     *
     * @param handler the handler that will process the messages
     */
    void subscribe(IExagonInMemoryHandler handler);
}