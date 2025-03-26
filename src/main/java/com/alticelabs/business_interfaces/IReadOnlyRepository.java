package com.alticelabs.business_interfaces;

import com.alticelabs.exagon.api.repository.model.Entity;

import java.util.List;
import java.util.Optional;

/**
 * Esta interface define o comportamento esperado de um repositório ReadOnly, onde a informação chega através de State Transfers.
 * Esta interface suporta a consulta de entidades {@link Entity}
 */
public interface IReadOnlyRepository<T extends Entity> {

    /**
     * Obtém a entidade reconstruída com restrições de isolamento.
     *
     * @param id    id da entidade
     * @return      a entitade caso exista, senão vazio
     */
    Optional<T> getByID(String sagaId,String id);

    /**
     * Itera pelos ids das entidades e obtém as entidades reconstruídas com restrições de isolamento.
     *
     * @param ids   lista de ids das entidades
     * @return      a lista das entidades encontradas. Se nenhum for encontrada, lista vazia.
     */
    List<T> getAllByID(String sagaId,List<String> ids);

    /**
     * Obtém a entidade reconstruída sem restrições de isolamento.
     *
     * @param id    id da entidade
     * @return      a entidade caso exista, senão vazio
     */
    Optional<T> getByIDLatest(String id);
}
