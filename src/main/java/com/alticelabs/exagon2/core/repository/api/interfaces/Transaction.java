package com.alticelabs.exagon.repository.api.interfaces;

import org.bson.conversions.Bson;

/**
 * Esta interface define o comportamento esperado de uma mudança capturada pelo CDC (Change Data Capture).
 * Com esta interface é possível obter o token da mudança, a coleção onde esta feita realizada e o documento.
 */
public interface Transaction {

    /**
     * Obtém o token associado à modificação.
     *
     * @return o token da modificação
     */
    String getToken();

    /**
     * Obtém o nome da coleção associada à modificação.
     *
     * @return o nome da coleção
     */
    String getCollection();

    /**
     * Obtém o documento associado à modificação.
     *
     * @return o documento da modificação, representado como {@link Bson}
     */
    Bson getDocument();
}
