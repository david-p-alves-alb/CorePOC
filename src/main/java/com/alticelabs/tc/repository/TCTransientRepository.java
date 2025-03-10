package com.alticelabs.tc.repository;

import com.alticelabs.api.ExagonEntity;
import com.alticelabs.api.ExagonEntityEvent;
import com.alticelabs.api.ITransientRepository;
import com.alticelabs.core.R04Redis.CoreMemSharedAdapter;
import com.alticelabs.persistenceprovider.PP01.Datasource;
import com.alticelabs.persistenceprovider.PP01.DatasourceFactory;
import com.alticelabs.redis.Redis01.KeyValueStore;
import com.alticelabs.repository.R01.ReadOnlyRepository;
import com.alticelabs.repository.R01.TransientRepository;
import org.bson.conversions.Bson;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TCTransientRepository<T extends ExagonEntity> implements ITransientRepository<T> {
    private final TransientRepository<TCEntityAdapter<? extends T>> repository;

    public TCTransientRepository(Class<T> entityClass) {
        // TEM DE SER O TC A SABER AS COLLECTIONS DOS DATASOURCES
        KeyValueStore redisKeyValueStore = new KeyValueStore();
        this.repository = new TransientRepository<>(
                new CoreMemSharedAdapter(redisKeyValueStore));
    }

    @Override
    public T save(String id, T entity) {
        return repository.save(id,new TCEntityAdapter<>(entity)).getEntity();
    }

    @Override
    public T save(String id, T entity, Long ttl) {
        return repository.save(id,new TCEntityAdapter<>(entity),ttl).getEntity();
    }

    @Override
    public Optional<T> getByID(String id) {
        return repository.getByID(id).map(TCEntityAdapter::getEntity);
    }

    @Override
    public List<T> getAllByIds(List<String> ids) {
        return (List<T>) repository.getAllByIds(ids).stream().map(TCEntityAdapter::getEntity).toList();
    }

    @Override
    public List<T> getAll() {
        return (List<T>) repository.getAll().stream().map(TCEntityAdapter::getEntity).toList();
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
