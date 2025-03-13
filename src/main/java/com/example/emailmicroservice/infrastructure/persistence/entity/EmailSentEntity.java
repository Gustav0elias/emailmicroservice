package com.example.emailmicroservice.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sent_emails")
public class EmailSentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @Column(name = "recipient_email", nullable = false)
    private String recipientEmail;

    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;


    public EmailSentEntity() {
    }
 

    public EmailSentEntity(String subject, String content, String orderId, String recipientEmail) {
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


    public LocalDateTime getSentAt() {
        return sentAt;
    }


    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }


 

}
