package com.alticelabs.exagon_working.infra_lib.pubsub;

import java.util.Map;

/**
 * Interface representing a handler of messages for an {@link IExagonMessagingChannel}.
 * This interface specifies the behavior for processing messages received from a messaging channel.
 */
public interface IExagonMessagingHandler {

    /**
     * Executes the processing of a received message.
     *
     * @param key the key associated with the message
     * @param headers the headers of the message, represented as a key-value map
     * @param message the content of the message
     */
    void execute(String key, Map<String, String> headers, String message);
}