package com.gof.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeGraphic implements Graphic {
    private final String name;
    private final List<Graphic> children = new ArrayList<>();

    public CompositeGraphic(String name) {
        this.name = name;
    }

    public void add(Graphic graphic) {
        children.add(graphic);
    }

    public void remove(Graphic graphic) {
        children.remove(graphic);
    }

    @Override
    public void draw() {
        System.out.println("Group: " + name);
        for (Graphic child : children) {
            child.draw();
        }
    }
}
