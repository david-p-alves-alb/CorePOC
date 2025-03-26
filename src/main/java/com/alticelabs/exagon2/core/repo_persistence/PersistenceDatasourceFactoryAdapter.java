package com.alticelabs.exagon2.core.repo_persistence;

import com.alticelabs.exagon.mongo_lib.api.PersistenceManager;
import com.alticelabs.exagon2.core.repository.api.interfaces.PersistenceDatasource;
import com.alticelabs.exagon2.core.repository.api.interfaces.PersistenceDatasourceFactory;

public class PersistenceDatasourceFactoryAdapter implements PersistenceDatasourceFactory {
    private final PersistenceManager datasourceFactory;

    public PersistenceDatasourceFactoryAdapter(PersistenceManager datasourceFactory) {
        this.datasourceFactory = datasourceFactory;
    }

    @Override
    public PersistenceDatasource getDatasource(String datasourceName) {
        return null;
    }
}
