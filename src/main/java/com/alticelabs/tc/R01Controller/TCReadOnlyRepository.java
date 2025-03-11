package com.alticelabs.tc.R01Controller;

import com.alticelabs.repo_external_api.Entity;
import com.alticelabs.repo_external_api.IReadOnlyRepository;
import com.alticelabs.persistenceprovider.PP01.Datasource;
import com.alticelabs.persistenceprovider.PP01.DatasourceFactory;
import com.alticelabs.repository.R01.ReadOnlyRepository;

import java.util.List;
import java.util.Optional;

public class TCReadOnlyRepository<T extends Entity> implements IReadOnlyRepository<T> {
    private final ReadOnlyRepository<T> repository;

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
