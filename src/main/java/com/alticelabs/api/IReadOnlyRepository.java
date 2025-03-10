package com.alticelabs.api;

import org.bson.conversions.Bson;

import java.util.List;
import java.util.Optional;

public interface IReadOnlyRepository<T extends ExagonEntity> {
    Optional<T> getByID(String id);

    List<T> getAllByID(List<String> ids);

    Optional<T> getByIDLatest(String id);
}
