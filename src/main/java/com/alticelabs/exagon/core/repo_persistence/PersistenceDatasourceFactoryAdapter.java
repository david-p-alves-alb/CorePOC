package com.alticelabs.exagon.core.repo_persistence;

import com.alticelabs.exagon.persistenceprovider.api.DatasourceFactory;
import com.alticelabs.exagon.repository.api.interfaces.PersistenceDatasource;
import com.alticelabs.exagon.repository.api.interfaces.PersistenceDatasourceFactory;

public class PersistenceDatasourceFactoryAdapter implements PersistenceDatasourceFactory {
    private final DatasourceFactory datasourceFactory;

    public PersistenceDatasourceFactoryAdapter(DatasourceFactory datasourceFactory) {
        this.datasourceFactory = datasourceFactory;
    }

    @Override
    public PersistenceDatasource getDatasource(String datasourceName) {
        return new PersistenceDatasourceAdapter(datasourceFactory.getDatasource(datasourceName));
    }
}
