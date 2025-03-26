package com.alticelabs.exagon.repository.api.interfaces;

import java.util.Map;

/**
 * Esta interface define o comportamento esperado de um handler de mensagens que chegam através de um {@link PubSubChannel}.
 */
public interface SubscriptionHandler {

    /**
     * Executa o processamento de uma mensagem recebida.
     *
     * @param key a chave associada à mensagem
     * @param headers os cabeçalhos da mensagem, representados como um mapa de chave-valor
     * @param payload o conteúdo da mensagem
     */
    void execute(String key, Map<String, String> headers, String payload);
}
