package org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.OrderEventBus;

public class AuditLogger implements OrderObserver {

    @Override
    public void onEvent(Order order, OrderEvent event) {
        // Here you would normally write the event to a log file
        System.out.println("Audit Log: Order " + order.getId() + " event recorded: " + event);
    }
}