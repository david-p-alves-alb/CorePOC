package com.alticelabs.repository.R00;

import com.alticelabs.repository.R01.Repositories;
import com.alticelabs.repository.R02.RepoPubSub;
import com.alticelabs.repository.R03.RepoTransactionLog;
import com.alticelabs.repository.cdc.RepositoriesCDC;
import com.alticelabs.repository.im_agent.IMAgent;
import com.alticelabs.repository.rollback.RepositoriesRollback;

/**
 * Inicializa os repositórios com todas as dependências necessárias.
 * Esta classe implementa o padrão Singleton para garantir uma única instância global.
 *
 * @author EquipaARQ
 * @version 1.0
 * @since 2025-03-05
 */
public class RepositoryManager {

    /** Instância única de RepositoryManager, seguindo o padrão Singleton. */
    private static final RepositoryManager INSTANCE = new RepositoryManager();

    /** Transaction log. */
    private RepoTransactionLog repoTransactionLog;

    /** Sistema de publicação e assinatura para comunicação entre repositórios. */
    private RepoPubSub repoPubSub;

    /**
     * Inicia os componentes gerenciados por esta classe, incluindo os repositórios, rollback, CDC e IM Agent.
     * Este método configura as dependências necessárias e inicia os serviços associados.
     */
    public void start() {
        // Start Repositories
        Repositories.getInstance().start();
        // Start IM Agent
        IMAgent.getINSTANCE().setPubSub(repoPubSub);
        IMAgent.getINSTANCE().start();
        // Start Rollback
        RepositoriesRollback.getINSTANCE().setRepoPubSub(repoPubSub);
        RepositoriesRollback.getINSTANCE().start();
        // Start CDC
        RepositoriesCDC.getInstance().setRepoTransactionLog(this.repoTransactionLog);
        RepositoriesCDC.getInstance().setRepoPubSub(this.repoPubSub);
        RepositoriesCDC.getInstance().start();
    }

    /**
     * Construtor privado para evitar instanciação direta, conforme o padrão Singleton.
     */
    private RepositoryManager() {}

    /**
     * Obtém a instância única de RepositoryManager.
     *
     * @return a instância singleton de RepositoryManager
     */
    public static RepositoryManager getInstance() {
        return INSTANCE;
    }

    /**
     * Define o sistema de publicação e assinatura a ser utilizado pelo gerenciador.
     *
     * @param repoPubSub o sistema de publicação e assinatura a ser configurado
     */
    public void setRepoPubSub(RepoPubSub repoPubSub) {
        this.repoPubSub = repoPubSub;
    }

    /**
     * Define o registro de transações a ser utilizado pelo gerenciador.
     *
     * @param repoTransactionLog o registro de transações a ser configurado
     */
    public void setRepoTransactionLog(RepoTransactionLog repoTransactionLog) {
        this.repoTransactionLog = repoTransactionLog;
    }
}