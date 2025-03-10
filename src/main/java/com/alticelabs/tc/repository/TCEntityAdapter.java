package com.alticelabs.tc.repository;

import com.alticelabs.api.ExagonEntity;
import com.alticelabs.api.ExagonEntityEvent;
import com.alticelabs.repository.R01.RepoEntity;
import com.alticelabs.repository.R01.RepoEntityEvent;
import org.bson.BsonDocument;
import org.bson.codecs.configuration.CodecRegistry;

import java.util.List;

public class TCEntityAdapter<T extends ExagonEntity> extends RepoEntity {

    private T entity;

    public TCEntityAdapter(T entity) {
        this.entity = entity;
        this.setId(entity.getId());
    }

    public T getEntity() {
        return entity;
    }

    @Override
    public void reconstruct(List<RepoEntityEvent> events) {
        List<ExagonEntityEvent> exagonEntityEvents = events.stream().filter(event -> event instanceof TCEntityEventAdapter)
                .map((event) -> ((TCEntityEventAdapter<ExagonEntityEvent>) event).getEvent())
                .toList();
        this.entity.reconstruct(exagonEntityEvents);
    }

    @Override
    public <TDocument> BsonDocument toBsonDocument(Class<TDocument> aClass, CodecRegistry codecRegistry) {
        return entity.toBsonDocument(aClass, codecRegistry);
    }

    @Override
    public BsonDocument toBsonDocument() {
        return entity.toBsonDocument();
    }
}
