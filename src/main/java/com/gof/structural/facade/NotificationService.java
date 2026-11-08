package com.gof.structural.facade;

public class NotificationService {
    public void send(String customerId, String message) {
        System.out.println("Notificação enviada para " + customerId + ": " + message);
    }
}
