package com.alticelabs.exagon.repository.cdc;

import com.alticelabs.exagon.repository.api.interfaces.*;
import org.bson.BsonDocument;
import org.bson.Document;
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
    private final PersistenceDatasource tokenDatasource;
    private boolean running = false;

    /**
     * Construtor privado para evitar instanciação direta, conforme o padrão Singleton.
     */
    public CDCHandler(PubSubFactory pubSubFactory, TransactionLog transactionLog, PersistenceDatasource tokenDatasource) {
        this.pubSubFactory = pubSubFactory;
        this.transactionLog = transactionLog;
        this.tokenDatasource = tokenDatasource;
    }

    /**
     * Inicia o processo de captura de dados de mudança, monitorando transações e publicando alterações via Pub/Sub.
     */
    public void start() {
        // Get token from storage
        Document filterTokenDocument = new Document();
        filterTokenDocument.append("id","TOKEN");
        BsonDocument bsonDocument = tokenDatasource.get(filterTokenDocument).toBsonDocument();
        String token = bsonDocument.getString("token").toString();

        this.transactionLog.start(token);
        running = true;
        while (running) {
            Transaction transaction = this.transactionLog.getNext();
            if (transaction == null) {
                // No new changes.
                Thread.onSpinWait();
            } else {
                String transactionToken = transaction.getToken();
                BsonDocument document = transaction.getDocument().toBsonDocument();
                String documentId = document.getString("id").toString();
                String collection = transaction.getCollection();

                // Send document to pub sub
                PubSubChannel collectionChannel = pubSubFactory.getPriorityChannel(collection);
                collectionChannel.publish(documentId, Map.of(), document.toString());

                // Save token
                Document tokenDocument = new Document();
                tokenDocument.append("token", transactionToken);
                tokenDatasource.update("TOKEN",tokenDocument);
            }
        }
    }

    public void stop() {
        running = false;
    }

}