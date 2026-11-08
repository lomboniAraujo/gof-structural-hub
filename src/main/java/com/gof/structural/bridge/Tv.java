package com.gof.structural.bridge;

public class Tv implements Device {
    private boolean enabled;
    private int volume;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
        System.out.println("TV enabled.");
    }

    @Override
    public void disable() {
        enabled = false;
        System.out.println("TV disabled.");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("TV volume set to " + this.volume + "/100.");
    }
}
