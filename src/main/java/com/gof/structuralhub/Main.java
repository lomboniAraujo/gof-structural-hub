package com.gof.structuralhub;

import com.gof.structural.adapter.AudioPlayer;
import com.gof.structural.adapter.MediaPlayer;
import com.gof.structural.bridge.AdvancedRemote;
import com.gof.structural.bridge.Radio;
import com.gof.structural.bridge.RemoteControl;
import com.gof.structural.bridge.Tv;
import com.gof.structural.composite.CompositeGraphic;
import com.gof.structural.composite.Shape;
import com.gof.structural.decorator.Coffee;
import com.gof.structural.decorator.MilkDecorator;
import com.gof.structural.decorator.SimpleCoffee;
import com.gof.structural.decorator.SugarDecorator;
import com.gof.structural.facade.OrderFacade;
import com.gof.structural.flyweight.Forest;
import com.gof.structural.proxy.Image;
import com.gof.structural.proxy.ProxyImage;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== GoF Structural Patterns Demo ===\n");

        demoAdapter();
        demoBridge();
        demoDecorator();
        demoComposite();
        demoFacade();
        demoFlyweight();
        demoProxy();
    }

    private static void demoAdapter() {
        System.out.println("[Adapter]");
        MediaPlayer player = new AudioPlayer();
        player.play("mp3", "track-01.mp3");
        player.play("vlc", "movie-01.vlc");
        player.play("mp4", "video-01.mp4");
        player.play("wav", "alert.wav");
        System.out.println();
    }

    private static void demoBridge() {
        System.out.println("[Bridge]");
        RemoteControl tvRemote = new AdvancedRemote(new Tv());
        tvRemote.togglePower();
        tvRemote.volumeUp();
        tvRemote.volumeUp();

        RemoteControl radioRemote = new AdvancedRemote(new Radio());
        radioRemote.togglePower();
        radioRemote.volumeDown();
        ((AdvancedRemote) radioRemote).mute();
        System.out.println();
    }

    private static void demoDecorator() {
        System.out.println("[Decorator]");
        Coffee coffee = new SimpleCoffee();
        System.out.println("Base coffee: " + coffee.getDescription() + " -> $" + coffee.getCost());

        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println("With milk: " + milkCoffee.getDescription() + " -> $" + milkCoffee.getCost());

        Coffee sweetCoffee = new SugarDecorator(milkCoffee);
        System.out.println("With milk + sugar: " + sweetCoffee.getDescription() + " -> $" + sweetCoffee.getCost());
        System.out.println();
    }

    private static void demoComposite() {
        System.out.println("[Composite]");
        CompositeGraphic dashboard = new CompositeGraphic("Dashboard");
        CompositeGraphic leftPanel = new CompositeGraphic("Left Panel");
        CompositeGraphic rightPanel = new CompositeGraphic("Right Panel");

        leftPanel.add(new Shape("Title"));
        leftPanel.add(new Shape("Chart"));

        rightPanel.add(new Shape("Summary"));
        rightPanel.add(new Shape("Stats"));

        dashboard.add(leftPanel);
        dashboard.add(rightPanel);
        dashboard.add(new Shape("Footer"));

        dashboard.draw();
        System.out.println();
    }

    private static void demoFacade() {
        System.out.println("[Facade]");
        OrderFacade orderFacade = new OrderFacade();

        boolean success = orderFacade.placeOrder("SKU-42", 2, "CUST-007", "Avenida Paulista, 1000");
        System.out.println("Pedido realizado com sucesso? " + success);
        System.out.println();
    }

    private static void demoFlyweight() {
        System.out.println("[Flyweight]");
        Forest forest = new Forest();

        forest.plantTree(10, 20, "Oak", "Green", "Smooth");
        forest.plantTree(15, 25, "Oak", "Green", "Smooth");
        forest.plantTree(30, 40, "Pine", "Dark Green", "Rough");
        forest.plantTree(35, 45, "Pine", "Dark Green", "Rough");
        forest.plantTree(90, 70, "Birch", "White", "Fine");

        forest.draw();
        System.out.println("Tipos de árvore na fábrica: " + forest.getTreeTypeCount());
        System.out.println();
    }

    private static void demoProxy() {
        System.out.println("[Proxy]");
        Image image = new ProxyImage("landscape.jpg");
        image.display();
        image.display();
        System.out.println();
    }
}
