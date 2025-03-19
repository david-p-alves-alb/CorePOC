package com.alticelabs.bl;

import com.alticelabs.business_interfaces.ILocalRepository;

import java.util.Optional;

public class ChargingService {

    private final ILocalRepository<Account,AccountEvents> accountRepository;

    public ChargingService(ILocalRepository<Account, AccountEvents> accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(String sagaId, String accountID, String name, int balance) {
        accountRepository.create(sagaId, new Account(accountID,name,balance));
    }

    public void charge(String sagaId, String accountID, int amount) {
        Optional<Account> optionalAccount = accountRepository.getByID(sagaId, accountID);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            int balance = account.getBalance();
            balance -= amount;
            AccountChangeBalanceEvent accountChangeBalanceEvent = new AccountChangeBalanceEvent(accountID,balance);
            accountRepository.save(sagaId, accountChangeBalanceEvent);
        }
    }
}
