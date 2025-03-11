package com.alticelabs.repo_external_api;

import java.util.List;
import java.util.Optional;

public interface ITransientRepository<T extends Entity> {
    T save(String id, T entity);

    T save(String id, T entity, Long ttl);

    Optional<T> getByID(String id);

    List<T> getAllByIds(List<String> ids);

    List<T> getAll();

    void delete(String id);

    void deleteAll();

    Boolean exists(String id);
}
