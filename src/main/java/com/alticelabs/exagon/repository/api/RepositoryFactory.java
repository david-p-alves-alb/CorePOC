package com.alticelabs.exagon.repository.api;

import com.alticelabs.exagon.repository.api.interfaces.*;
import com.alticelabs.exagon.repository.cdc.CDCHandler;
import com.alticelabs.exagon.repository.im_agent.IMAgent;
import com.alticelabs.exagon.repository.rollback.RollbackHandler;
import com.alticelabs.exagon.repository_models.model.Entity;
import com.alticelabs.exagon.repository_models.model.EntityEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia os repositórios e as operações relacionadas com sagas, utilizando um agente de gerenciamento de sagas.
 * Esta classe implementa o padrão Singleton para garantir uma única instância global.
 */
public class RepositoryFactory {
    private static final RepositoryFactory INSTANCE = new RepositoryFactory();

    public List<LocalRepository<?, ?>> getLocalRepositories() {
        return localRepositories;
    }

    public List<ReadWriteRepository<?, ?>> getReadWriteRepositories() {
        return readWriteRepositories;
    }

    private final List<LocalRepository<?,?>> localRepositories = new ArrayList<>();
    private final List<QueryRepository<?>> queryRepositories = new ArrayList<>();
    private final List<ReadOnlyRepository<?>> readOnlyRepositories = new ArrayList<>();
    private final List<ReadWriteRepository<?,?>> readWriteRepositories = new ArrayList<>();
    private final List<TransientRepository<?>> transientRepositories = new ArrayList<>();

    private IMAgent imAgent;
    private RollbackHandler rollbackHandler;
    private CDCHandler cdcHandler;
    private PubSubFactory pubSubFactory;
    private TransactionLog transactionLog;
    private PersistenceDatasourceFactory persistenceDatasourceFactory;
    private MemSharedDatasourceFactory memSharedDatasourceFactory;

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

    public void setPersistenceDatasourceFactory(PersistenceDatasourceFactory persistenceDatasourceFactory) {
        this.persistenceDatasourceFactory = persistenceDatasourceFactory;
    }

    public void setMemSharedDatasourceFactory(MemSharedDatasourceFactory memSharedDatasourceFactory) {
        this.memSharedDatasourceFactory = memSharedDatasourceFactory;
    }

    public void start() {
        this.imAgent = new IMAgent(pubSubFactory);
        this.rollbackHandler = new RollbackHandler(pubSubFactory);
        this.cdcHandler = new CDCHandler(pubSubFactory,transactionLog);

        // Start IM Agent
        imAgent.start();

        // Start Rollback
        rollbackHandler.start();
    }

    public <T extends Entity,S extends EntityEvent> LocalRepository<T,S> getLocalRepository(Class<T> entityClass, Class<S> eventClass) {
        PersistenceDatasource entityDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        PersistenceDatasource eventDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        MemSharedDatasource cacheDatasource = memSharedDatasourceFactory.getKeyValueStore(entityClass.getName());
        LocalRepository<T,S> localRepository = new LocalRepository<>(entityDatasource, eventDatasource, cacheDatasource);
        localRepositories.add(localRepository);
        return localRepository;
    }

    public <T extends Entity> ReadOnlyRepository<T> getReadOnlyRepository(Class<T> entityClass) {
        PersistenceDatasource entityDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        PersistenceDatasource eventDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        MemSharedDatasource cacheDatasource = memSharedDatasourceFactory.getKeyValueStore(entityClass.getName());
        PubSubChannel stateTransferChannel = pubSubFactory.getPriorityChannel(entityClass.getName());
        ReadOnlyRepository<T> readOnlyRepository = new ReadOnlyRepository<>(entityDatasource, eventDatasource, cacheDatasource,stateTransferChannel);
        readOnlyRepositories.add(readOnlyRepository);
        return readOnlyRepository;
    }

    public <T extends Entity,S extends EntityEvent> ReadWriteRepository<T,S> getReadWriteRepository(Class<T> entityClass, Class<S> eventClass) {
        PersistenceDatasource entityDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        PersistenceDatasource eventDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        MemSharedDatasource cacheDatasource = memSharedDatasourceFactory.getKeyValueStore(entityClass.getName());
        ReadWriteRepository<T,S> readWriteRepository = new ReadWriteRepository<>(entityDatasource, eventDatasource, cacheDatasource);
        readWriteRepositories.add(readWriteRepository);
        return readWriteRepository;
    }

    public <T extends Entity> QueryRepository<T> getQueryRepository(Class<T> entityClass) {
        PersistenceDatasource entityDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        PersistenceDatasource eventDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        PersistenceDatasource snapshotDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        QueryRepository<T> queryRepository = new QueryRepository<>(entityDatasource, snapshotDatasource, eventDatasource);
        queryRepositories.add(queryRepository);
        return queryRepository;
    }

    public <T> TransientRepository<T> getTransientRepository(Class<T> entityClass) {
        MemSharedDatasource memSharedDatasource = memSharedDatasourceFactory.getKeyValueStore(entityClass.getName());
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
     * O TC chama este método num orquestrador para fazer um broadcast de rollback em todos os repositórios
     * Realiza o rollback de uma saga com o identificador especificado.
     *
     * @param sagaId o identificador da saga a ser revertida
     */
    public void sagaRollback(String sagaId) {
        imAgent.sagaRollback(sagaId);
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
