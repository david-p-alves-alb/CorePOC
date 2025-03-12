package com.alticelabs.repositoryAPI;

import java.util.List;
import java.util.Optional;


public interface IReadOnlyRepository<T extends Entity> {

    /**
     * Gets a reconstructed entity with isolation constraints.
     *
     * @param id    id for search
     * @return      the entity if it exists, null otherwise
     */
    Optional<T> getByID(String id);

    /**
     * Percorre `ids` para obter entidades reconstruídas com restrições de isolamento.
     *
     * @param ids   lista de ids para pesquisa
     * @return      a lista de entidades se existirem, matriz vazia caso contrário
     */
    List<T> getAllByID(List<String> ids);

    /**
     * Obtém uma entidade reconstruída sem restrições de isolamento.
     *
     * @param id    identificação para pesquisa
     * @return      the entity if it exists, null otherwise
     */
    Optional<T> getByIDLatest(String id);
}
