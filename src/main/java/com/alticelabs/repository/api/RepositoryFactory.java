package com.alticelabs.repository.api;

import com.alticelabs.repository.cdc.CDCHandler;
import com.alticelabs.repository.im_agent.IMAgent;
import com.alticelabs.repository.rollback.RollbackHandler;
import com.alticelabs.repositoryAPI.Entity;
import com.alticelabs.repositoryAPI.EntityEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia os repositórios e as operações relacionadas com sagas, utilizando um agente de gerenciamento de sagas.
 * Esta classe implementa o padrão Singleton para garantir uma única instância global.
 */
public class RepositoryFactory {
    private static final RepositoryFactory INSTANCE = new RepositoryFactory();

    private PubSubFactory pubSubFactory;
    private TransactionLog transactionLog;

    private final List<LocalRepository<?,?>> localRepositories = new ArrayList<>();
    private final List<QueryRepository<?>> queryRepositories = new ArrayList<>();
    private final List<ReadOnlyRepository<?>> readOnlyRepositories = new ArrayList<>();
    private final List<ReadWriteRepository<?,?>> readWriteRepositories = new ArrayList<>();
    private final List<TransientRepository<?>> transientRepositories = new ArrayList<>();

    private IMAgent imAgent;
    private RollbackHandler rollbackHandler;
    private CDCHandler cdcHandler;

    private RepositoryFactory() {

    }

    public static RepositoryFactory getINSTANCE() {
        return INSTANCE;
    }

    public void setPubSubFactory(PubSubFactory pubSubFactory) {
        this.pubSubFactory = pubSubFactory;
    }

    public void setTransactionLog(TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    public <T extends Entity,S extends EntityEvent> LocalRepository<T,S> getLocalRepository(PersistenceDatasource entityDatasource, PersistenceDatasource eventDatasource, MemSharedDatasource cache) {
        LocalRepository<T,S> localRepository = new LocalRepository<>(entityDatasource, eventDatasource, cache);
        localRepositories.add(localRepository);
        return localRepository;
    }

    public <T extends Entity> ReadOnlyRepository<T> getReadOnlyRepository(PersistenceDatasource entityDatasource,PersistenceDatasource eventDatasource,MemSharedDatasource cache) {
        ReadOnlyRepository<T> readOnlyRepository = new ReadOnlyRepository<>(entityDatasource, eventDatasource, cache);
        readOnlyRepositories.add(readOnlyRepository);
        return readOnlyRepository;
    }

    public <T extends Entity,S extends EntityEvent> ReadWriteRepository<T,S> getReadWriteRepository(PersistenceDatasource entityDatasource,PersistenceDatasource eventDatasource,MemSharedDatasource cache) {
        ReadWriteRepository<T,S> readWriteRepository = new ReadWriteRepository<>(entityDatasource, eventDatasource, cache);
        readWriteRepositories.add(readWriteRepository);
        return readWriteRepository;
    }

    public <T extends Entity> QueryRepository<T> getQueryRepository(PersistenceDatasource entityDatasource,PersistenceDatasource snapshotDatasource,PersistenceDatasource eventDatasource) {
        QueryRepository<T> queryRepository = new QueryRepository<>(entityDatasource, snapshotDatasource, eventDatasource);
        queryRepositories.add(queryRepository);
        return queryRepository;
    }

    public <T> TransientRepository<T> getTransientRepository(MemSharedDatasource memSharedDatasource) {
        TransientRepository<T> transientRepository = new TransientRepository<>(memSharedDatasource);
        transientRepositories.add(transientRepository);
        return transientRepository;
    }


    /**
     * Inicia uma saga com o identificador especificado.
     *
     * @param sagaId o identificador da saga a ser iniciada
     */
    public void sagaStart(String sagaId) {
        imAgent.sagaStart(sagaId);
    }

    /**
     * Para uma saga com o identificador especificado.
     *
     * @param sagaId o identificador da saga a ser parada
     */
    public void sagaStop(String sagaId) {
        imAgent.sagaStop(sagaId);
    }

    /**
     * Realiza o rollback de uma saga com o identificador especificado.
     *
     * @param sagaId o identificador da saga a ser revertida
     */
    public void sagaRollback(String sagaId) {
        imAgent.sagaRollback(sagaId);
    }

    /**
     * Realiza o rollback de uma saga com o identificador especificado.
     *
     * @param sagaId o identificador da saga a ser revertida
     */
    public void rollback(String sagaId) {
        // Rollback nos repos
    }

    public void start() {
        this.imAgent = new IMAgent(pubSubFactory);
        this.rollbackHandler = new RollbackHandler(pubSubFactory,this);
        this.cdcHandler = new CDCHandler(pubSubFactory,transactionLog);

        // Start IM Agent
        imAgent.start();

        // Start Rollback
        rollbackHandler.start();
    }

    /**
     * Inicia a tarefa de captura de dados de mudança (CDC) em repositórios.
     * Esta tarefa deve ser executada por um único processo.
     */
    public void cdcEnable() {
        cdcHandler.start();
    }

    /**
     * Encerra a tarefa de captura de dados de mudança (CDC) em repositórios.
     */
    public void cdcDisable() {
        cdcHandler.stop();
    }
}
