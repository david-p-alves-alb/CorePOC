package com.alticelabs.repository.api;

import java.util.List;

/**
 * Esta interface define o comportamento esperado do armazenamento chave-valor em memórias partilhada (ex.: Redis).
 * Esta interface fornece métodos para manipulação de pares chave-valor e criação de locks.
 * Os pares chave-valor serão sempre do tipo String : String
 */
public interface MemSharedDatasource {

    /**
     * Armazena um valor associado a uma chave.
     *
     * @param key a chave associada ao valor
     * @param value o valor a ser armazenado
     */
    void put(String key, String value);

    /**
     * Obtém o valor associado a uma chave.
     *
     * @param key a chave do valor a ser recuperado
     * @return o valor associado à chave
     */
    String get(String key);

    /**
     * Remove um valor do armazenamento em memória com base em sua chave.
     *
     * @param key a chave do valor a ser removido
     */
    void delete(String key);

    /**
     * Adiciona ou atualiza um campo em um mapa associado a uma chave.
     *
     * @param key a chave do conjunto
     * @param field o campo a ser adicionado ou atualizado no conjunto
     * @param value o valor a ser armazenado no campo
     * @return {@code true} se a operação foi bem-sucedida, {@code false} caso contrário
     */
    boolean putSet(String key, String field, String value);

    /**
     * Cria um lock com uma chave e tempo de vida especificados.
     *
     * @param lockKey a chave do bloqueio
     * @param ttl o tempo de vida do bloqueio em milissegundos
     * @return {@code true} se o bloqueio foi criado com sucesso, {@code false} caso contrário
     */
    boolean createLock(String lockKey, long ttl);

    /**
     * Obtém todas os campos de um mapa associado a uma chave.
     *
     * @param key a chave do conjunto
     * @return uma lista de campos contidos no mapa
     */
    List<String> getAllKeysFromSet(String key);
}
