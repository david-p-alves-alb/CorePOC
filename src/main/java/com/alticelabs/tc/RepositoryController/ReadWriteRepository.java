package com.alticelabs.tc.RepositoryController;

import com.alticelabs.redis.api.KeyValueFactory;
import com.alticelabs.redis.api.KeyValueStore;
import com.alticelabs.repository.api.RepositoryFactory;
import com.alticelabs.repositoryAPI.Entity;
import com.alticelabs.repositoryAPI.EntityEvent;
import com.alticelabs.repositoryAPI.IReadWriteRepository;
import com.alticelabs.persistenceprovider.api.Datasource;
import com.alticelabs.persistenceprovider.api.DatasourceFactory;

import java.util.List;
import java.util.Optional;

public class ReadWriteRepository<T extends Entity,S extends EntityEvent> implements IReadWriteRepository<T,S> {
    private final com.alticelabs.repository.api.ReadWriteRepository<T,S> repository;

    public ReadWriteRepository(Class<T> entityClass, Class<S> eventClass) {
        // TEM DE SER O TC A SABER AS COLLECTIONS DOS DATASOURCES
        DatasourceFactory datasourceFactory = DatasourceFactory.getInstance();
        Datasource readWriteSnapshotDatasource = datasourceFactory.getDatasource("readWriteSnapshots");
        Datasource readWriteEventDatasource = datasourceFactory.getDatasource("readWriteEvents");
        KeyValueStore cache = KeyValueFactory.getINSTANCE().getKeyValueStore("classCache");
        this.repository = RepositoryFactory.getINSTANCE().getReadWriteRepository(new PersistenceDatasourceAdapter(readWriteSnapshotDatasource),
                new PersistenceDatasourceAdapter(readWriteEventDatasource),new MemSharedDatasourceAdapter(cache));
    }

    @Override
    public Optional<T> getByID(String id) {
        // OBTER A PARTIR DO CONTEXTO
        String sagaID = "SAGAID";
        return repository.getById(sagaID, id);
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
