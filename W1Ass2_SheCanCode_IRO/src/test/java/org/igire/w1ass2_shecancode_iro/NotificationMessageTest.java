package org.igire.w1ass2_shecancode_iro;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.NotificationMessage.NotificationMessage;
import org.junit.jupiter.api.Test;

public class NotificationMessageTest {

    
    @Test
    void testValidConstruction() {
        NotificationMessage msg = new NotificationMessage.Builder()
                .to("user@example.com")
                .subject("Hello")
                .body("Content")
                .priority(NotificationMessage.Priority.HIGH)
                .build();
                
        assertNotNull(msg);
    }

    @Test
    void testMissingRecipientThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            new NotificationMessage.Builder().body("Hello").build();
        });
    }

    @Test
    void testMissingBodyThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            new NotificationMessage.Builder().to("user@example.com").build();
        });
    }
}
