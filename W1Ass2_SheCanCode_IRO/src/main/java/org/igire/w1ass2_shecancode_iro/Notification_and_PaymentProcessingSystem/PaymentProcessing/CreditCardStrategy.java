package org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.PaymentProcessing;

public class CreditCardStrategy implements PaymentStrategy{

    public PaymentResult process (double amount) {
        double total = amount * 1.02;
        return new PaymentResult(true, total, "Paid via Credit Card with 2% fee.");
    }

}
