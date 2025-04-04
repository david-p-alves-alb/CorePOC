package com.alticelabs.exagon.repository.api;

import com.alticelabs.exagon.repository.api.interfaces.MemSharedDatasource;
import com.alticelabs.exagon.repository.api.interfaces.PersistenceDatasource;
import com.alticelabs.exagon.repository.api.interfaces.PubSubChannel;
import com.alticelabs.exagon.repository.state_transfer_processor.StateTransferProcessor;
import com.alticelabs.exagon.api.repository.model.Entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Representa um repositório somente de leitura que opera em cima de uma arquitetura de Event Sourcing.
 * Este repositório fornece métodos para consultar entidades dentro de uma transação (Saga) por identificadores, sem
 * permitir modificações.
 * Também recebe as alterações efetuadas no repositório
 * {@link ReadWriteRepository} da mesma entidade.
 *
 * @param <T> o tipo da entidade, que deve estender {@link Entity}
 */
public class ReadOnlyRepository<T extends Entity> {

    private final PersistenceDatasource entityDatasource;
    private final PersistenceDatasource eventDatasource;
    private final MemSharedDatasource cacheDatasource;
    private final PubSubChannel stateTransferChannel;

    /**
     * Constrói um novo repositório somente de leitura com os datasources especificados.
     *
     * @param entityDatasource datasource para entidades
     * @param eventDatasource datasource para eventos
     */
    protected ReadOnlyRepository(PersistenceDatasource entityDatasource, PersistenceDatasource eventDatasource,
                                 MemSharedDatasource cacheDatasource, PubSubChannel stateTransferChannel) {
        this.entityDatasource = entityDatasource;
        this.eventDatasource = eventDatasource;
        this.cacheDatasource = cacheDatasource;
        this.stateTransferChannel = stateTransferChannel;
    }

    protected void start() {
        StateTransferProcessor stateTransferProcessor = new StateTransferProcessor(eventDatasource,cacheDatasource);
        stateTransferChannel.subscribe(stateTransferProcessor,true);
    }

    /**
     * Obtém uma entidade pelo seu identificador dentro de uma saga.
     *
     * @param sagaID o identificador da saga à qual a entidade pertence
     * @param id o identificador da entidade
     * @return um {@link Optional} contendo a entidade, se encontrada, ou vazio caso contrário
     */
    public Optional<T> getById(String sagaID, String id) {
        return Optional.empty();
    }

    /**
     * Obtém a versão mais recente de uma entidade pelo seu identificador dentro de uma saga.
     *
     * @param sagaID o identificador da saga à qual a entidade pertence
     * @param id o identificador da entidade
     * @return um {@link Optional} contendo a entidade mais recente, se encontrada, ou vazio caso contrário
     */
    public Optional<T> getByIdLatest(String sagaID, String id) {
        return Optional.empty();
    }

    /**
     * Obtém uma lista de entidades pelos seus identificadores dentro de uma saga.
     *
     * @param sagaID o identificador da saga à qual as entidades pertencem
     * @param ids a lista de identificadores das entidades
     * @return uma lista contendo as entidades encontradas
     */
    public List<T> getByIdList(String sagaID, List<String> ids) {
        return new LinkedList<>();
    }
}
