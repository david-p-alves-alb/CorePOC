package com.alticelabs.api;

import org.bson.conversions.Bson;

import java.util.List;
import java.util.Optional;

public interface IQueryRepository<T extends ExagonEntity> {
    Optional<? extends T> getByID(String id);

    Optional<List<? extends T>> getAllById(List<String> id);

    Optional<List<? extends T>> getByQuery(IQuery filter);

    <O extends T> Optional<List<O>> getByQuery(IQuery filter, Class<O> toClass);

    long count(IQuery filter);

    <O extends T> long count(IQuery filter, Class<O> toClass);
}
