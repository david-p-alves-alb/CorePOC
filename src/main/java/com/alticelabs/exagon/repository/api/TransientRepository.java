package com.alticelabs.exagon.repository.api;

import com.alticelabs.exagon.repository.api.interfaces.MemSharedDatasource;

import java.util.List;
import java.util.Optional;

/**
 * Representa um repositório transitório para gerenciamento de entidades em memória compartilhada.
 * Esta classe suporta operações de salvamento, consulta, remoção e verificação de existência de entidades.
 *
 * @param <T> o tipo da entidade
 */
public class TransientRepository<T> {

    private final MemSharedDatasource memSharedDatasource;

    /**
     * Constrói um novo repositório transitório com o datasource em memória compartilhada especificado.
     *
     * @param memSharedDatasource datasource em memória compartilhada para entidades
     */
    protected TransientRepository(MemSharedDatasource memSharedDatasource) {
        this.memSharedDatasource = memSharedDatasource;
    }

    /**
     * Salva uma entidade associada a um identificador no repositório.
     *
     * @param id o identificador da entidade
     * @param entity a entidade a ser salva
     */
    public T save(String id, T entity) {
        return entity;
    }

    /**
     * Salva uma entidade associada a um identificador no repositório.
     *
     * @param id o identificador da entidade
     * @param entity a entidade a ser salva
     */
    public T save(String id, T entity,long ttl) {
        return entity;
    }

    /**
     * Obtém uma entidade pelo seu identificador.
     *
     * @param id o identificador da entidade
     * @return um {@link Optional} contendo a entidade, se encontrada, ou vazio caso contrário
     */
    public Optional<T> getByID(String id) {
        return Optional.empty();
    }

    /**
     * Obtém todas as entidades associadas a uma coleção de identificadores.
     *
     * @param ids a coleção de identificadores das entidades
     * @return um {@link List} contendo as entidades encontradas
     */
    public List<T> getAllByIds(Iterable<String> ids) {
        return null;
    }

    /**
     * Obtém todas as entidades armazenadas no repositório.
     *
     * @return um {@link List} contendo todas as entidades
     */
    public List<T> getAll() {
        return null;
    }

    /**
     * Remove uma entidade do repositório com base em seu identificador.
     *
     * @param id o identificador da entidade a ser removida
     */
    public void delete(String id) {}

    /**
     * Remove todas as entidades do repositório.
     */
    public void deleteAll() {}

    /**
     * Verifica se uma entidade existe no repositório com base em seu identificador.
     *
     * @param id o identificador da entidade
     * @return {@code true} se a entidade existe, {@code false} caso contrário
     */
    public Boolean exists(String id) {
        return false;
    }
}
