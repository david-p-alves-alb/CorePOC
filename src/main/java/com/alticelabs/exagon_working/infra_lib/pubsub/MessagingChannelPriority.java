package com.alticelabs.exagon_working.infra_lib.pubsub;

/**
 * Enumerates the priority levels for messaging channels.
 *
 */
public enum MessagingChannelPriority {
    /**
     * Indicates that a channel should have a higher priority when consuming.
     */
    HIGH,
    /**
     * Indicates that a channel should have a lower priority when consuming.
     */
    LOW
}
