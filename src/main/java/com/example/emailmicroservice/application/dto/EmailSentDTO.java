package com.example.emailmicroservice.application.dto;

import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

public record EmailSentDTO (
    String subject, String content, String orderId, String recipientEmail 
) {

}
