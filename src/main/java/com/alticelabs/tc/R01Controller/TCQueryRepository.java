package com.alticelabs.tc.R01Controller;

import com.alticelabs.repo_external_api.Entity;
import com.alticelabs.repo_external_api.IQuery;
import com.alticelabs.repo_external_api.IQueryRepository;
import com.alticelabs.persistenceprovider.PP01.Datasource;
import com.alticelabs.persistenceprovider.PP01.DatasourceFactory;
import com.alticelabs.repository.R01.QueryRepository;

import java.util.List;
import java.util.Optional;

public class TCQueryRepository<T extends Entity> implements IQueryRepository<T> {
    private final QueryRepository<T> repository;

    public TCQueryRepository(Class<T> entityClass) {
        // TEM DE SER O TC A SABER AS COLLECTIONS DOS DATASOURCES
        DatasourceFactory datasourceFactory = DatasourceFactory.getInstance();
        Datasource queryEntityDatasource = datasourceFactory.getDatasource("queryEntity");
        Datasource querySnapshotDatasource = datasourceFactory.getDatasource("querySnapshots");
        Datasource queryEventDatasource = datasourceFactory.getDatasource("queryEvents");

        this.repository = new QueryRepository<>(
                new TCDatasourceAdapter(queryEntityDatasource),
                new TCDatasourceAdapter(querySnapshotDatasource),
                new TCDatasourceAdapter(queryEventDatasource));
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
