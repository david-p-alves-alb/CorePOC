package com.alticelabs.exagon.repository.api.interfaces;

/**
 * Esta interface define o comportamento esperado de uma factory
 * onde é permitido criar canais de comunicação com diferentes prioridades.
 */
public interface PubSubFactory {

    /**
     * Obtém um canal de comunicação prioritário (todas as mensagens têm de ser processadas).
     *
     * @param destination o destino associado a este canal
     * @return o canal prioritário associado com o destino
     */
    PubSubChannel getPriorityChannel(String destination);

    /**
     * Obtém um canal de comunicação não prioritário (não é necessário garantir que todas as mensagens são processadas).
     *
     * @param destination o destino associado a este canal
     * @return o canal não prioritário associado com o destino
     */
    PubSubChannel getChannel(String destination);
}
