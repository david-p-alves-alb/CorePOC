package com.alticelabs.tc.R01Controller;

import com.alticelabs.repo_external_api.Entity;
import com.alticelabs.repo_external_api.ITransientRepository;
import com.alticelabs.core.R04Redis.CoreMemSharedAdapter;
import com.alticelabs.redis.Redis01.KeyValueStore;
import com.alticelabs.repository.R01.TransientRepository;

import java.util.List;
import java.util.Optional;

public class TCTransientRepository<T extends Entity> implements ITransientRepository<T> {
    private final TransientRepository<T> repository;

    public TCTransientRepository(Class<T> entityClass) {
        // TEM DE SER O TC A SABER AS COLLECTIONS DOS DATASOURCES
        KeyValueStore redisKeyValueStore = new KeyValueStore();
        this.repository = new TransientRepository<>(
                new CoreMemSharedAdapter(redisKeyValueStore));
    }

    @Override
    public T save(String id, T entity) {
        return repository.save(id,entity);
    }

    @Override
    public T save(String id, T entity, Long ttl) {
        return repository.save(id,entity,ttl);
    }

    @Override
    public Optional<T> getByID(String id) {
        return repository.getByID(id);
    }

    @Override
    public List<T> getAllByIds(List<String> ids) {
        return (List<T>) repository.getAllByIds(ids);
    }

    @Override
    public List<T> getAll() {
        return repository.getAll();
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Boolean exists(String id) {
        return repository.exists(id);
    }
}
