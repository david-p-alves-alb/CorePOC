package com.alticelabs.redis.api;

import java.util.HashMap;
import java.util.Map;

public class KeyValueFactory {
    private static KeyValueFactory INSTANCE = new KeyValueFactory();

    public static KeyValueFactory getINSTANCE() {
        return INSTANCE;
    }

    private final Map<String,KeyValueStore> keyValueStoreMap;

    private KeyValueFactory() {
        this.keyValueStoreMap = new HashMap<>();
    }

    public KeyValueStore getKeyValueStore(String storeName) {
        KeyValueStore keyValueStore = new KeyValueStore(storeName);
        keyValueStoreMap.put(storeName, keyValueStore);
        return keyValueStore;
    }

    public void start() {}
}
