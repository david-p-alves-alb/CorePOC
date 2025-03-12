package com.alticelabs.repository.api;

import com.alticelabs.repositoryAPI.Entity;
import com.alticelabs.repositoryAPI.EntityEvent;
import org.bson.conversions.Bson;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Representa um repositório de leitura e escrita que opera em cima de uma arquitetura de Event Sourcing.
 * Este repositório suporta operações de criação, salvamento, consulta, remoção e reversão de entidades dentro de uma
 * transação (Saga).
 * Também replica as alterações efetuadas para outros repositórios
 * {@link com.alticelabs.repository.api.ReadOnlyRepository} da mesma entidade.
 *
 * @param <T> o tipo da entidade, que deve estender {@link Bson}
 * @param <S> o tipo do evento, que deve estender {@link Bson}
 */
public class ReadWriteRepository<T extends Entity, S extends EntityEvent> {

    private final PersistenceDatasource entityDatasource;
    private final PersistenceDatasource eventDatasource;
    private final MemSharedDatasource cacheDatasource;

    /**
     * Constrói um novo repositório de leitura e escrita com os datasources especificados.
     *
     * @param entityDatasource datasources para entidades
     * @param eventDatasource datasources para eventos
     */
    protected ReadWriteRepository(PersistenceDatasource entityDatasource, PersistenceDatasource eventDatasource, MemSharedDatasource cacheDatasource) {
        this.entityDatasource = entityDatasource;
        this.eventDatasource = eventDatasource;
        this.cacheDatasource = cacheDatasource;
    }

    /**
     * Cria uma nova entidade associada a uma saga e retorna seu identificador.
     *
     * @param sagaID o identificador da saga à qual a entidade pertence
     * @param entity a entidade a ser criada
     * @return o identificador da entidade criada
     */
    public String create(String sagaID, T entity) {
        return "";
    }

    /**
     * Salva um evento associado a uma entidade relativo a uma saga no repositório.
     *
     * @param sagaID o identificador da saga à qual o evento pertence
     * @param event o evento a ser salvo
     */
    public void save(String sagaID, S event) {}

    /**
     * Obtém uma entidade pelo seu identificador dentro de uma saga.
     *
     * @param sagaID o identificador da saga
     * @param id o identificador da entidade
     * @return um {@link Optional} contendo a entidade, se encontrada, ou vazio caso contrário
     */
    public Optional<T> getById(String sagaID, String id) {
        return Optional.empty();
    }

    /**
     * Obtém a versão mais recente de uma entidade pelo seu identificador dentro de uma saga.
     *
     * @param sagaID o identificador da saga
     * @param id o identificador da entidade
     * @return um {@link Optional} contendo a entidade mais recente, se encontrada, ou vazio caso contrário
     */
    public Optional<T> getByIdLatest(String sagaID, String id) {
        return Optional.empty();
    }

    /**
     * Obtém uma lista de entidades pelos seus identificadores dentro de uma saga.
     *
     * @param sagaID o identificador da saga
     * @param ids a lista de identificadores das entidades
     * @return uma lista contendo as entidades encontradas
     */
    public List<T> getByIdList(String sagaID, List<String> ids) {
        return new LinkedList<>();
    }

    /**
     * Remove uma entidade do repositório com base em seu identificador.
     *
     * @param sagaID o identificador da saga
     * @param id o identificador da entidade a ser removida
     */
    public void remove(String sagaID, String id) {}

    /**
     * Reverte todas as alterações associadas a uma saga no repositório.
     *
     * @param sagaID o identificador da saga cujas alterações devem ser revertidas
     */
    public void revert(String sagaID) {}
}