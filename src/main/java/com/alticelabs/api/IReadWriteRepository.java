package com.alticelabs.api;

import org.bson.conversions.Bson;

import java.util.List;
import java.util.Optional;

public interface IReadWriteRepository<T extends ExagonEntity,S extends ExagonEntityEvent> {
    Optional<T> getByID(String id);

    List<T> getAllByID(List<String> ids);

    Optional<T> getByIDLatest(String id);

    String create(T entity);

    void save(S event);

    void remove(String id);

    void revert();
}
