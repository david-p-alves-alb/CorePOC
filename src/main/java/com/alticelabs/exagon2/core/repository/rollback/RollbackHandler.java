package com.alticelabs.exagon.repository.rollback;

import com.alticelabs.exagon.repository.api.interfaces.PubSubChannel;
import com.alticelabs.exagon.repository.api.interfaces.PubSubFactory;
import com.alticelabs.exagon.repository.api.interfaces.SubscriptionHandler;
import com.alticelabs.exagon.repository.api.LocalRepository;
import com.alticelabs.exagon.repository.api.ReadWriteRepository;
import com.alticelabs.exagon.repository.api.RepositoryFactory;

import java.util.List;
import java.util.Map;

/**
 * Gerencia operações de rollback em repositórios, utilizando um sistema de publicação e assinatura (Pub/Sub).
 * Esta classe subscreve um manipulador de rollback a um destino específico para processar mensagens de reversão.
 */
public class RollbackHandler implements SubscriptionHandler {

    private PubSubChannel rollbackChannel;

    public RollbackHandler(PubSubFactory pubSubFactory) {
        this.rollbackChannel = pubSubFactory.getChannel("IM_ROLLBACK");
    }

    /**
     * Inicia o processo de rollback, subscrevendo um manipulador ao destino "rollback".
     */
    public void start() {
        this.rollbackChannel.subscribe(this,true);
    }

    @Override
    public void execute(String key, Map<String, String> headers, String message) {
        List<ReadWriteRepository<?, ?>> readWriteRepositories = RepositoryFactory.getINSTANCE().getReadWriteRepositories();
        List<LocalRepository<?, ?>> localRepositories = RepositoryFactory.getINSTANCE().getLocalRepositories();
        readWriteRepositories.forEach(readWriteRepository -> {readWriteRepository.revert(key);});
        localRepositories.forEach(localRepository -> {localRepository.revert(key);});
    }
}