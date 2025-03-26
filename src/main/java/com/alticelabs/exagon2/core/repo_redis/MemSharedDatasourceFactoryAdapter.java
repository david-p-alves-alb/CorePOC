package com.alticelabs.exagon2.core.repo_redis;

import com.alticelabs.exagon2.core.memshared.MemSharedFactory;
import com.alticelabs.exagon.repository.api.interfaces.MemSharedDatasource;
import com.alticelabs.exagon.repository.api.interfaces.MemSharedDatasourceFactory;

public class MemSharedDatasourceFactoryAdapter implements MemSharedDatasourceFactory {
    private final MemSharedFactory keyValueFactory;

    public MemSharedDatasourceFactoryAdapter(MemSharedFactory keyValueFactory) {
        this.keyValueFactory = keyValueFactory;
    }

    @Override
    public MemSharedDatasource getKeyValueStore(String storeName) {
        return new MemSharedDatasourceAdapter(keyValueFactory.getMemSharedStore(storeName));
    }
}
