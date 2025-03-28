package com.alticelabs.exagon_working.infra_lib.pubsub;

/**
 * Interface for managing instances of {@link IExagonMessagingChannel} and {@link IExagonInMemoryChannel}.
 * Provides methods to create and retrieve messaging and inmemory pub-sub instances based on a specified channel name.
 */
public interface IExagonPubSubManager {

    /**
     * Creates and returns a new instance of {@link IExagonMessagingChannel} based on the specified channel name.
     * If a messaging channel for the given name already exists, the same instance is returned.
     * TODO: VER COMO SERÁ A SERIALIZAÇÃO E DESERIALIZAÇÃO? SERÁ PRECISO PASSAR O MODEL TYPE
     * @param name the name of the channel
     * @param priority defines the priority of the channel
     * @return an instance of {@link IExagonMessagingChannel} associated with the given channel name
     */
    IExagonMessagingChannel getMessagingChannel(String name,MessagingChannelPriority priority);

    /**
     * Creates and returns a new instance of {@link IExagonInMemoryChannel} based on the specified channel name.
     * If a inMemory channel for the given name already exists, the same instance is returned.
     * TODO: VER COMO SERÁ A SERIALIZAÇÃO E DESERIALIZAÇÃO? SERÁ PRECISO PASSAR O MODEL TYPE
     * @param name the name of the channel
     * @return an instance of {@link IExagonInMemoryChannel} associated with the given channel name
     */
    IExagonInMemoryChannel getInMemoryChannel(String name);

}
