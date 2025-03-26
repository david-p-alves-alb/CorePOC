package com.alticelabs.exagon.repository.api;

import com.alticelabs.exagon.repository.api.interfaces.*;
import com.alticelabs.exagon.repository.cdc.CDCHandler;
import com.alticelabs.exagon.repository.im_agent.IMAgent;
import com.alticelabs.exagon.repository.rollback.RollbackHandler;
import com.alticelabs.exagon.api.repository.model.Entity;
import com.alticelabs.exagon.api.repository.model.EntityEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma fábrica de repositórios. Esta classe permite criar novos repositórios e chamar operações que são
 * gerais a todos os repositórios (Ex.: Rollback).
 * Esta classe ainda tem a responsabilidade de iniciar o módulo de repositórios.
 */
public class RepositoryFactory {
    private static final RepositoryFactory INSTANCE = new RepositoryFactory();


    /**
     * Local Repositories Instanciados.
     */
    private final List<LocalRepository<?,?>> localRepositories = new ArrayList<>();
    /**
     * Query Repositories Instanciados.
     */
    private final List<QueryRepository<?>> queryRepositories = new ArrayList<>();
    /**
     * ReadOnly Repositories Instanciados.
     */
    private final List<ReadOnlyRepository<?>> readOnlyRepositories = new ArrayList<>();
    /**
     * ReadWrite Repositories Instanciados.
     */
    private final List<ReadWriteRepository<?,?>> readWriteRepositories = new ArrayList<>();
    /**
     * Transient Repositories Instanciados.
     */
    private final List<TransientRepository<?>> transientRepositories = new ArrayList<>();

    /**
     * Obtem os Local Repositories instanciados.
     *
     */
    public List<LocalRepository<?, ?>> getLocalRepositories() {
        return localRepositories;
    }

    /**
     * Obtem os ReadWrite Repositories instanciados.
     *
     */
    public List<ReadWriteRepository<?, ?>> getReadWriteRepositories() {
        return readWriteRepositories;
    }

    private IMAgent imAgent;
    private RollbackHandler rollbackHandler;
    private CDCHandler cdcHandler;
    private PubSubFactory pubSubFactory;
    private TransactionLog transactionLog;
    private PersistenceDatasourceFactory persistenceDatasourceFactory;
    private MemSharedDatasourceFactory memSharedDatasourceFactory;

    private RepositoryFactory() {

    }

    /**
     * Retorna o objeto Singleton de RepositoryFactory.
     *
     */
    public static RepositoryFactory getINSTANCE() {
        return INSTANCE;
    }

    /**
     * Injeta uma fábrica de PubSub.
     *
     */
    public void setPubSubFactory(PubSubFactory pubSubFactory) {
        this.pubSubFactory = pubSubFactory;
    }

    /**
     * Injeta uma instância de Transaction Log.
     *
     */
    public void setTransactionLog(TransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    /**
     * Injeta uma fábrica de PersistenceDatasource.
     *
     */
    public void setPersistenceDatasourceFactory(PersistenceDatasourceFactory persistenceDatasourceFactory) {
        this.persistenceDatasourceFactory = persistenceDatasourceFactory;
    }

    /**
     * Injeta uma fábrica de MemSharedDatasource
     *
     */
    public void setMemSharedDatasourceFactory(MemSharedDatasourceFactory memSharedDatasourceFactory) {
        this.memSharedDatasourceFactory = memSharedDatasourceFactory;
    }

    /**
     * Inicia o módulo de repositórios.
     *
     */
    public void start() {
        this.imAgent = new IMAgent(pubSubFactory);
        this.rollbackHandler = new RollbackHandler(pubSubFactory);
        this.cdcHandler = new CDCHandler(pubSubFactory,transactionLog,persistenceDatasourceFactory.getDatasource("token"));

        // Start IM Agent
        imAgent.start();

        // Start Rollback
        rollbackHandler.start();
    }

    /**
     * Constrói um novo repositório local especifico para as classes fornecidas.
     *
     * @param entityClass classe para entidades
     * @param eventClass classe para eventos
     */
    public <T extends Entity,S extends EntityEvent> LocalRepository<T,S> getLocalRepository(Class<T> entityClass, Class<S> eventClass) {
        PersistenceDatasource entityDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        PersistenceDatasource eventDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        MemSharedDatasource cacheDatasource = memSharedDatasourceFactory.getKeyValueStore(entityClass.getName());
        LocalRepository<T,S> localRepository = new LocalRepository<>(entityDatasource, eventDatasource, cacheDatasource);
        localRepositories.add(localRepository);
        return localRepository;
    }

    /**
     * Constrói um novo repositório readOnly especifico para a classe fornecida.
     *
     * @param entityClass classe para entidades
     */
    public <T extends Entity> ReadOnlyRepository<T> getReadOnlyRepository(Class<T> entityClass) {
        PersistenceDatasource entityDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        PersistenceDatasource eventDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        MemSharedDatasource cacheDatasource = memSharedDatasourceFactory.getKeyValueStore(entityClass.getName());
        PubSubChannel stateTransferChannel = pubSubFactory.getPriorityChannel(entityClass.getName());
        ReadOnlyRepository<T> readOnlyRepository = new ReadOnlyRepository<>(entityDatasource, eventDatasource,
                cacheDatasource,stateTransferChannel);
        readOnlyRepositories.add(readOnlyRepository);
        return readOnlyRepository;
    }

    /**
     * Constrói um novo repositório readWrite especifico para as classes fornecidas.
     *
     * @param entityClass classe para entidades
     * @param eventClass classe para eventos
     */
    public <T extends Entity,S extends EntityEvent> ReadWriteRepository<T,S> getReadWriteRepository(Class<T> entityClass, Class<S> eventClass) {
        PersistenceDatasource entityDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        PersistenceDatasource eventDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        MemSharedDatasource cacheDatasource = memSharedDatasourceFactory.getKeyValueStore(entityClass.getName());
        ReadWriteRepository<T,S> readWriteRepository = new ReadWriteRepository<>(entityDatasource, eventDatasource, cacheDatasource);
        readWriteRepositories.add(readWriteRepository);
        return readWriteRepository;
    }

    /**
     * Constrói um novo repositório Query especifico para a classe fornecida.
     *
     * @param entityClass classe para entidades
     */
    public <T extends Entity> QueryRepository<T> getQueryRepository(Class<T> entityClass) {
        PersistenceDatasource entityDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        PersistenceDatasource eventDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        PersistenceDatasource snapshotDatasource = persistenceDatasourceFactory.getDatasource(entityClass.getName());
        QueryRepository<T> queryRepository = new QueryRepository<>(entityDatasource, snapshotDatasource, eventDatasource);
        queryRepositories.add(queryRepository);
        return queryRepository;
    }

    /**
     * Constrói um novo repositório transiente especifico para a classe fornecida.
     *
     * @param entityClass classe para entidades
     */
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
