package com.alticelabs.repositoryAPI;

import java.util.List;
import java.util.Optional;

public interface IReadWriteRepository<T extends Entity,S extends EntityEvent> {
    Optional<T> getByID(String id);

    List<T> getAllByID(List<String> ids);

    Optional<T> getByIDLatest(String id);

    /**
     * Cria uma entidade com restrições de isolamento se a entidade não existir.
     *
     * @return  o ID da entidade criada se a entidade não existir, nulo caso contrário
     */
    String create(T entity);

    /**
     * Guarda um evento
     *
     * @param event     o evento a guardar.
     */
    void save(S event);

    /**
     * Remove uma entidade a partir do seu ID.
     */
    void remove(String id);

    void revert();
}
