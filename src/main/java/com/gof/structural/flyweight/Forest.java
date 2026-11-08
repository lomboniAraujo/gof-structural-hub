package com.gof.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private final List<Tree> trees = new ArrayList<>();
    private final TreeTypeFactory factory = new TreeTypeFactory();

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = factory.getTreeType(name, color, texture);
        trees.add(new Tree(x, y, type));
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }

    public int getTreeTypeCount() {
        return factory.size();
    }
}
