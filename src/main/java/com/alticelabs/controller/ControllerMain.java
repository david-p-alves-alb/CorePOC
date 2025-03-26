package com.alticelabs.controller;

import com.alticelabs.bl.ChargingService;
import com.alticelabs.exagon2.core.api.ExagonCore;

public class ControllerMain {
    public static void main(String[] args) {
        ExagonCore.start();

        AccountRepository accountRepository = new AccountRepository();
        ChargingService chargingService = new ChargingService(accountRepository);

        chargingService.createAccount("SAGA_1","ACCOUNT_1","CLIENT_1",10);
        chargingService.charge("SAGA_2","ACCOUNT_1",5);
    }
}
