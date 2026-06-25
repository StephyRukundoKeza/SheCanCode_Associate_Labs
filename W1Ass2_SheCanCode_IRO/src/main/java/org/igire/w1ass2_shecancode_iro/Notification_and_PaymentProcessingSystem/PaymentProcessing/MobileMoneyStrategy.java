package org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.PaymentProcessing;

public class MobileMoneyStrategy implements PaymentStrategy {
    public PaymentResult process(double amount) {
        double total = amount + 3.0;
        return new PaymentResult(true, total, "Paid via Mobile Money Transfer with $5 flat fee.");
    }
}
