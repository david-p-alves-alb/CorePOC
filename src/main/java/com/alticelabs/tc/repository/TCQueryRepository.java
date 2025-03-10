package com.alticelabs.tc.repository;

import com.alticelabs.api.ExagonEntity;
import com.alticelabs.api.ExagonEntityEvent;
import com.alticelabs.api.IQuery;
import com.alticelabs.api.IQueryRepository;
import com.alticelabs.persistenceprovider.PP01.Datasource;
import com.alticelabs.persistenceprovider.PP01.DatasourceFactory;
import com.alticelabs.repository.R01.QueryRepository;
import com.alticelabs.repository.R01.ReadOnlyRepository;
import org.bson.conversions.Bson;

import java.util.List;
import java.util.Optional;

public class TCQueryRepository<T extends ExagonEntity> implements IQueryRepository<T> {
    private final QueryRepository<TCEntityAdapter<? extends T>> repository;

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
        return repository.getByID(id).map(TCEntityAdapter::getEntity);
    }

    @Override
    public Optional<List<? extends T>> getAllById(List<String> ids) {
        Optional<List<? extends TCEntityAdapter<? extends T>>> listOptional = repository.getAllById(ids);
        return listOptional.
                map(tcEntityAdapters -> tcEntityAdapters.stream().
                        map(TCEntityAdapter::getEntity).toList());
    }

    @Override
    public Optional<List<? extends T>> getByQuery(IQuery filter) {
        Optional<List<? extends TCEntityAdapter<? extends T>>> listOptional = repository.getByQuery(filter);
        return listOptional.
                map(tcEntityAdapters -> tcEntityAdapters.stream().
                        map(TCEntityAdapter::getEntity).toList());
    }

    // VER SE ESTE MÉTODO FAZ SENTIDO E COMO RESOLVER O PROBLEMA DO ADAPTADOR
    @Override
    public <O extends T> Optional<List<O>> getByQuery(IQuery filter, Class<O> toClass) {
        Optional<List<? extends TCEntityAdapter<? extends T>>> listOptional = repository.getByQuery(filter);
        return listOptional.
                map(tcEntityAdapters -> tcEntityAdapters.stream().
                        map((TCEntityAdapter::getEntity)).map(toClass::cast).toList());
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
