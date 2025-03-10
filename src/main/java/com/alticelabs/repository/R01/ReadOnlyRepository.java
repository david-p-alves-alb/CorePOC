package com.alticelabs.repository.R01;

import com.alticelabs.api.ExagonEntity;
import com.alticelabs.api.ExagonEntityEvent;
import com.alticelabs.repository.R03.RepoDatasource;
import org.bson.conversions.Bson;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Representa um repositório somente de leitura para acesso a entidades e eventos.
 * Esta classe fornece métodos para consultar entidades por identificadores, sem permitir modificações.
 *
 * @param <T> o tipo da entidade, que deve estender {@link Bson}
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public class ReadOnlyRepository<T extends RepoEntity> {

    private final RepoDatasource entityDatasource;
    private final RepoDatasource eventDatasource;

    /**
     * Constrói um novo repositório somente de leitura com os datasources especificados.
     *
     * @param entityDatasource datasource para entidades
     * @param eventDatasource datasource para eventos
     */
    public ReadOnlyRepository(RepoDatasource entityDatasource, RepoDatasource eventDatasource) {
        this.entityDatasource = entityDatasource;
        this.eventDatasource = eventDatasource;
    }

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
     * Obtém a versão mais recente de uma entidade pelo seu identificador dentro de uma saga.
     *
     * @param sagaID o identificador da saga à qual a entidade pertence
     * @param id o identificador da entidade
     * @return um {@link Optional} contendo a entidade mais recente, se encontrada, ou vazio caso contrário
     */
    public Optional<T> getByIdLatest(String sagaID, String id) {
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
}
