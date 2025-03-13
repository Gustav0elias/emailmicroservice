package com.example.emailmicroservice.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class EmailSent {
    private UUID id;
    private String subject;
    private String content;
    private String orderId;
    private String recipientEmail;
    private LocalDateTime sentAt;

public EmailSent() {
    
}
public EmailSent(UUID id, String subject, String content, String orderId, String recipientEmail ) {
    this.id = id;
    this.subject = subject;
    this.content = content;
    this.orderId = orderId;
    this.recipientEmail = recipientEmail;
    this.sentAt = LocalDateTime.now();
}
public UUID getId() {
    return id;
}
public void setId(UUID id) {
    this.id = id;
}
public String getSubject() {
    return subject;
}
public void setSubject(String subject) {
    this.subject = subject;
}
public String getContent() {
    return content;
}
public void setContent(String content) {
    this.content = content;
}
public String getOrderId() {
    return orderId;
}
public void setOrderId(String orderId) {
    this.orderId = orderId;
}
public String getRecipientEmail() {
    return recipientEmail;
}
public void setRecipientEmail(String recipientEmail) {
    this.recipientEmail = recipientEmail;
}
 
 

}
