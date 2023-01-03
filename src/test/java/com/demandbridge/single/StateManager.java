package com.demandbridge.single;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StateManager {
    // handles state variables etc

    private static Map<String, String> properties = new ConcurrentHashMap<>();

    public static String getProperty(String key) {
        return properties.get(key);
    }

    public static void setProperty(String key, String value) {
        properties.put(key, value);
    }

}
