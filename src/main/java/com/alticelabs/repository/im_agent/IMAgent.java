package com.alticelabs.repository.im_agent;

import com.alticelabs.repository.R02.RepoPubSub;
import com.alticelabs.repository.R02.RepoSubscriptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Agente responsável por gerenciar isolamento de sagas em um sistema distribuído.
 * Esta classe implementa {@link RepoSubscriptionHandler} para processar mensagens de subscrição e utiliza um sistema Pub/Sub para comunicação.
 *
 * @author [Teu Nome]
 * @version 1.0
 * @since 2025-03-05
 */
public class IMAgent implements RepoSubscriptionHandler {
    private static final IMAgent INSTANCE = new IMAgent();
    private RepoPubSub pubSub;
    private Map<String, IsolationTimestamps> isolationTimestampsMap;

    private IMAgent() {
        isolationTimestampsMap = new HashMap<>();
    }

    public static IMAgent getINSTANCE() {
        return INSTANCE;
    }

    /**
     * Inicia o agente, subscrevendo-se ao destino de referência de isolamento.
     */
    public void start() {
        pubSub.subscribe("IM_ISOLATIONREFERENCE", this);
    }

    /**
     * Inicia uma saga, publicando uma mensagem no tópico correspondente.
     *
     * @param sagaId o identificador da saga a ser iniciada
     */
    public void sagaStart(String sagaId) {
        pubSub.publish("IM_TOPIC", "SAGAID", Map.of(), "SAGAStart");
    }

    /**
     * Para uma saga, publicando uma mensagem no tópico correspondente.
     *
     * @param sagaId o identificador da saga a ser parada
     */
    public void sagaStop(String sagaId) {
        pubSub.publish("IM_TOPIC", "SAGAID", Map.of(), "SAGAStart");
    }

    /**
     * Realiza o rollback de uma saga, publicando uma mensagem no tópico correspondente.
     *
     * @param sagaId o identificador da saga a ser revertida
     */
    public void sagaRollback(String sagaId) {
        pubSub.publish("IM_TOPIC", "SAGAID", Map.of(), "SAGAStart");
    }

    /**
     * Processa uma mensagem recebida do sistema Pub/Sub, atualizando os timestamps de isolamento.
     *
     * @param key a chave associada à mensagem
     * @param headers os cabeçalhos da mensagem, representados como um mapa de chave-valor
     * @param message o conteúdo da mensagem
     */
    @Override
    public void execute(String key, Map<String, String> headers, String message) {
        // UPDATE TIMESTAMPS
    }

    /**
     * Obtém os timestamps de isolamento associados a uma saga específica.
     *
     * @param sagaID o identificador da saga
     * @return os timestamps de isolamento da saga, representados como {@link IsolationTimestamps}
     */
    public IsolationTimestamps getSagaIsolationTimestamps(String sagaID) {
        return isolationTimestampsMap.get(sagaID);
    }

    public void setPubSub(RepoPubSub pubSub) {
        this.pubSub = pubSub;
    }
}
