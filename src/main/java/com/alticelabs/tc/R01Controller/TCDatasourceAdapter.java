package com.alticelabs.tc.R01Controller;

import com.alticelabs.persistenceprovider.PP01.Datasource;
import com.alticelabs.repository.R03.RepoDatasource;
import org.bson.conversions.Bson;

import java.util.List;

public class TCDatasourceAdapter implements RepoDatasource {

    private final Datasource datasource;

    public TCDatasourceAdapter(Datasource datasource) {
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
