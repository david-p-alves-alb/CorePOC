package com.alticelabs.repository.R01;

import com.alticelabs.repository.im_agent.IMAgent;

import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia os repositórios e as operações relacionadas com sagas, utilizando um agente de gerenciamento de sagas.
 * Esta classe implementa o padrão Singleton para garantir uma única instância global.
 *
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public class Repositories {

    private static final Repositories repositories = new Repositories();

    private final List<LocalRepository<?,?>> localRepositories = new ArrayList<>();
    private final List<QueryRepository<?>> queryRepositories = new ArrayList<>();
    private final List<ReadOnlyRepository<?>> readOnlyRepositories = new ArrayList<>();
    private final List<ReadWriteRepository<?,?>> readWriteRepositories = new ArrayList<>();
    private final List<TransientRepository<?>> transientRepositories = new ArrayList<>();

    /**
     * Construtor privado para evitar instanciação direta, conforme o padrão Singleton.
     */
    private Repositories() {}

    /**
     * Obtém a instância única de Repositories.
     *
     * @return a instância singleton de Repositories
     */
    public static Repositories getInstance() {
        return repositories;
    }

    public List<TransientRepository<?>> getTransientRepositories() {
        return transientRepositories;
    }

    public List<ReadWriteRepository<?, ?>> getReadWriteRepositories() {
        return readWriteRepositories;
    }

    public List<ReadOnlyRepository<?>> getReadOnlyRepositories() {
        return readOnlyRepositories;
    }

    public List<QueryRepository<?>> getQueryRepositories() {
        return queryRepositories;
    }

    public List<LocalRepository<?, ?>> getLocalRepositories() {
        return localRepositories;
    }

    /**
     * Inicia uma saga com o identificador especificado.
     *
     * @param sagaId o identificador da saga a ser iniciada
     */
    public void sagaStart(String sagaId) {
        IMAgent.getINSTANCE().sagaStart(sagaId);
    }

    /**
     * Para uma saga com o identificador especificado.
     *
     * @param sagaId o identificador da saga a ser parada
     */
    public void sagaStop(String sagaId) {
        IMAgent.getINSTANCE().sagaStop(sagaId);
    }

    /**
     * Realiza o rollback de uma saga com o identificador especificado.
     *
     * @param sagaId o identificador da saga a ser revertida
     */
    public void sagaRollback(String sagaId) {
        IMAgent.getINSTANCE().sagaRollback(sagaId);
    }

    /**
     * Inicia os repositórios e seus componentes associados.
     */
    public void start() {
        //Start em todos os repositórios
    }

    public void addLocalRepository(LocalRepository<?,?> localRepository) {
        localRepositories.add(localRepository);
    }

    public void addReadOnlyRepository(ReadOnlyRepository<?> readOnlyRepository) {
        readOnlyRepositories.add(readOnlyRepository);
    }

    public void addReadWriteRepository(ReadWriteRepository<?,?> readWriteRepository) {
        readWriteRepositories.add(readWriteRepository);
    }

    public void addQueryRepository(QueryRepository<?> queryRepository) {
        queryRepositories.add(queryRepository);
    }

    public void addTransientRepository(TransientRepository<?> transientRepository) {
        transientRepositories.add(transientRepository);
    }

}
