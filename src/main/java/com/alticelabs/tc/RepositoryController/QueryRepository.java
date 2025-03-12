package com.alticelabs.tc.RepositoryController;

import com.alticelabs.repository.api.RepositoryFactory;
import com.alticelabs.repositoryAPI.Entity;
import com.alticelabs.repositoryAPI.IQuery;
import com.alticelabs.repositoryAPI.IQueryRepository;
import com.alticelabs.persistenceprovider.api.Datasource;
import com.alticelabs.persistenceprovider.api.DatasourceFactory;

import java.util.List;
import java.util.Optional;

public class QueryRepository<T extends Entity> implements IQueryRepository<T> {
    private final com.alticelabs.repository.api.QueryRepository<T> repository;

    public QueryRepository(Class<T> entityClass) {
        // TEM DE SER O TC A SABER AS COLLECTIONS DOS DATASOURCES
        DatasourceFactory datasourceFactory = DatasourceFactory.getInstance();
        Datasource queryEntityDatasource = datasourceFactory.getDatasource("queryEntity");
        Datasource querySnapshotDatasource = datasourceFactory.getDatasource("querySnapshots");
        Datasource queryEventDatasource = datasourceFactory.getDatasource("queryEvents");

        this.repository = RepositoryFactory.getINSTANCE().getQueryRepository(
                new PersistenceDatasourceAdapter(queryEntityDatasource),
                new PersistenceDatasourceAdapter(querySnapshotDatasource),
                new PersistenceDatasourceAdapter(queryEventDatasource));
    }

    @Override
    public Optional<? extends T> getByID(String id) {
        return repository.getByID(id);
    }

    @Override
    public Optional<List<? extends T>> getAllById(List<String> ids) {
        return repository.getAllById(ids);
    }

    @Override
    public Optional<List<? extends T>> getByQuery(IQuery filter) {
        return repository.getByQuery(filter);
    }

    // VER SE ESTE MÉTODO FAZ SENTIDO E COMO RESOLVER O PROBLEMA DO ADAPTADOR
    @Override
    public <O extends T> Optional<List<O>> getByQuery(IQuery filter, Class<O> toClass) {
        return repository.getByQuery(filter,toClass);
    }

    @Override
    public long count(IQuery filter) {
        return repository.count(filter);
    }

    @Override
    public <O extends T> long count(IQuery filter, Class<O> toClass) {
        return repository.count(filter);
    }
}
