package com.alticelabs.exagon2.core.api;

import com.alticelabs.exagon2.core.memshared.MemSharedFactory;
import com.alticelabs.exagon2.core.repo_persistence.PersistenceDatasourceFactoryAdapter;
import com.alticelabs.exagon2.core.repo_persistence.TransactionLogAdapter;
import com.alticelabs.exagon2.core.repo_pubsub.PubSubFactoryAdapter;
import com.alticelabs.exagon2.core.repo_redis.MemSharedDatasourceFactoryAdapter;
import com.alticelabs.exagon.mongo_lib.api.PersistenceManager;
import com.alticelabs.exagon2.core.repository.api.RepositoryFactory;

public class ExagonCore {
    public static void start() {

        // PubSub
        PubSubFactory.getINSTANCE().start();
        PubSubFactoryAdapter pubSubAdapter = new PubSubFactoryAdapter();

        //Persistence
        PersistenceManager.getInstance().start();
        PersistenceDatasourceFactoryAdapter persistenceDatasourceFactoryAdapter = new PersistenceDatasourceFactoryAdapter(PersistenceManager.getInstance());

        TransactionLog2112 transactionLog = new TransactionLog123();
        TransactionLogAdapter transactionLogAdapter = new TransactionLogAdapter(transactionLog);

        //Redis
        MemSharedFactory.getINSTANCE().start();
        MemSharedDatasourceFactoryAdapter memSharedDatasourceFactoryAdapter = new MemSharedDatasourceFactoryAdapter(MemSharedFactory.getINSTANCE());

        //Repository
        RepositoryFactory.getINSTANCE().setPubSubFactory(pubSubAdapter);
        RepositoryFactory.getINSTANCE().setTransactionLog(transactionLogAdapter);
        RepositoryFactory.getINSTANCE().setPersistenceDatasourceFactory(persistenceDatasourceFactoryAdapter);
        RepositoryFactory.getINSTANCE().setMemSharedDatasourceFactory(memSharedDatasourceFactoryAdapter);
        RepositoryFactory.getINSTANCE().start();

    }
}
