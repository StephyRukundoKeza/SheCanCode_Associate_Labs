package org.igire.w1ass2_shecancode_iro.Notification_and_PaymentProcessingSystem.NotificationMessage;

import java.util.ArrayList;
import java.util.List;

public class NotificationMessage {

    public enum Priority {LOW, MEDIUM, HIGH}

    private final String recipient;
    private final String subject;
    private final String body;
    private final Priority priority;
    private List<String> attachments;

    public NotificationMessage (Builder builder) {
        this.recipient = builder.recipient;
        this.subject = builder.subject;
        this.body = builder.body;
        this.priority = builder.priority;
        this.attachments = builder.attachments;
    }

    public static class Builder {
        private String recipient;
        private String subject;
        private String body;
        private Priority priority = Priority.MEDIUM; // Default value
        private List<String> attachments = new ArrayList<>();

        public Builder to(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder priority(Priority priority) {
            this.priority = priority;
            return this;
        }

        public Builder attach(String attachment) {
            this.attachments.add(attachment);
            return this;
        }

        public NotificationMessage build(){
            if (subject == null || subject.isEmpty()){
                throw new IllegalStateException ("Subject is missing");
            }

            if (body == null || body.isEmpty()) {
                throw new IllegalStateException("Body cannot be empty");
            }
            
            return new NotificationMessage(this);
        }

    }

    
}

