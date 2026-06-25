package org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.PaymentProcessing;

public interface PaymentStrategy {
    PaymentResult process( double amount);
}
