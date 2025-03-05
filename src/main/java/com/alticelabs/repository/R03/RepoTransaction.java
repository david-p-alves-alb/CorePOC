package com.alticelabs.repository.R03;

import org.bson.conversions.Bson;

/**
 * Define uma interface para representar uma modificação no log de transações.
 * Esta interface fornece métodos para acessar informações básicas da modificação, como token, coleção e documento.
 *
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public interface RepoTransaction {

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
