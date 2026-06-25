package org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.OrderEventBus;

public class InventoryUpdater implements OrderObserver {

    @Override
    public void onEvent(Order order, OrderEvent event) {

        System.out.println("Inventory Updated: Processing stock change for Order " + order.getId() + " due to " + event);
    }
}
