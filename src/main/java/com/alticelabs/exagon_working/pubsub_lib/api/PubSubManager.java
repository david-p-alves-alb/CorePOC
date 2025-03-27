package com.alticelabs.exagon_working.pubsub_lib.api;

import com.alticelabs.exagon.infra_lib.IExagonDefaultAPI;
import com.alticelabs.exagon.infra_lib.InfraException;
import com.alticelabs.exagon_working.infra_lib.pubsub.IExagonInMemoryChannel;
import com.alticelabs.exagon_working.infra_lib.pubsub.IExagonMessagingChannel;
import com.alticelabs.exagon_working.infra_lib.pubsub.IExagonPubSubManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the {@link IExagonPubSubManager} and {@link IExagonDefaultAPI} interfaces.
 * Manages {@link IExagonMessagingChannel} and {@link IExagonInMemoryChannel} instances and provides lifecycle management.
 */
public class PubSubManager implements IExagonPubSubManager, IExagonDefaultAPI {

    /** Singleton instance of PubSubManager. */
    private static PubSubManager INSTANCE = new PubSubManager();

    /** Map storing messaging channels by their names. */
    private final Map<String, IExagonMessagingChannel> messagingChannels;

    /** Map storing in-memory channels by their names. */
    private final Map<String, IExagonInMemoryChannel> inMemoryChannels;

    /**
     * Private constructor to enforce the Singleton pattern and initialize channel maps.
     */
    private PubSubManager() {
        this.messagingChannels = new HashMap<>();
        this.inMemoryChannels = new HashMap<>();
    }

    /**
     * Retrieves the singleton instance of PubSubManager.
     *
     * @return the singleton instance of PubSubManager
     */
    public static PubSubManager getINSTANCE() {
        return INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExagonMessagingChannel getMessagingChannel(String name) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IExagonInMemoryChannel getInMemoryChannel(String name) {
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Starts the PubSub manager.
     *
     * @throws InfraException if an infrastructure-related error occurs during startup
     * </p>
     */
    @Override
    public void start() throws InfraException {}

    /**
     * {@inheritDoc}
     * <p>
     * Stops the Pub/Sub manager.
     *
     * @throws InfraException if an infrastructure-related error occurs during shutdown
     * </p>
     */
    @Override
    public void stop() throws InfraException {}
}
