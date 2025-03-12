package com.alticelabs.repositoryAPI;


import java.util.List;
import java.util.Optional;

/**
 * Esta interface define o comportamento esperado de um repositório local, onde não existe propagação de informação.
 * Esta interface suporta operações como criação, atualização, consulta e remoção de entidades {@link Entity}
 * com base em eventos {@link EntityEvent}.
 */
public interface ILocalRepository<T extends Entity,S extends EntityEvent> {

    /**
     * Obtém a entidade reconstruída com restrições de isolamento.
     *
     * @param id    id da entidade
     * @return      a entitade caso exista, senão vazio
     */
    Optional<T> getByID(String id);

    /**
     * Itera pelos ids das entidades e obtém as entidades reconstruídas com restrições de isolamento.
     *
     * @param ids   lista de ids das entidades
     * @return      a lista das entidades encontradas. Se nenhum for encontrada, lista vazia.
     */
    List<T> getAllByID(List<String> ids);

    /**
     * Obtém a entidade reconstruída sem restrições de isolamento.
     *
     * @param id    id da entidade
     * @return      a entidade caso exista, senão vazio
     */
    Optional<T> getByIDLatest(String id);

    /**
     * Cria uma entidade com restrições de isolamento se a entidade não existir.
     * @param entity a entidade a ser criada
     * @return o identificador da entidade caso seja criada, null caso contrário
     */
    String create(T entity);

    /**
     * Guarda um evento
     *
     * @param event     o evento a guardar.
     */
    void save(S event);

    /**
     * Remove uma entidade com base no seu identificador.
     *
     * @param id o identificador da entidade a ser removida
     */
    void remove(String id);

    /**
     * Reverte todas as alterações associadas à transação atual.
     *
     */
    void revert();
}
