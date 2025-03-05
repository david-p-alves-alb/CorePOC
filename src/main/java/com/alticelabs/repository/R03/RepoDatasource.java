package com.alticelabs.repository.R03;

import org.bson.conversions.Bson;

import java.util.List;

/**
 * Define uma interface para datasource de repositório que manipula documentos do tipo {@link Bson}.
 * Esta interface fornece métodos para adicionar, consultar, atualizar e remover documentos em um repositório.
 *
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public interface RepoDatasource {

    /**
     * Adiciona um documento ao repositório.
     *
     * @param document o documento a ser adicionado
     * @return o documento adicionado
     */
    Bson add(Bson document);

    /**
     * Obtém um documento do repositório com base em um filtro.
     *
     * @param filter o filtro usado para localizar o documento
     * @return o documento encontrado
     */
    Bson get(Bson filter);

    /**
     * Atualiza um documento no repositório com base em seu identificador.
     *
     * @param id o identificador do documento a ser atualizado
     * @param document o documento com as novas informações
     * @return o documento atualizado
     */
    Bson update(String id, Bson document);

    /**
     * Atualiza um documento no repositório com base em um filtro.
     *
     * @param filter o filtro usado para localizar o documento
     * @param document o documento com as novas informações
     * @return o documento atualizado
     */
    Bson update(Bson filter, Bson document);

    /**
     * Remove um documento do repositório com base em seu identificador.
     *
     * @param id o identificador do documento a ser removido
     * @return {@code true} se o documento foi removido com sucesso, {@code false} caso contrário
     */
    boolean remove(String id);

    /**
     * Remove um documento do repositório com base em um filtro.
     *
     * @param filter o filtro usado para localizar o documento
     * @return {@code true} se o documento foi removido com sucesso, {@code false} caso contrário
     */
    boolean remove(Bson filter);

    /**
     * Obtém uma lista de documentos do repositório com base em um filtro.
     *
     * @param filter o filtro usado para localizar os documentos
     * @return uma lista de documentos que correspondem ao filtro
     */
    List<Bson> getList(Bson filter);
}
