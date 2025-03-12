package com.alticelabs.repository.api;

import java.util.Map;

/**
 * Define uma interface para o handler de subscrições em um sistema de publicação e assinatura (Pub/Sub).
 * Esta interface especifica o comportamento para processar mensagens recebidas de um destino subscrito.
 *
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public interface SubscriptionHandler {

    /**
     * Executa o processamento de uma mensagem recebida de um destino subscrito.
     *
     * @param key a chave associada à mensagem
     * @param headers os cabeçalhos da mensagem, representados como um mapa de chave-valor
     * @param message o conteúdo da mensagem
     */
    void execute(String key, Map<String, String> headers, String message);
}
