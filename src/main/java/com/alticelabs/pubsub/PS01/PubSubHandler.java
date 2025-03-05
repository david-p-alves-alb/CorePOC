package com.alticelabs.pubsub.PS01;

import java.util.Map;

/**
 * Define uma interface para o handler de mensagens em um sistema de publicação e assinatura (Pub/Sub).
 * Esta interface especifica o comportamento para processar mensagens recebidas.
 *
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public interface PubSubHandler {

    /**
     * Executa o processamento de uma mensagem recebida.
     *
     * @param key a chave associada à mensagem
     * @param headers os cabeçalhos da mensagem, representados como um mapa de chave-valor
     * @param message o conteúdo da mensagem
     */
    void execute(String key, Map<String, String> headers, String message);
}
