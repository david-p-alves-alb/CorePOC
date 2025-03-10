package com.alticelabs.tc.repository;

import com.alticelabs.api.ExagonEntityEvent;
import com.alticelabs.repository.R01.RepoEntityEvent;
import org.bson.BsonDocument;
import org.bson.codecs.configuration.CodecRegistry;

public class TCEntityEventAdapter<S extends ExagonEntityEvent> extends RepoEntityEvent {
    private S event;

    public TCEntityEventAdapter(S event) {
        this.event = event;
    }

    public S getEvent() {
        return event;
    }

    @Override
    public <TDocument> BsonDocument toBsonDocument(Class<TDocument> aClass, CodecRegistry codecRegistry) {
        return event.toBsonDocument(aClass, codecRegistry);
    }

    @Override
    public BsonDocument toBsonDocument() {
        return event.toBsonDocument();
    }
}
