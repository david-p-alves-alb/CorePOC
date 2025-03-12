package com.alticelabs.repository.api;

import java.util.Map;

public interface PubSubChannel {
    /**
     * Publica uma mensagem em um destino específico com uma chave, cabeçalhos e conteúdo.
     *
     * @param key a chave associada à mensagem
     * @param headers os cabeçalhos da mensagem, representados como um mapa de chave-valor
     * @param message o conteúdo da mensagem
     */
    void publish(String key, Map<String, String> headers, String message);

    /**
     * Subscreve a um destino específico, associando um handler para processar as mensagens recebidas.
     *
     * @param handler o handler que processará as mensagens recebidas
     */
    void subscribe(SubscriptionHandler handler);
}
