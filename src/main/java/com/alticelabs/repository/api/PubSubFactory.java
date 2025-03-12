package com.alticelabs.repository.api;

import java.util.Map;

/**
 * Define uma interface para um sistema de publicação e assinatura (Pub/Sub) em repositórios.
 * Esta interface permite a publicação de mensagens para destinos específicos e a subscrição a esses destinos.
 *
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public interface PubSubFactory {

    //Exactly once
    PubSubChannel getPriorityChannel(String destination);

    //At most once
    PubSubChannel getChannel(String destination);
}
