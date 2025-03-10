package com.alticelabs.controller;

import com.alticelabs.api.*;
import com.alticelabs.tc.repository.*;

public class ControllerMain {
    public static void main(String[] args) {
        IReadOnlyRepository<ExagonEntity> readOnlyRepository = new TCReadOnlyRepository<>(ExagonEntity.class);
        IReadWriteRepository<ExagonEntity, ExagonEntityEvent> readWriteRepository = new TCReadWriteRepository<>(ExagonEntity.class, ExagonEntityEvent.class);
        ILocalRepository<ExagonEntity, ExagonEntityEvent> localRepository = new TCLocalRepository<>(ExagonEntity.class, ExagonEntityEvent.class);
        IQueryRepository<ExagonEntity> queryRepository = new TCQueryRepository<>(ExagonEntity.class);
        ITransientRepository<ExagonEntity> transientRepository = new TCTransientRepository<>(ExagonEntity.class);
    }
}
