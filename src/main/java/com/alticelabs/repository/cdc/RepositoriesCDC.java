package com.alticelabs.repository.cdc;

import com.alticelabs.repository.R02.RepoPubSub;
import com.alticelabs.repository.R03.RepoTransaction;
import com.alticelabs.repository.R03.RepoTransactionLog;
import org.bson.conversions.Bson;

import java.util.Map;

/**
 * Gerencia a captura de dados de mudança (CDC - Change Data Capture) em repositórios.
 * Esta classe implementa o padrão Singleton e utiliza um log de transações e um sistema Pub/Sub para processar e publicar alterações.
 *
 * @author [Teu Nome]
 * @version 1.0
 * @since 2025-03-05
 */
public class RepositoriesCDC {

    private static RepositoriesCDC INSTANCE;
    private RepoTransactionLog repoTransactionLog;
    private RepoPubSub repoPubSub;

    /**
     * Construtor privado para evitar instanciação direta, conforme o padrão Singleton.
     */
    private RepositoriesCDC() {}

    /**
     * Obtém a instância única de RepositoriesCDC, criando-a se ainda não existir.
     *
     * @return a instância singleton de RepositoriesCDC
     */
    public static RepositoriesCDC getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RepositoriesCDC();
        }
        return INSTANCE;
    }

    /**
     * Define o registro de transações a ser utilizado para captura de mudanças.
     *
     * @param repoTransactionLog o registro de transações a ser configurado
     */
    public void setRepoTransactionLog(RepoTransactionLog repoTransactionLog) {
        this.repoTransactionLog = repoTransactionLog;
    }

    /**
     * Inicia o processo de captura de dados de mudança, monitorando transações e publicando alterações via Pub/Sub.
     */
    public void start() {
        // Get token from storage
        String token = "Token";
        this.repoTransactionLog.start(token);
        while (true) {
            RepoTransaction transaction = this.repoTransactionLog.getNext();
            if (transaction == null) {
                // No new changes.
                Thread.onSpinWait();
            } else {
                String transactionToken = transaction.getToken();
                Bson document = transaction.getDocument();
                String collection = transaction.getCollection();
                // Send document to pub sub
                repoPubSub.publish(collection, "documentID", Map.of(), "documentBsonToString");

                // Save token
            }
            break;
        }
    }

    /**
     * Define o sistema de publicação e assinatura a ser utilizado para notificar alterações.
     *
     * @param repoPubSub o sistema de publicação e assinatura a ser configurado
     */
    public void setRepoPubSub(RepoPubSub repoPubSub) {
        this.repoPubSub = repoPubSub;
    }
}