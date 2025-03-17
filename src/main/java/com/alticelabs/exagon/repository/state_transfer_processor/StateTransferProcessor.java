package com.alticelabs.exagon.repository.state_transfer_processor;

import com.alticelabs.exagon.repository.api.interfaces.MemSharedDatasource;
import com.alticelabs.exagon.repository.api.interfaces.PersistenceDatasource;
import com.alticelabs.exagon.repository.api.interfaces.SubscriptionHandler;
import org.bson.Document;

import java.util.Map;

public class StateTransferProcessor implements SubscriptionHandler {
    private final PersistenceDatasource eventDatasource;
    private final MemSharedDatasource cacheDatasource;

    public StateTransferProcessor(PersistenceDatasource eventDatasource, MemSharedDatasource cacheDatasource) {
        this.eventDatasource = eventDatasource;
        this.cacheDatasource = cacheDatasource;
    }

    @Override
    public void execute(String key, Map<String, String> headers, String payload) {
        // Recebe o documento através do payload e adiciona na coleção de eventos
        eventDatasource.add(Document.parse(payload));

        //Invalida a cache
    }
}
