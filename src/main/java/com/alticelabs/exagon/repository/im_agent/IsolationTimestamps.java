package com.alticelabs.exagon.repository.im_agent;

import java.time.Instant;

/**
 * Modelo com os tempos de isolamento de uma Saga enviados pelo Isolation Manager.
 */
public class IsolationTimestamps {
    private Instant tsWrite;
    private Instant tsRead;
    private Instant tsReference;

    public IsolationTimestamps(Instant tsWrite, Instant tsRead, Instant tsReference) {
        this.tsWrite = tsWrite;
        this.tsRead = tsRead;
        this.tsReference = tsReference;
    }

    public Instant getTsWrite() {
        return tsWrite;
    }

    public void setTsWrite(Instant tsWrite) {
        this.tsWrite = tsWrite;
    }

    public Instant getTsRead() {
        return tsRead;
    }

    public void setTsRead(Instant tsRead) {
        this.tsRead = tsRead;
    }

    public Instant getTsReference() {
        return tsReference;
    }

    public void setTsReference(Instant tsReference) {
        this.tsReference = tsReference;
    }
}
