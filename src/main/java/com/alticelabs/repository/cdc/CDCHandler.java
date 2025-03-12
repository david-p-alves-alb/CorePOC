package com.alticelabs.repository.cdc;

import com.alticelabs.repository.api.PubSubChannel;
import com.alticelabs.repository.api.PubSubFactory;
import com.alticelabs.repository.api.Transaction;
import com.alticelabs.repository.api.TransactionLog;
import org.bson.conversions.Bson;

import java.util.Map;

/**
 * Gerencia a captura de dados de mudança (CDC - Change Data Capture) em repositórios.
 * Esta classe implementa o padrão Singleton e utiliza um log de transações e um sistema Pub/Sub para processar e
 * publicar alterações.
 */
public class CDCHandler {

    private final TransactionLog transactionLog;
    private final PubSubFactory pubSubFactory;
    private boolean running = false;

    /**
     * Construtor privado para evitar instanciação direta, conforme o padrão Singleton.
     */
    public CDCHandler(PubSubFactory pubSubFactory, TransactionLog transactionLog) {
        this.pubSubFactory = pubSubFactory;
        this.transactionLog = transactionLog;
    }

    /**
     * Inicia o processo de captura de dados de mudança, monitorando transações e publicando alterações via Pub/Sub.
     */
    public void start() {
        // Get token from storage
        String token = "Token";
        this.transactionLog.start(token);
        running = true;
        while (running) {
            Transaction transaction = this.transactionLog.getNext();
            if (transaction == null) {
                // No new changes.
                Thread.onSpinWait();
            } else {
                String transactionToken = transaction.getToken();
                Bson document = transaction.getDocument();
                String collection = transaction.getCollection();
                // Send document to pub sub
                PubSubChannel collectionChannel = pubSubFactory.getChannel(collection);
                collectionChannel.publish("documentID", Map.of(), "documentBsonToString");

                // Save token
            }
        }
    }

    public void stop() {
        running = false;
    }

}