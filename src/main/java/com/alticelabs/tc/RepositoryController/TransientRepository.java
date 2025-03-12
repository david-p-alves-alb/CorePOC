package com.alticelabs.tc.RepositoryController;

import com.alticelabs.redis.api.KeyValueFactory;
import com.alticelabs.repository.api.RepositoryFactory;
import com.alticelabs.repositoryAPI.ITransientRepository;
import com.alticelabs.redis.api.KeyValueStore;

import java.util.List;
import java.util.Optional;

public class TransientRepository<T> implements ITransientRepository<T> {
    private final com.alticelabs.repository.api.TransientRepository<T> repository;

    public TransientRepository(Class<T> entityClass) {
        // TEM DE SER O TC A SABER AS COLLECTIONS DOS DATASOURCES
        KeyValueStore redisKeyValueStore = KeyValueFactory.getINSTANCE().getKeyValueStore("classCache");
        this.repository = RepositoryFactory.getINSTANCE().getTransientRepository(
                new MemSharedDatasourceAdapter(redisKeyValueStore));
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
        return repository.getAllByIds(ids);
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
