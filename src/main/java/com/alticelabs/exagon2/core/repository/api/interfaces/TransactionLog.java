package com.alticelabs.exagon.repository.api.interfaces;


/**
 * Esta interface define o comportamento esperado de um Transaction Log (OpLog).
 * Esta interface permite começar a ler o Transaction Log a partir de um determinado token e permite obter a próxima mudança.
 */
public interface TransactionLog {

    /**
     * Inicia a leitura do log de transações na posição determinada pelo token.
     *
     * @param token o token associado à posição no log.
     */
    void start(String token);

    /**
     * Obtém a próxima modificação registrada no log.
     *
     * @return a próxima modificação, representada como {@link Transaction}
     */
    Transaction getNext();
}
