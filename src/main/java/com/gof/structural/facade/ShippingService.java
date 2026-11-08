package com.gof.structural.facade;

public class ShippingService {
    public void scheduleDelivery(String customerId, String address, int quantity) {
        System.out.println("Entrega agendada para " + customerId + " em " + address + ", quantidade: " + quantity);
    }
}
