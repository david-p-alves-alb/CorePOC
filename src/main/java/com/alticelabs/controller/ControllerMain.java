package com.alticelabs.controller;

import com.alticelabs.api.*;
import com.alticelabs.tc.repository.*;

public class ControllerMain {
    public static void main(String[] args) {
        IReadOnlyRepository<ExagonEntity, ExagonEntityEvent> readOnlyRepository = new TCReadOnlyRepository<>(ExagonEntity.class, ExagonEntityEvent.class);
        IReadWriteRepository<ExagonEntity, ExagonEntityEvent> readWriteRepository = new TCReadWriteRepository<>(ExagonEntity.class, ExagonEntityEvent.class);
        ILocalRepository<ExagonEntity, ExagonEntityEvent> localRepository = new TCLocalRepository<>(ExagonEntity.class, ExagonEntityEvent.class);
        IQueryRepository<ExagonEntity, ExagonEntityEvent> queryRepository = new TCQueryRepository<>(ExagonEntity.class, ExagonEntityEvent.class);
        ITransientRepository<ExagonEntity, ExagonEntityEvent> transientRepository = new TCTransientRepository<>(ExagonEntity.class, ExagonEntityEvent.class);
    }
}
