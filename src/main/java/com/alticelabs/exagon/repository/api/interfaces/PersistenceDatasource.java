package com.alticelabs.exagon.repository.api.interfaces;

import org.bson.conversions.Bson;

import java.util.List;

/**
 * Esta interface define o comportamento esperado do armazenamento persistente de documentos (ex.: Mongo).
 * Esta interface fornece métodos para adicionar, consultar, atualizar e remover documentos.
 * Todos os documentos armazenados terão de respeitar a interface {@link Bson}
 */
public interface PersistenceDatasource {

    /**
     * Adiciona um documento.
     *
     * @param document o documento a ser adicionado
     * @return o documento adicionado
     */
    Bson add(Bson document);

    /**
     * Obtém um documento com base em um filtro.
     *
     * @param filter o filtro usado para localizar o documento
     * @return o documento encontrado
     */
    Bson get(Bson filter);

    /**
     * Atualiza um documento com base no seu identificador.
     *
     * @param id o identificador do documento a ser atualizado
     * @param document o documento com as novas informações
     * @return o documento atualizado
     */
    Bson update(String id, Bson document);

    /**
     * Atualiza um documento com base num filtro.
     *
     * @param filter o filtro usado para localizar o documento
     * @param document o documento com as novas informações
     * @return o documento atualizado
     */
    Bson update(Bson filter, Bson document);

    /**
     * Remove um documento com base no seu identificador.
     *
     * @param id o identificador do documento a ser removido
     * @return {@code true} se o documento foi removido com sucesso, {@code false} caso contrário
     */
    boolean remove(String id);

    /**
     * Remove documentos com base num filtro.
     *
     * @param filter o filtro usado para localizar o documento
     * @return {@code true} se algum documento foi removido com sucesso, {@code false} caso contrário
     */
    boolean remove(Bson filter);

    /**
     * Obtém uma lista de documentos com base em um filtro.
     *
     * @param filter o filtro usado para localizar os documentos
     * @return uma lista de documentos que correspondem ao filtro
     */
    List<Bson> getList(Bson filter);
}
