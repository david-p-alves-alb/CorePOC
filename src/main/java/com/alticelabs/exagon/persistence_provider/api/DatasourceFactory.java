package com.alticelabs.exagon.persistence_provider.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Fábrica para criação de instâncias de {@link Datasource}.
 * Esta classe implementa o padrão Singleton para garantir uma única instância global e fornece métodos para obter datasources.
 *
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public class DatasourceFactory {

    private static final DatasourceFactory datasourceFactory = new DatasourceFactory();
    private final Map<String,Datasource> createdDatasources;

    private DatasourceFactory() {
        this.createdDatasources = new HashMap<>();
    }

    /**
     * Obtém a instância única de DatasourceFactory.
     *
     * @return a instância singleton de DatasourceFactory
     */
    public static DatasourceFactory getInstance() {
        return datasourceFactory;
    }

    /**
     * Cria e retorna uma nova instância de {@link Datasource} com base no nome da coleção especificada.
     *
     * @param collectionName o nome da coleção para a qual a fonte de dados será criada
     * @return uma nova instância de {@link Datasource}
     */
    public Datasource getDatasource(String collectionName) {
        Datasource datasource = new Datasource(collectionName);
        createdDatasources.put(collectionName, datasource);
        return datasource;
    }

    public void start() {}
}
