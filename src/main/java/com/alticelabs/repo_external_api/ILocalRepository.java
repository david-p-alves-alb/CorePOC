package com.alticelabs.repo_external_api;


import java.util.List;
import java.util.Optional;

public interface ILocalRepository<T extends Entity,S extends EntityEvent> {
    Optional<T> getByID(String id);

    List<T> getAllByID(List<String> ids);

    Optional<T> getByIDLatest(String id);

    String create(T entity);

    void save(S event);

    void remove(String id);

    void revert();
}
