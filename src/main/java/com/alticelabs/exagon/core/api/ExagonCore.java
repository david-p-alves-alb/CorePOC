package com.alticelabs.exagon.core.api;

import com.alticelabs.exagon.core.repo_persistence.PersistenceDatasourceFactoryAdapter;
import com.alticelabs.exagon.core.repo_persistence.TransactionLogAdapter;
import com.alticelabs.exagon.core.repo_pubsub.PubSubFactoryAdapter;
import com.alticelabs.exagon.core.repo_redis.MemSharedDatasourceFactoryAdapter;
import com.alticelabs.exagon.persistence_provider.api.DatasourceFactory;
import com.alticelabs.exagon.persistence_provider.api.TransactionLog;
import com.alticelabs.exagon.pubsub.api.PubSubFactory;
import com.alticelabs.exagon.memshared.api.MemSharedFactory;
import com.alticelabs.exagon.repository.api.RepositoryFactory;

import java.lang.reflect.Method;

public class ExagonCore {
    public static void start() {

        // PubSub
        PubSubFactory.getINSTANCE().start();
        PubSubFactoryAdapter pubSubAdapter = new PubSubFactoryAdapter();

        //Persistence
        DatasourceFactory.getInstance().start();
        PersistenceDatasourceFactoryAdapter persistenceDatasourceFactoryAdapter = new PersistenceDatasourceFactoryAdapter(DatasourceFactory.getInstance());

        TransactionLog transactionLog = new TransactionLog();
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
