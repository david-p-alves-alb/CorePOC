package com.alticelabs.core.C00;

import com.alticelabs.core.repo_persistence.TransactionLogAdapter;
import com.alticelabs.core.repo_pubsub.PubSubFactoryAdapter;
import com.alticelabs.persistenceprovider.api.DatasourceFactory;
import com.alticelabs.persistenceprovider.api.TransactionLog;
import com.alticelabs.pubsub.api.PubSubFactory;
import com.alticelabs.redis.api.KeyValueFactory;
import com.alticelabs.repository.api.RepositoryFactory;

public class CoreMain {
    public static void main(String[] args) {

        // PubSub
        PubSubFactory.getINSTANCE().start();
        PubSubFactoryAdapter pubSubAdapter = new PubSubFactoryAdapter();

        //Persistence
        DatasourceFactory.getInstance().start();
        // Persistence tem de já ter iniciado para poder obter o transaction log
        TransactionLog transactionLog = new TransactionLog();
        TransactionLogAdapter transactionLogAdapter = new TransactionLogAdapter(transactionLog);

        //Redis
        KeyValueFactory.getINSTANCE().start();

        //Repository
        RepositoryFactory.getINSTANCE().setPubSubFactory(pubSubAdapter);
        RepositoryFactory.getINSTANCE().setTransactionLog(transactionLogAdapter);
        RepositoryFactory.getINSTANCE().start();

    }
}
