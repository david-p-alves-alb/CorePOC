package com.alticelabs.repository.api;

import com.alticelabs.repositoryAPI.Entity;
import com.alticelabs.repositoryAPI.IQuery;
import org.bson.conversions.Bson;

import java.util.List;
import java.util.Optional;

/**
 * Representa um repositório de consultas para acesso a entidades e eventos, utilizando CQRS.
 * Esta classe fornece métodos para consultar entidades por ID, listas de IDs, consultas personalizadas e contagem de resultados.
 *
 * @param <T> o tipo da entidade, que deve estender {@link Entity}
 */
public class QueryRepository<T extends Entity> {

    private final PersistenceDatasource entityDatasource;

    private final PersistenceDatasource snapshotDatasource;

    private final PersistenceDatasource eventDatasource;

    /**
     * Constrói um novo repositório de consultas com os datasources especificados.
     *
     * @param entityDatasource datasource para entidades
     * @param snapshotDatasource datasource para snapshots
     * @param eventDatasource datasource para eventos
     */
    protected QueryRepository(PersistenceDatasource entityDatasource, PersistenceDatasource snapshotDatasource, PersistenceDatasource eventDatasource) {
        this.snapshotDatasource = snapshotDatasource;
        this.entityDatasource = entityDatasource;
        this.eventDatasource = eventDatasource;
    }

    /**
     * Obtém uma entidade pelo seu identificador.
     *
     * @param id o identificador da entidade
     * @return um {@link Optional} contendo a entidade, se encontrada, ou vazio caso contrário
     */
    public Optional<? extends T> getByID(String id) {
        return Optional.empty();
    }

    /**
     * Obtém uma lista de entidades com base em uma lista de identificadores.
     *
     * @param ids a lista de identificadores das entidades
     * @return um {@link Optional} contendo a lista de entidades, se encontradas, ou vazio caso contrário
     */
    public Optional<List<? extends T>> getAllById(List<String> ids) {
        return Optional.empty();
    }

    /**
     * Obtém uma lista de entidades com base em uma consulta personalizada.
     *
     * @param query a consulta a ser executada
     * @return um {@link Optional} contendo a lista de entidades, se encontradas, ou vazio caso contrário
     */
    public Optional<List<? extends T>> getByQuery(IQuery query) {
        return Optional.empty();
    }

    /**
     * Obtém uma lista de entidades de um tipo específico com base em uma consulta personalizada.
     *
     * @param <O> o tipo específico da entidade, que deve estender {@code T}
     * @param query a consulta a ser executada
     * @param oClass a classe do tipo específico da entidade
     * @return um {@link Optional} contendo a lista de entidades do tipo especificado, se encontradas, ou vazio caso contrário
     */
    public <O extends T> Optional<List<O>> getByQuery(IQuery query, Class<O> oClass) {
        return Optional.empty();
    }

    /**
     * Conta o número de entidades que correspondem a uma consulta.
     *
     * @param query a consulta a ser executada
     * @return o número de entidades correspondentes
     */
    public long count(IQuery query) {
        return 0;
    }

    /**
     * Conta o número de entidades de um tipo específico que correspondem a uma consulta.
     *
     * @param <O> o tipo específico da entidade, que deve estender {@code T}
     * @param query a consulta a ser executada
     * @param oClass a classe do tipo específico da entidade
     * @return o número de entidades correspondentes do tipo especificado
     */
    public <O extends T> long count(IQuery query, Class<O> oClass) {
        return 0;
    }
}
