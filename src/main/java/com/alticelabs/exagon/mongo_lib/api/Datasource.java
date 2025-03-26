package com.alticelabs.exagon.mongo_lib.api;

import com.alticelabs.exagon.infra_lib.persistence.IExagonDatasource;
import com.alticelabs.exagon.api.repository.filters.IExagonQuery;
import com.alticelabs.exagon.infra_lib.persistence.PersistenceException;

import java.util.List;
import java.util.Optional;

/**
 * Represents a datasource for document manipulation.
 * This class provides methods to add, retrieve, update, and remove documents from a named datasource.
 *
 * @param <T> the type of document managed by this datasource
 */

public class Datasource<T> implements IExagonDatasource<T> {

    /** The name of the datasource. */
    private final String name;

    /** The type of model managed by the datasource. */
    private final Class<T> modelType;

    /**
     * Constructs a new datasource with the specified name.
     * This constructor is only used by the PersistenceManager.
     *
     * @param name the name of the datasource
     * @param modelType the class type of the document model managed by this datasource
     */
    protected Datasource(String name, Class<T> modelType) {
        this.name = name;
        this.modelType = modelType;
    }

    @Override
    public T add(T document) throws PersistenceException {
        return null;
    }

    @Override
    public Optional<T> find(IExagonQuery filter) throws PersistenceException {
        return Optional.empty();
    }

    @Override
    public List<T> findAll(IExagonQuery filter) throws PersistenceException {
        return List.of();
    }

    @Override
    public Optional<T> update(String id, T document) throws PersistenceException {
        return Optional.empty();
    }

    @Override
    public boolean delete(IExagonQuery filter) throws PersistenceException {
        return false;
    }
}
