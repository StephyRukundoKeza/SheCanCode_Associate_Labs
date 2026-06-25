package org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.PaymentProcessing;

public class PaymentProcessor {
    private PaymentStrategy strategy;

   public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public PaymentResult executePayment(double amount) {
        return strategy.process(amount);
    } 
}
