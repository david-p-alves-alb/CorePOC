package com.alticelabs.exagon.repository.im_agent;

import com.alticelabs.exagon.repository.api.interfaces.PubSubChannel;
import com.alticelabs.exagon.repository.api.interfaces.PubSubFactory;
import com.alticelabs.exagon.repository.api.interfaces.SubscriptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Agente responsável por gerenciar isolamento de sagas em um sistema distribuído.
 * Esta classe implementa {@link SubscriptionHandler} para processar mensagens de subscrição e utiliza um sistema
 * Pub/Sub para comunicação.
 */
public class IMAgent implements SubscriptionHandler {

    /** Canal para receber os tempos de isolamento de uma Saga */
    private final PubSubChannel isolationReferenceChannel;
    /** Canal para iniciar/terminar uma Saga */
    private final PubSubChannel imSagaChannel;
    private final Map<String, IsolationTimestamps> isolationTimestampsMap;

    public IMAgent(PubSubFactory pubSub) {
        this.isolationReferenceChannel = pubSub.getChannel("IM_ISOLATIONREFERENCE");
        this.imSagaChannel = pubSub.getChannel("IM_TOPIC");
        isolationTimestampsMap = new HashMap<>();
    }

    /**
     * Inicia o agente, subscrevendo-se ao destino de referência de isolamento.
     */
    public void start() {
        isolationReferenceChannel.subscribe(this);
    }

    /**
     * Inicia uma saga, publicando uma mensagem no tópico correspondente.
     *
     * @param sagaId o identificador da saga a ser iniciada
     */
    public void sagaStart(String sagaId) {
        imSagaChannel.publish("SAGAID", Map.of(), "SAGAStart");
    }

    /**
     * Para uma saga, publicando uma mensagem no tópico correspondente.
     *
     * @param sagaId o identificador da saga a ser parada
     */
    public void sagaStop(String sagaId) {
        imSagaChannel.publish("SAGAID", Map.of(), "SAGAStop");
    }

    /**
     * Realiza o rollback de uma saga, publicando uma mensagem no tópico correspondente.
     *
     * @param sagaId o identificador da saga a ser revertida
     */
    public void sagaRollback(String sagaId) {
        imSagaChannel.publish("SAGAID", Map.of(), "SAGARollback");
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

}
