package com.alticelabs.repository.api;

import java.util.List;

/**
 * Define uma interface para um armazenamento em memória compartilhada.
 * Esta interface fornece métodos para manipulação de pares chave-valor, conjuntos e bloqueios em memória.
 *
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public interface MemSharedDatasource {

    /**
     * Armazena um valor associado a uma chave no armazenamento em memória.
     *
     * @param key a chave associada ao valor
     * @param value o valor a ser armazenado
     */
    void put(String key, String value);

    /**
     * Obtém o valor associado a uma chave no armazenamento em memória.
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
     * Adiciona ou atualiza um campo em um conjunto associado a uma chave no armazenamento em memória.
     *
     * @param key a chave do conjunto
     * @param field o campo a ser adicionado ou atualizado no conjunto
     * @param object o objeto a ser armazenado no campo
     * @return {@code true} se a operação foi bem-sucedida, {@code false} caso contrário
     */
    Boolean putSet(String key, String field, Object object);

    /**
     * Cria um bloqueio no armazenamento em memória com uma chave e tempo de vida especificados.
     *
     * @param lockKey a chave do bloqueio
     * @param ttl o tempo de vida do bloqueio em milissegundos
     * @return {@code true} se o bloqueio foi criado com sucesso, {@code false} caso contrário
     */
    boolean createLock(String lockKey, long ttl);

    /**
     * Obtém todas as chaves de um conjunto associado a uma chave no armazenamento em memória.
     *
     * @param key a chave do conjunto
     * @return uma lista de chaves contidas no conjunto
     */
    List<String> getAllKeysFromSet(String key);
}
