package com.example.emailmicroservice.application.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.emailmicroservice.application.dto.EmailSentDTO;
import com.example.emailmicroservice.domain.model.EmailSent;
@Component
public class EmailSentMapper {
    public EmailSent toModel(EmailSentDTO emailSentDTO) {
        EmailSent emailSent = new EmailSent();
        emailSent.setSubject(emailSentDTO.subject());
        emailSent.setContent(emailSentDTO.content());
        emailSent.setOrderId(emailSentDTO.orderId());
        emailSent.setRecipientEmail(emailSentDTO.recipientEmail());
       
        return emailSent;
    }
}