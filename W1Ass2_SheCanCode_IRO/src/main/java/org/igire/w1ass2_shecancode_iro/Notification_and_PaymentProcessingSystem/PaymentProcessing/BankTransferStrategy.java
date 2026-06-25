package org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.PaymentProcessing;

public class BankTransferStrategy implements PaymentStrategy {
    public PaymentResult process(double amount) {
        double total = amount + 5.0;
        return new PaymentResult(true, total, "Paid via Bank Transfer with $5 flat fee.");
    }
}
