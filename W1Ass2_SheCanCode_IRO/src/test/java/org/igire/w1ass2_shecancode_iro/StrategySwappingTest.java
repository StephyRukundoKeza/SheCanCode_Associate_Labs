package org.igire.w1ass2_shecancode_iro;

import org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.PaymentProcessing.BankTransferStrategy;
import org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.PaymentProcessing.CreditCardStrategy;
import org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.PaymentProcessing.PaymentProcessor;
import org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.PaymentProcessing.PaymentResult;
import org.junit.jupiter.api.Test;

public class StrategySwappingTest {

    @Test
    void testStrategySwapping() {
        PaymentProcessor processor = new PaymentProcessor();

        // 1. Pay with Credit Card
        processor.setStrategy(new CreditCardStrategy());
        PaymentResult res1 = processor.executePayment(100.0);
        System.out.println(res1.message()); // Should show 2% fee

        // 2. Switch to Bank Transfer at runtime
        processor.setStrategy(new BankTransferStrategy());
        PaymentResult res2 = processor.executePayment(100.0);
        System.out.println(res2.message());

    }

}
