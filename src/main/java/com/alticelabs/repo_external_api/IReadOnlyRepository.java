package com.alticelabs.repo_external_api;

import java.util.List;
import java.util.Optional;

public interface IReadOnlyRepository<T extends Entity> {
    Optional<T> getByID(String id);

    List<T> getAllByID(List<String> ids);

    Optional<T> getByIDLatest(String id);
}
