package com.alticelabs.repository.R02;

import java.util.Map;

/**
 * Define uma interface para um sistema de publicação e assinatura (Pub/Sub) em repositórios.
 * Esta interface permite a publicação de mensagens para destinos específicos e a subscrição a esses destinos.
 *
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public interface RepoPubSub {

    /**
     * Publica uma mensagem em um destino específico com uma chave, cabeçalhos e conteúdo.
     *
     * @param destination o destino para o qual a mensagem será publicada
     * @param key a chave associada à mensagem
     * @param headers os cabeçalhos da mensagem, representados como um mapa de chave-valor
     * @param message o conteúdo da mensagem
     */
    void publish(String destination, String key, Map<String, String> headers, String message);

    /**
     * Subscreve a um destino específico, associando um handler para processar as mensagens recebidas.
     *
     * @param destination o destino ao qual se deseja subscrever
     * @param handler o handler que processará as mensagens recebidas
     */
    void subscribe(String destination, RepoSubscriptionHandler handler);
}
