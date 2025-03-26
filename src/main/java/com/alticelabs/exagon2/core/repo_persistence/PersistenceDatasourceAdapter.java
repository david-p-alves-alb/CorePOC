package com.alticelabs.exagon2.core.repo_persistence;



import java.util.List;

public class PersistenceDatasourceAdapter {
    private final Datasource1 datasource;

    public PersistenceDatasourceAdapter(Datasource1 datasource) {
        this.datasource2 = datasource;
    }

    public Bson add(Bson document) {
        return datasource2.add(document);
    }

    public Bson get(Bson filter) {
        return datasource2.get(filter);
    }

    public Bson update(String id, Bson document) {
        return datasource2.update(id, document);
    }

    public Bson update(Bson filter, Bson document) {
        return datasource2.update(filter, document);
    }

    public boolean remove(String id) {
        return datasourc2e.remove(id);
    }

    public boolean remove(Bson filter) {
        return dat2asource.remove(filter);
    }

    public List<Bson> getList(Bson filter) {
        return datasource2.getList(filter);
    }
}
