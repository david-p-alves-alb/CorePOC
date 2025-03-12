package com.alticelabs.tc.RepositoryController;

import com.alticelabs.redis.api.KeyValueFactory;
import com.alticelabs.redis.api.KeyValueStore;
import com.alticelabs.repository.api.RepositoryFactory;
import com.alticelabs.repositoryAPI.Entity;
import com.alticelabs.repositoryAPI.IReadOnlyRepository;
import com.alticelabs.persistenceprovider.api.Datasource;
import com.alticelabs.persistenceprovider.api.DatasourceFactory;

import java.util.List;
import java.util.Optional;

/**
 * Representa um repositório somente de leitura que opera em cima de uma arquitetura de Event Sourcing.
 * Este repositório fornece métodos para consultar entidades por identificadores, sem permitir modificações, e com
 * isolamento intrínseco.
 * Também recebe as alterações efetuadas no repositório
 * {@link com.alticelabs.repository.api.ReadWriteRepository} da mesma entidade.
 */
public class ReadOnlyRepository<T extends Entity> implements IReadOnlyRepository<T> {
    private final com.alticelabs.repository.api.ReadOnlyRepository<T> repository;

    public ReadOnlyRepository(Class<T> entityClass) {
        // TEM DE SER O TC A SABER AS COLLECTIONS DOS DATASOURCES
        DatasourceFactory datasourceFactory = DatasourceFactory.getInstance();
        Datasource readOnlySnapshotDatasource = datasourceFactory.getDatasource("readOnlySnapshots");
        Datasource readOnlyEventDatasource = datasourceFactory.getDatasource("readOnlyEvents");
        KeyValueStore cache = KeyValueFactory.getINSTANCE().getKeyValueStore("classCache");
        this.repository = RepositoryFactory.getINSTANCE().getReadOnlyRepository(new PersistenceDatasourceAdapter(readOnlySnapshotDatasource),
                new PersistenceDatasourceAdapter(readOnlyEventDatasource),new MemSharedDatasourceAdapter(cache));
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
}
