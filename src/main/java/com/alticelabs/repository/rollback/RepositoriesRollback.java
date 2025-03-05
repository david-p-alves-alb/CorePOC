package com.alticelabs.repository.rollback;

import com.alticelabs.repository.R02.RepoPubSub;

/**
 * Gerencia operações de rollback em repositórios, utilizando um sistema de publicação e assinatura (Pub/Sub).
 * Esta classe subscreve um manipulador de rollback a um destino específico para processar mensagens de reversão.
 *
 * @author [Teu Nome]
 * @version 1.0
 * @since 2025-03-05
 */
public class RepositoriesRollback {

    private static final RepositoriesRollback instance = new RepositoriesRollback();
    private RepoPubSub repoPubSub;

    private RepositoriesRollback() {
    }

    public static RepositoriesRollback getINSTANCE() {
        return instance;
    }

    /**
     * Inicia o processo de rollback, subscrevendo um manipulador ao destino "rollback".
     */
    public void start() {
        RollbackHandler rollbackHandler = new RollbackHandler();
        this.repoPubSub.subscribe("rollback", rollbackHandler);
    }

    public void setRepoPubSub(RepoPubSub repoPubSub) {
        this.repoPubSub = repoPubSub;
    }
}