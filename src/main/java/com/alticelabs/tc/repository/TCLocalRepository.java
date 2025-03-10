package com.alticelabs.tc.repository;

import com.alticelabs.api.ExagonEntity;
import com.alticelabs.api.ExagonEntityEvent;
import com.alticelabs.api.ILocalRepository;
import com.alticelabs.persistenceprovider.PP01.Datasource;
import com.alticelabs.persistenceprovider.PP01.DatasourceFactory;
import com.alticelabs.repository.R01.LocalRepository;

import java.util.List;
import java.util.Optional;

public class TCLocalRepository<T extends ExagonEntity,S extends ExagonEntityEvent> implements ILocalRepository<T,S> {
    private final LocalRepository<TCEntityAdapter<? extends T>,TCEntityEventAdapter<? extends S>> repository;

    public TCLocalRepository(Class<T> entityClass, Class<S> eventClass) {
        // TEM DE SER O TC A SABER AS COLLECTIONS DOS DATASOURCES
        DatasourceFactory datasourceFactory = DatasourceFactory.getInstance();
        Datasource localSnapshotDatasource = datasourceFactory.getDatasource("localSnapshots");
        Datasource localEventDatasource = datasourceFactory.getDatasource("localEvents");
        this.repository = new LocalRepository<>(new TCDatasourceAdapter(localSnapshotDatasource),
                new TCDatasourceAdapter(localEventDatasource));
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

    @Override
    public String create(T entity) {
        // OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        return repository.create(sagaID,new TCEntityAdapter<>(entity));
    }

    @Override
    public void save(S event) {
// OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        repository.save(sagaID,new TCEntityEventAdapter<>(event));
    }

    @Override
    public void remove(String id) {
// OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        repository.remove(sagaID,id);
    }

    @Override
    public void revert() {
// OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        repository.revert(sagaID);
    }
}
