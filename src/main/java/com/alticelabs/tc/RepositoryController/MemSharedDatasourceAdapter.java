package com.alticelabs.tc.RepositoryController;

import com.alticelabs.redis.api.KeyValueStore;
import com.alticelabs.repository.api.MemSharedDatasource;

import java.util.List;

public class MemSharedDatasourceAdapter implements MemSharedDatasource {
    private final KeyValueStore keyValueStore;

    public MemSharedDatasourceAdapter(KeyValueStore keyValueStore) {
        this.keyValueStore = keyValueStore;
    }

    @Override
    public void put(String key, String value) {
        this.keyValueStore.put(key, value);
    }

    @Override
    public String get(String key) {
        return this.keyValueStore.get(key);
    }

    @Override
    public void delete(String key) {
        this.keyValueStore.delete(key);
    }

    @Override
    public Boolean putSet(String key, String field, Object object) {
        return this.keyValueStore.putSet(key, field, object);
    }

    @Override
    public boolean createLock(String lockKey, long ttl) {
        return this.keyValueStore.createLock(lockKey, ttl);
    }

    @Override
    public List<String> getAllKeysFromSet(String key) {
        return this.keyValueStore.getAllKeysFromSet(key);
    }
}
