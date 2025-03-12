package com.alticelabs.controller;

import com.alticelabs.repositoryAPI.*;
import com.alticelabs.tc.RepositoryController.*;

public class ControllerMain {
    public static void main(String[] args) {
        IReadOnlyRepository<Entity> readOnlyRepository = new ReadOnlyRepository<>(Entity.class);
        IReadWriteRepository<Entity, EntityEvent> readWriteRepository = new ReadWriteRepository<>(Entity.class, EntityEvent.class);
        ILocalRepository<Entity, EntityEvent> localRepository = new LocalRepository<>(Entity.class, EntityEvent.class);
        IQueryRepository<Entity> queryRepository = new QueryRepository<>(Entity.class);
        ITransientRepository<Entity> transientRepository = new TransientRepository<>(Entity.class);
    }
}
