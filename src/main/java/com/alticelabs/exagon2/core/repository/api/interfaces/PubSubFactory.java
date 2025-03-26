package com.alticelabs.exagon.repository.api.interfaces;

/**
 * Esta interface define o comportamento esperado de uma factory
 * onde é permitido criar canais de comunicação com diferentes prioridades.
 */
public interface PubSubFactory {

    // Producer e Consumer Prioritários. Exemplo: Producer de CDC com confirmação no envio da mensagem e consumer de ST
    // com política de commit depois do handler.
    /**
     * Obtém um canal de comunicação prioritário (todas as mensagens têm de ser processadas).
     *
     * @param id o identificador associado a este canal
     * @return o canal prioritário associado com o identificador
     */
    PubSubChannel getPriorityChannel(String id);

    /**
     * Obtém um canal de comunicação não prioritário (não é necessário garantir que todas as mensagens são processadas).
     *
     * @param id o identificador associado a este canal
     * @return o canal não prioritário associado com o identificador
     */
    PubSubChannel getChannel(String id);
}
