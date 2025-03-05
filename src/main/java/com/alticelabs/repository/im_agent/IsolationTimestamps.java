package com.alticelabs.repository.im_agent;

import java.time.LocalDateTime;

public class IsolationTimestamps {
    private LocalDateTime tsWrite;
    private LocalDateTime tsRead;
    private LocalDateTime tsReference;

    public IsolationTimestamps(LocalDateTime tsWrite, LocalDateTime tsRead, LocalDateTime tsReference) {
        this.tsWrite = tsWrite;
        this.tsRead = tsRead;
        this.tsReference = tsReference;
    }

    public LocalDateTime getTsWrite() {
        return tsWrite;
    }

    public void setTsWrite(LocalDateTime tsWrite) {
        this.tsWrite = tsWrite;
    }

    public LocalDateTime getTsRead() {
        return tsRead;
    }

    public void setTsRead(LocalDateTime tsRead) {
        this.tsRead = tsRead;
    }

    public LocalDateTime getTsReference() {
        return tsReference;
    }

    public void setTsReference(LocalDateTime tsReference) {
        this.tsReference = tsReference;
    }
}
