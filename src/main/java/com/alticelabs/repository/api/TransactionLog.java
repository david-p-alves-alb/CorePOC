package com.alticelabs.repository.api;


/**
 * Define uma interface para um registro no log de transações .
 * Esta interface permite iniciar um log de transações e obter a próxima modificação registrada.
 *
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public interface TransactionLog {

    /**
     * Inicia o registro de modificações com um token específico.
     *
     * @param token o token associado ao início do log
     */
    void start(String token);

    /**
     * Obtém a próxima modificação registrada no log.
     *
     * @return a próxima modificação, representada como {@link Transaction}
     */
    Transaction getNext();
}
