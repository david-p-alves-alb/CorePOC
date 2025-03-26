package com.alticelabs.controller;

import com.alticelabs.bl.Account;
import com.alticelabs.bl.AccountEvents;
import com.alticelabs.business_interfaces.ILocalRepository;
import com.alticelabs.exagon2.core.repository.api.LocalRepository;
import com.alticelabs.exagon2.core.repository.api.RepositoryFactory;

import java.util.List;
import java.util.Optional;

public class AccountRepository implements ILocalRepository<Account, AccountEvents> {
    private final LocalRepository<Account, AccountEvents> repository;

    public AccountRepository() {
        this.repository = RepositoryFactory.getINSTANCE().getLocalRepository(Account.class,AccountEvents.class);
    }

    @Override
    public Optional<Account> getByID(String sagaId, String id) {
        return repository.getById(sagaId, id);
    }

    @Override
    public List<Account> getAllByID(String sagaId, List<String> ids) {
        return repository.getByIdList(sagaId, ids);
    }

    @Override
    public Optional<Account> getByIDLatest(String id) {
        return repository.getByIdLatest(id);
    }

    @Override
    public String create(String sagaId, Account entity) {
        return repository.create(sagaId, entity);
    }

    @Override
    public void save(String sagaId, AccountEvents event) {
        repository.save(sagaId, event);
    }

    @Override
    public void remove(String sagaId, String id) {
        repository.remove(sagaId, id);
    }

    @Override
    public void revert(String sagaId) {
        repository.revert(sagaId);
    }
}
