package org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.OrderEventBus;

public interface OrderObserver {
    void onEvent(Order order, OrderEvent event);
    
}
