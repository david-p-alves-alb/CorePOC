package com.alticelabs.repository.api;

import java.util.Map;

/**
 * Esta interface define o comportamento esperado de um canal de comunicação específico
 * onde é permitido publicar e subscrever mensagens.
 * As mensagens são contituídas por uma chave, cabeçalhos e um payload.
 */
public interface PubSubChannel {

    /**
     * Publica uma mensagem pelo canal específico com uma chave, cabeçalhos e conteúdo.
     *
     * @param key a chave associada à mensagem
     * @param headers os cabeçalhos da mensagem, representados como um mapa de chave-valor
     * @param payload o conteúdo da mensagem
     */
    void publish(String key, Map<String, String> headers, String payload);

    /**
     * Subscreve a um canal específico, associando um handler para processar as mensagens recebidas.
     *
     * @param handler o handler que processará as mensagens recebidas
     */
    void subscribe(SubscriptionHandler handler);
}
