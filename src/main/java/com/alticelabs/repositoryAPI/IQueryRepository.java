package com.alticelabs.repositoryAPI;

import java.util.List;
import java.util.Optional;

/**
 * Esta interface define o comportamento esperado de um repositório Query.
 * Esta interface suporta operações de consulta de entidades {@link Entity}.
 */
public interface IQueryRepository<T extends Entity> {
    /**
     * Obtém a entidade.
     *
     * @param id    id da entidade
     * @return      a entitade caso exista, senão vazio
     */
    Optional<? extends T> getByID(String id);

    /**
     * Itera pelos ids das entidades e obtém as entidades.
     *
     * @param ids   lista de ids das entidades
     * @return      a lista das entidades encontradas. Se nenhum for encontrada, vazio.
     */
    Optional<List<? extends T>> getAllById(List<String> ids);

    /**
     * Obtém uma lista de entidades com base num filtro.
     *
     * @param filter o filtro a ser executado
     * @return um {@link Optional} contendo a lista de entidades, se encontradas, ou vazio caso contrário
     */
    Optional<List<? extends T>> getByQuery(IQuery filter);

    /**
     * Obtém uma lista de entidades com base num filtro, transformando numa classe específica.
     *
     * @param filter o filtro a ser executado
     * @param toClass classe a ser retornada
     * @return um {@link Optional} contendo a lista de entidades, se encontradas, ou vazio caso contrário
     */
    <O extends T> Optional<List<O>> getByQuery(IQuery filter, Class<O> toClass);

    /**
     * Conta o número de entidades que correspondem a um filtro.
     *
     * @param filter o filtro a ser executada
     * @return o número de entidades correspondentes
     */
    long count(IQuery filter);

    /**
     * Conta o número de entidades que correspondem a um filtro e são de uma respetiva classe.
     *
     * @param filter o filtro a ser executada
     * @param toClass a classe das entidades a filtrar
     * @return o número de entidades correspondentes
     */
    <O extends T> long count(IQuery filter, Class<O> toClass);
}
