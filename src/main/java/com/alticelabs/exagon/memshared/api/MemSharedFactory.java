package com.alticelabs.exagon.memshared.api;

import java.util.HashMap;
import java.util.Map;

public class MemSharedFactory {
    private static MemSharedFactory INSTANCE = new MemSharedFactory();

    public static MemSharedFactory getINSTANCE() {
        return INSTANCE;
    }

    private final Map<String, MemSharedStore> memSharedStoreMap;

    private MemSharedFactory() {
        this.memSharedStoreMap = new HashMap<>();
    }

    public MemSharedStore getMemSharedStore(String storeName) {
        MemSharedStore memSharedStore = new MemSharedStore(storeName);
        memSharedStoreMap.put(storeName, memSharedStore);
        return memSharedStore;
    }

    public void start() {}
}
