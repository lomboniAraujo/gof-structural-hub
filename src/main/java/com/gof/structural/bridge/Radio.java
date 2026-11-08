package com.gof.structural.bridge;

public class Radio implements Device {
    private boolean enabled;
    private int volume;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void enable() {
        enabled = true;
        System.out.println("Radio enabled.");
    }

    @Override
    public void disable() {
        enabled = false;
        System.out.println("Radio disabled.");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("Radio volume set to " + this.volume + "/100.");
    }
}
