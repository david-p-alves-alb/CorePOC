package com.alticelabs.exagon_working.pubsub_lib.api;

import com.alticelabs.exagon_working.infra_lib.pubsub.IExagonInMemoryChannel;
import com.alticelabs.exagon_working.infra_lib.pubsub.IExagonInMemoryHandler;

/**
 * Implementation of the {@link IExagonInMemoryChannel} interface.
 */
public class InMemoryChannel implements IExagonInMemoryChannel {

    /** The name of the in-memory channel. */
    private final String name;

    /**
     * Constructs a new in-memory channel with the specified name.
     *
     * @param name the name of the in-memory channel
     */
    protected InMemoryChannel(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void publish(String message) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void subscribe(IExagonInMemoryHandler handler) {}
}