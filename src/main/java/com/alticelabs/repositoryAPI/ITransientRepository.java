package com.alticelabs.repositoryAPI;

import java.util.List;
import java.util.Optional;

/**
 * Esta interface define o comportamento esperado de um repositório Transient,
 * onde as entidades são guardadas em memória partilhada e podem ter um TTL.
 * Esta interface suporta operações como criação, atualização, consulta e remoção de entidades.
 */
public interface ITransientRepository<T> {
    /**
     * Guarda uma entidade associada a um identificador.
     *
     * @param id o identificador da entidade
     * @param entity a entidade a ser guardada
     */
    T save(String id, T entity);

    /**
     * Guarda uma entidade associada a um identificador com um TTL.
     *
     * @param id o identificador da entidade
     * @param entity a entidade a ser salva
     * @param ttl tempo de expiração da entidade
     */
    T save(String id, T entity, Long ttl);

    /**
     * Obtém uma entidade pelo seu identificador.
     *
     * @param id o identificador da entidade
     * @return um {@link Optional} contendo a entidade, se encontrada, ou vazio caso contrário
     */
    Optional<T> getByID(String id);

    /**
     * Obtém todas as entidades associadas a uma lista de identificadores.
     *
     * @param ids a coleção de identificadores das entidades
     * @return um {@link List} contendo as entidades encontradas
     */
    List<T> getAllByIds(List<String> ids);

    /**
     * Obtém todas as entidades armazenadas.
     *
     * @return um {@link List} contendo todas as entidades
     */
    List<T> getAll();

    /**
     * Remove uma entidade com base no seu identificador.
     *
     * @param id o identificador da entidade a ser removida
     */
    void delete(String id);

    /**
     * Remove todas as entidades do repositório.
     */
    void deleteAll();

    /**
     * Verifica se uma entidade existe no repositório com base no seu identificador.
     *
     * @param id o identificador da entidade
     * @return {@code true} se a entidade existe, {@code false} caso contrário
     */
    Boolean exists(String id);
}
