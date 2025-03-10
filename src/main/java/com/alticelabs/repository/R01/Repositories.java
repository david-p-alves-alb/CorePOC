package com.alticelabs.repository.R01;

import com.alticelabs.repository.R02.RepoPubSub;
import com.alticelabs.repository.R03.RepoTransactionLog;
import com.alticelabs.repository.im_agent.IMAgent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

}
