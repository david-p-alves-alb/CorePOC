package com.alticelabs.core.C00;

import com.alticelabs.core.R03PP01.CoreDatasourceAdapter;
import com.alticelabs.core.R03PP01.CoreTransactionLogAdapter;
import com.alticelabs.core.R02PS01.CorePubSubAdapter;
import com.alticelabs.core.R04Redis.CoreMemSharedAdapter;
import com.alticelabs.persistenceprovider.PP01.Datasource;
import com.alticelabs.persistenceprovider.PP01.DatasourceFactory;
import com.alticelabs.persistenceprovider.PP01.TransactionLog;
import com.alticelabs.pubsub.PS01.PubSubManager;
import com.alticelabs.redis.Redis01.KeyValueStore;
import com.alticelabs.repository.R00.RepositoryManager;
import com.alticelabs.repository.R01.*;
import org.bson.conversions.Bson;

public class CoreMain {
    public static void main(String[] args) {
        // INSTANCIAÇÃO DE REPOS
        DatasourceFactory datasourceFactory = DatasourceFactory.getInstance();
        Datasource readOnlySnapshotDatasource = datasourceFactory.getDatasource("readOnlySnapshots");
        Datasource readOnlyEventDatasource = datasourceFactory.getDatasource("readOnlyEvents");

        ReadOnlyRepository<Bson,Bson> readOnlyRepository = new ReadOnlyRepository<>(
                new CoreDatasourceAdapter(readOnlySnapshotDatasource),
                new CoreDatasourceAdapter(readOnlyEventDatasource));

        Datasource readWriteSnapshotDatasource = datasourceFactory.getDatasource("readWriteSnapshots");
        Datasource readWriteEventDatasource = datasourceFactory.getDatasource("readWriteEvents");

        ReadWriteRepository<Bson,Bson> readWriteRepository = new ReadWriteRepository<>(
                new CoreDatasourceAdapter(readWriteSnapshotDatasource),
                new CoreDatasourceAdapter(readWriteEventDatasource));

        Datasource localSnapshotDatasource = datasourceFactory.getDatasource("localSnapshots");
        Datasource localEventDatasource = datasourceFactory.getDatasource("localEvents");

        LocalRepository<Bson,Bson> localRepository = new LocalRepository<>(
                new CoreDatasourceAdapter(localSnapshotDatasource),
                new CoreDatasourceAdapter(localEventDatasource));

        Datasource queryEntityDatasource = datasourceFactory.getDatasource("queryEntity");
        Datasource querySnapshotDatasource = datasourceFactory.getDatasource("querySnapshots");
        Datasource queryEventDatasource = datasourceFactory.getDatasource("queryEvents");

        QueryRepository<Bson,Bson> queryRepository = new QueryRepository<>(
                new CoreDatasourceAdapter(queryEntityDatasource),
                new CoreDatasourceAdapter(querySnapshotDatasource),
                new CoreDatasourceAdapter(queryEventDatasource));


        KeyValueStore redisKeyValueStore = new KeyValueStore();
        TransientRepository<Bson,Bson> transientRepository = new TransientRepository<>(
                new CoreMemSharedAdapter(redisKeyValueStore));

        // CDC
        TransactionLog transactionLog = new TransactionLog();
        CoreTransactionLogAdapter coreTransactionLogAdapter = new CoreTransactionLogAdapter(transactionLog);

        // PubSub
        PubSubManager pubSubManager = new PubSubManager();
        CorePubSubAdapter corePubSubAdapter = new CorePubSubAdapter(pubSubManager);


        RepositoryManager.getInstance().setRepoTransactionLog(coreTransactionLogAdapter);
        RepositoryManager.getInstance().setRepoPubSub(corePubSubAdapter);
        RepositoryManager.getInstance().start();
    }
}
