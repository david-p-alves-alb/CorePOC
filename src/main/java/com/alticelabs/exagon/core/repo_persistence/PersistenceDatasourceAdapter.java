package com.alticelabs.exagon.core.repo_persistence;

import com.alticelabs.exagon.persistenceprovider.api.Datasource;
import com.alticelabs.exagon.repository.api.interfaces.PersistenceDatasource;
import org.bson.conversions.Bson;

import java.util.List;

public class PersistenceDatasourceAdapter implements PersistenceDatasource {
    private final Datasource datasource;

    public PersistenceDatasourceAdapter(Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public Bson add(Bson document) {
        return datasource.add(document);
    }

    @Override
    public Bson get(Bson filter) {
        return datasource.get(filter);
    }

    @Override
    public Bson update(String id, Bson document) {
        return datasource.update(id, document);
    }

    @Override
    public Bson update(Bson filter, Bson document) {
        return datasource.update(filter, document);
    }

    @Override
    public boolean remove(String id) {
        return datasource.remove(id);
    }

    @Override
    public boolean remove(Bson filter) {
        return datasource.remove(filter);
    }

    @Override
    public List<Bson> getList(Bson filter) {
        return datasource.getList(filter);
    }
}
