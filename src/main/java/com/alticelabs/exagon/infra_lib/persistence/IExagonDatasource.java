package com.alticelabs.exagon.infra_lib.persistence;

import com.alticelabs.exagon.api.repository.filters.IExagonQuery;

import java.util.List;
import java.util.Optional;

/**
 * Represents a datasource for managing documents.
 * This interface defines methods to add, retrieve, update, and remove documents in a persistence system.
 * It is the primary abstraction for interacting with any form of storage system (e.g., database, file storage).
 *
 * @param <T> the type of document managed by the datasource
 */
public interface IExagonDatasource<T> {

    /**
     * Adds a document to the datasource.
     * @param document the document to be added
     * @return a copy of the added document
     * @throws PersistenceException if an error occurs while adding the document
     */
    T add(T document) throws PersistenceException;

    /**
     * Retrieves a document from the datasource based on a filter.
     * If the filter query gets more than one object, it will return the first one
     *
     * @param filter the filter used to locate the document
     * @return an {@code Optional} containing the retrieved document if found, or an empty {@code Optional} if no document matches the filter
     * @throws PersistenceException if an error occurs while retrieving the document
     */
    Optional<T> find(IExagonQuery filter) throws PersistenceException;

    /**
     * Retrieves a list of documents from the datasource based on a filter.
     *
     * @param filter the filter used to locate the documents
     * @return a list of documents that match the filter. If no documents are found, it returns an empty List.
     * @throws PersistenceException if an error occurs while retrieving the documents
     */
    List<T> findAll(IExagonQuery filter) throws PersistenceException;

    /**
     * Updates a document in the datasource based on its unique identifier.
     * @param id the unique identifier of the document to be updated
     * @param document the document with updated information
     * @return an {@code Optional} containing the updated document if successful, or an empty {@code Optional} if the document was not found
     * @throws PersistenceException if an error occurs while updating the document
     */
    Optional<T> update(String id, T document) throws PersistenceException;

    /**
     * Deletes documents from the datasource based on a filter.
     *
     * @param filter the filter used to locate the document(s)
     * @return {@code true} if any document was successfully removed, {@code false} otherwise
     * @throws PersistenceException if an error occurs while deleting the document(s)
     */
    boolean delete(IExagonQuery filter) throws PersistenceException;


}
