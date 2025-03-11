package com.alticelabs.controller;

import com.alticelabs.repo_external_api.*;
import com.alticelabs.tc.R01Controller.*;

public class ControllerMain {
    public static void main(String[] args) {
        IReadOnlyRepository<Entity> readOnlyRepository = new TCReadOnlyRepository<>(Entity.class);
        IReadWriteRepository<Entity, EntityEvent> readWriteRepository = new TCReadWriteRepository<>(Entity.class, EntityEvent.class);
        ILocalRepository<Entity, EntityEvent> localRepository = new TCLocalRepository<>(Entity.class, EntityEvent.class);
        IQueryRepository<Entity> queryRepository = new TCQueryRepository<>(Entity.class);
        ITransientRepository<Entity> transientRepository = new TCTransientRepository<>(Entity.class);
    }
}
