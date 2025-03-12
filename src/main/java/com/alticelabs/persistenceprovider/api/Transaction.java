package com.alticelabs.persistenceprovider.api;

import org.bson.conversions.Bson;

/**
 * Representa uma modificação num repositório, contendo informações sobre o token, coleção e documento associados.
 * Esta classe encapsula os dados de uma modificação para uso em operações de repositório.
 *
 * @author [Teu Nome]
 * @version 1.0
 * @since 2025-03-05
 */
public class Transaction {

    /** Token associado à modificação. */
    private final String token;

    /** Nome da coleção associada à modificação. */
    private final String collection;

    /** Documento associado à modificação. */
    private final Bson document;

    /**
     * Constrói uma nova modificação com o token, coleção e documento especificados.
     *
     * @param token o token da modificação
     * @param collection o nome da coleção
     * @param document o documento da modificação
     */
    public Transaction(String token, String collection, Bson document) {
        this.token = token;
        this.collection = collection;
        this.document = document;
    }

    /**
     * Obtém o token da modificação.
     *
     * @return o token da modificação
     */
    public String getToken() {
        return token;
    }

    /**
     * Obtém o documento da modificação.
     *
     * @return o documento da modificação, representado como {@link Bson}
     */
    public Bson getDocument() {
        return document;
    }

    /**
     * Obtém o nome da coleção da modificação.
     *
     * @return o nome da coleção
     */
    public String getCollection() {
        return collection;
    }
}
