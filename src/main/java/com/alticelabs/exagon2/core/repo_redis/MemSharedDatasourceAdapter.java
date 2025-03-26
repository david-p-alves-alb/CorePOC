package com.alticelabs.exagon2.core.repo_redis;

import com.alticelabs.exagon_working.redis_lib.api.KeyValueStore;
import com.alticelabs.exagon.repository.api.interfaces.MemSharedDatasource;

import java.util.List;

public class MemSharedDatasourceAdapter implements MemSharedDatasource {
    private final KeyValueStore memSharedStore;

    public MemSharedDatasourceAdapter(KeyValueStore memSharedStore) {
        this.memSharedStore = memSharedStore;
    }

    @Override
    public void put(String key, String value) {

    }

    @Override
    public String get(String key) {
        return "";
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public boolean putSet(String key, String field, String value) {
        return false;
    }

    @Override
    public boolean createLock(String lockKey, long ttl) {
        return false;
    }

    @Override
    public List<String> getAllKeysFromSet(String key) {
        return List.of();
    }
}
