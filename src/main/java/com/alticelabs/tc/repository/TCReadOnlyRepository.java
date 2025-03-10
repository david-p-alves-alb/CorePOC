package com.alticelabs.tc.repository;

import com.alticelabs.api.ExagonEntity;
import com.alticelabs.api.ExagonEntityEvent;
import com.alticelabs.api.IReadOnlyRepository;
import com.alticelabs.persistenceprovider.PP01.Datasource;
import com.alticelabs.persistenceprovider.PP01.DatasourceFactory;
import com.alticelabs.repository.R01.ReadOnlyRepository;

import java.util.List;
import java.util.Optional;

public class TCReadOnlyRepository<T extends ExagonEntity> implements IReadOnlyRepository<T> {
    private final ReadOnlyRepository<TCEntityAdapter<? extends T>> repository;

    public TCReadOnlyRepository(Class<T> entityClass) {
        // TEM DE SER O TC A SABER AS COLLECTIONS DOS DATASOURCES
        DatasourceFactory datasourceFactory = DatasourceFactory.getInstance();
        Datasource readOnlySnapshotDatasource = datasourceFactory.getDatasource("readOnlySnapshots");
        Datasource readOnlyEventDatasource = datasourceFactory.getDatasource("readOnlyEvents");
        this.repository = new ReadOnlyRepository<>(new TCDatasourceAdapter(readOnlySnapshotDatasource),
                new TCDatasourceAdapter(readOnlyEventDatasource));
    }

    @Override
    public Optional<T> getByID(String id) {
        // OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        Optional<TCEntityAdapter<? extends T>> adapterOptional = repository.getById(sagaID, id);
        return adapterOptional.map(TCEntityAdapter::getEntity);
    }

    @Override
    public List<T> getAllByID(List<String> ids) {
        // OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        return (List<T>) repository.getByIdList(sagaID, ids).stream().map(TCEntityAdapter::getEntity).toList();
    }

    @Override
    public Optional<T> getByIDLatest(String id) {
        // OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        return repository.getByIdLatest(sagaID,id).map(TCEntityAdapter::getEntity);
    }
}
