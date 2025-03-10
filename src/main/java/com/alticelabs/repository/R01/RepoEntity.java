package com.alticelabs.repository.R01;

import com.alticelabs.api.ExagonEntityEvent;
import com.alticelabs.api.ExagonEntityID;
import org.bson.conversions.Bson;

import java.util.List;

public abstract class RepoEntity extends RepoEntityID implements Bson {
    public RepoEntity() {
    }

    public RepoEntity(String ID) {
        super(ID);
    }

    public abstract void reconstruct(List<RepoEntityEvent> var1);
}
