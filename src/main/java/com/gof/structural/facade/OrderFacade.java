package com.gof.structural.facade;

public class OrderFacade {
    private final InventoryService inventoryService = new InventoryService();
    private final PaymentService paymentService = new PaymentService();
    private final ShippingService shippingService = new ShippingService();
    private final NotificationService notificationService = new NotificationService();

    public boolean placeOrder(String sku, int quantity, String customerId, String address) {
        if (!inventoryService.isAvailable(sku, quantity)) {
            System.out.println("Produto indisponível no momento.");
            return false;
        }

        double total = calculateTotal(quantity);
        if (!paymentService.charge(customerId, total)) {
            System.out.println("Pagamento falhou.");
            return false;
        }

        inventoryService.reserve(sku, quantity);
        shippingService.scheduleDelivery(customerId, address, quantity);
        notificationService.send(customerId, "Pedido confirmado: " + sku);
        return true;
    }

    private double calculateTotal(int quantity) {
        return quantity * 59.90;
    }
}
