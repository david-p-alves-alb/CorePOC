package com.alticelabs.exagon_working.infra_lib.pubsub;

/**
 * Interface representing a handler of in-memory messages received through {@link IExagonInMemoryChannel}.
 *
 */
public interface IExagonInMemoryHandler {

    /**
     * Executes the processing of a received message.
     *
     * @param message the content of the message
     */
    void execute(String message);
}
