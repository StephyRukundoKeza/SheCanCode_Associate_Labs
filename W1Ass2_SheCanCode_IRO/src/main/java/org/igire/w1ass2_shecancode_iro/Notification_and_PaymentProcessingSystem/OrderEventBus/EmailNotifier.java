package org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.OrderEventBus;

public class EmailNotifier implements OrderObserver {

    @Override
    public void onEvent(Order order, OrderEvent event){
        System.out.println("this is an email with "+ order.getId()+ " is for " + event );
    }

    
}
