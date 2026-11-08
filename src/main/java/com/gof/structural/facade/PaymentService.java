package com.gof.structural.facade;

public class PaymentService {
    public boolean charge(String customerId, double amount) {
        System.out.println("Cobrança aprovada para " + customerId + ": R$" + amount);
        return true;
    }
}
