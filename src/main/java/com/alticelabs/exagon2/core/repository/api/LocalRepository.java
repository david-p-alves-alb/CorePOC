package com.alticelabs.exagon.repository.api;

import com.alticelabs.exagon.repository.api.interfaces.MemSharedDatasource;
import com.alticelabs.exagon.repository.api.interfaces.PersistenceDatasource;
import com.alticelabs.exagon.api.repository.model.Entity;
import com.alticelabs.exagon.api.repository.model.EntityEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Representa um repositório local para gerenciamento de entidades e eventos.
 * Esta classe suporta operações como criação, salvamento, consulta e remoção de entidades.
 *
 * @param <T> o tipo da entidade, que deve estender {@link Entity}
 * @param <S> o tipo do evento, que deve estender {@link EntityEvent}
 */
public class LocalRepository<T extends Entity, S extends EntityEvent> {

    private final PersistenceDatasource entityDatasource;
    private final PersistenceDatasource eventDatasource;
    private final MemSharedDatasource cacheDatasource;

    /**
     * Constrói um novo repositório local com os Datasources especificados.
     *
     * @param entityDatasource datasource para entidades
     * @param eventDatasource datasource para eventos
     */
    protected LocalRepository(PersistenceDatasource entityDatasource, PersistenceDatasource eventDatasource, MemSharedDatasource cacheDatasource) {
        this.entityDatasource = entityDatasource;
        this.eventDatasource = eventDatasource;
        this.cacheDatasource = cacheDatasource;
    }

    protected void start() {

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
     * Salva um evento associado a uma entidade que aconteceu durante uma saga no repositório.
     *
     * @param sagaID o identificador da saga à qual o evento pertence
     * @param event o evento a ser salvo
     */
    public void save(String sagaID, S event) {}

    /**
     * Obtém uma entidade pelo seu identificador dentro de uma saga.
     *
     * @param sagaID o identificador da saga à qual a entidade pertence
     * @param id o identificador da entidade
     * @return um {@link Optional} contendo a entidade, se encontrada, ou vazio caso contrário
     */
    public Optional<T> getById(String sagaID, String id) {
        return Optional.empty();
    }

    /**
     * Obtém a versão mais recente (ignorando isolamento) de uma entidade pelo seu identificador dentro de uma saga.
     *
     * @param id o identificador da entidade
     * @return um {@link Optional} contendo a entidade mais recente, se encontrada, ou vazio caso contrário
     */
    public Optional<T> getByIdLatest(String id) {
        return Optional.empty();
    }

    /**
     * Obtém uma lista de entidades pelos seus identificadores dentro de uma saga.
     *
     * @param sagaID o identificador da saga à qual as entidades pertencem
     * @param ids a lista de identificadores das entidades
     * @return uma lista contendo as entidades encontradas
     */
    public List<T> getByIdList(String sagaID, List<String> ids) {
        return new LinkedList<>();
    }

    /**
     * Remove uma entidade do repositório com base em seu identificador.
     *
     * @param sagaID o identificador da saga à qual a entidade pertence
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
