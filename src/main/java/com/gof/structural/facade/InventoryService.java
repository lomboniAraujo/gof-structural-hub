package com.gof.structural.facade;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    public InventoryService() {
        stock.put("SKU-42", 10);
        stock.put("SKU-99", 5);
    }

    public boolean isAvailable(String sku, int quantity) {
        Integer available = stock.get(sku);
        return available != null && available >= quantity;
    }

    public void reserve(String sku, int quantity) {
        stock.computeIfPresent(sku, (key, current) -> current - quantity);
        System.out.println("Reserva confirmada: " + sku + " x" + quantity);
    }
}
