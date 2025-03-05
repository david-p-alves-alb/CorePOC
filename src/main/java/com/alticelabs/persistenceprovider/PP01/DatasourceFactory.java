package com.alticelabs.persistenceprovider.PP01;

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

    private DatasourceFactory() {}

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
        return new Datasource(collectionName);
    }
}
