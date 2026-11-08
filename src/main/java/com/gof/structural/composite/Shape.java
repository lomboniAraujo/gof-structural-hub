package com.gof.structural.composite;

public class Shape implements Graphic {
    private final String name;

    public Shape(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Drawing shape: " + name);
    }
}
