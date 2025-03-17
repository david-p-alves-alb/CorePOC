package com.alticelabs.exagon.repository.api.interfaces;

public interface PersistenceDatasourceFactory {
    PersistenceDatasource getDatasource(String datasourceName);
}
