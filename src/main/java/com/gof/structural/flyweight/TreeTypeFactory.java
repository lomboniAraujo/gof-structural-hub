package com.gof.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeTypeFactory {
    private final Map<String, TreeType> cache = new HashMap<>();

    public TreeType getTreeType(String name, String color, String texture) {
        String key = name + "|" + color + "|" + texture;
        return cache.computeIfAbsent(key, ignored -> new TreeType(name, color, texture));
    }

    public int size() {
        return cache.size();
    }
}
