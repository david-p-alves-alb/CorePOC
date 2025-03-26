package com.alticelabs.exagon.repository.api.interfaces;


public interface MemSharedDatasourceFactory {
    MemSharedDatasource getKeyValueStore(String storeName);
}
