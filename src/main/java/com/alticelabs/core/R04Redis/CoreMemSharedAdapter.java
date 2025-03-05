package com.alticelabs.core.R04Redis;

import com.alticelabs.redis.Redis01.KeyValueStore;
import com.alticelabs.repository.R04.RepoMemShared;

import java.util.List;

public class CoreMemSharedAdapter implements RepoMemShared {
    private final KeyValueStore keyValueStore;

    public CoreMemSharedAdapter(KeyValueStore keyValueStore) {
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
