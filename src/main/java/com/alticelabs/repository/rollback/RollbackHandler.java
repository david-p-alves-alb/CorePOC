package com.alticelabs.repository.rollback;

import com.alticelabs.repository.api.PubSubChannel;
import com.alticelabs.repository.api.PubSubFactory;
import com.alticelabs.repository.api.RepositoryFactory;
import com.alticelabs.repository.api.SubscriptionHandler;

import java.util.Map;

/**
 * Gerencia operações de rollback em repositórios, utilizando um sistema de publicação e assinatura (Pub/Sub).
 * Esta classe subscreve um manipulador de rollback a um destino específico para processar mensagens de reversão.
 */
public class RollbackHandler implements SubscriptionHandler {

    private PubSubChannel rollbackChannel;
    private final RepositoryFactory repositoryFactory;

    public RollbackHandler(PubSubFactory pubSubFactory, RepositoryFactory repositoryFactory) {
        this.rollbackChannel = pubSubFactory.getChannel("IM_ROLLBACK");
        this.repositoryFactory = repositoryFactory;
    }

    /**
     * Inicia o processo de rollback, subscrevendo um manipulador ao destino "rollback".
     */
    public void start() {
        this.rollbackChannel.subscribe(this);
    }

    @Override
    public void execute(String key, Map<String, String> headers, String message) {
        repositoryFactory.rollback(key);
    }
}