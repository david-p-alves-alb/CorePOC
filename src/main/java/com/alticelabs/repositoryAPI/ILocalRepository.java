package com.alticelabs.repositoryAPI;


import java.util.List;
import java.util.Optional;

public interface ILocalRepository<T extends Entity,S extends EntityEvent> {

    /**
     * Obtém uma entidade reconstruída com restrições de isolamento.
     *
     * @param id    ID para pesquisa
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

    /**
     * Cria uma entidade com restrições de isolamento se a entidade não existir.
     *
     * @return  o ID da entidade criada se a entidade não existir, nulo caso contrário
     */
    String create(T entity);

    /**
     * Guarda um evento associado a uma entidade.
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
