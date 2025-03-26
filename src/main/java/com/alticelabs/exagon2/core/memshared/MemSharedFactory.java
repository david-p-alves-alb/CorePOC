package com.alticelabs.exagon2.core.memshared;

import com.alticelabs.exagon_working.redis_lib.api.KeyValueStore;

import java.util.HashMap;
import java.util.Map;

public class MemSharedFactory {
    private static MemSharedFactory INSTANCE = new MemSharedFactory();

    public static MemSharedFactory getINSTANCE() {
        return INSTANCE;
    }

    private final Map<String, KeyValueStore> memSharedStoreMap;

    private MemSharedFactory() {
        this.memSharedStoreMap = new HashMap<>();
    }

    public KeyValueStore getMemSharedStore(String storeName) {
        KeyValueStore memSharedStore = new KeyValueStore(storeName);
        memSharedStoreMap.put(storeName, memSharedStore);
        return memSharedStore;
    }

    public void start() {}
}
