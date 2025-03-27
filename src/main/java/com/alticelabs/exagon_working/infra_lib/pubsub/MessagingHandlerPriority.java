package com.alticelabs.exagon_working.infra_lib.pubsub;

/**
 * Enumerates the priority levels for messaging handlers.
 * This enum defines delivery guarantees for message processing in a messaging system.
 *
 */
public enum MessagingHandlerPriority {
    /**
     * Indicates that a message should be delivered at least once, ensuring no message is lost.
     */
    AT_LEAST_ONCE,

    /**
     * Indicates that a message should be delivered at most once, prioritizing efficiency over guaranteed delivery.
     */
    AT_MOST_ONCE
}