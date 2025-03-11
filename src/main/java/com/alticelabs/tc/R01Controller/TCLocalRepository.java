package com.alticelabs.tc.R01Controller;

import com.alticelabs.repo_external_api.Entity;
import com.alticelabs.repo_external_api.EntityEvent;
import com.alticelabs.repo_external_api.ILocalRepository;
import com.alticelabs.persistenceprovider.PP01.Datasource;
import com.alticelabs.persistenceprovider.PP01.DatasourceFactory;
import com.alticelabs.repository.R01.LocalRepository;

import java.util.List;
import java.util.Optional;

public class TCLocalRepository<T extends Entity,S extends EntityEvent> implements ILocalRepository<T,S> {
    private final LocalRepository<T,S> repository;

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
        return repository.getById(sagaID,id);
    }

    @Override
    public List<T> getAllByID(List<String> ids) {
        // OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        return repository.getByIdList(sagaID, ids);
    }

    @Override
    public Optional<T> getByIDLatest(String id) {
        // OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        return repository.getByIdLatest(sagaID,id);
    }

    @Override
    public String create(T entity) {
        // OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        return repository.create(sagaID,entity);
    }

    @Override
    public void save(S event) {
        // OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        repository.save(sagaID,event);
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
