package com.alticelabs.repositoryAPI;


import java.util.List;
import java.util.Optional;

public interface ILocalRepository<T extends Entity,S extends EntityEvent> {

    /**
     * Gets a reconstructed entity with isolation constraints.
     *
     * @param id    id for search
     * @return      the entity if it exists, null otherwise
     */
    Optional<T> getByID(String id);

    /**
     * Loops through idList to get reconstructed entities with isolation constraints.
     *
     * @param ids   list of ids for search
     * @return      the list of entities if they exist, empty array otherwise
     */
    List<T> getAllByID(List<String> ids);

    /**
     * Gets reconstructed entity without isolation constraints.
     *
     * @param id    id for search
     * @return      the entity if it exists, null otherwise
     */
    Optional<T> getByIDLatest(String id);

    String create(T entity);

    void save(S event);

    void remove(String id);

    void revert();
}
