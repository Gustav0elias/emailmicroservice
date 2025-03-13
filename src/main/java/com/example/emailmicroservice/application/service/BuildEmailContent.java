package com.example.emailmicroservice.application.service;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.example.emailmicroservice.enums.StatusOrder;
@Component
public class BuildEmailContent {

    private final MessageSource messageSource;

    public BuildEmailContent(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
      public String buildEmailContent(StatusOrder status) {
        return switch (status) {
            case PENDING -> messageSource.getMessage("email.content.pending", null, Locale.getDefault());
            case PROCESSING ->  messageSource.getMessage("email.content.processing", null, Locale.getDefault());
            case COMPLETED -> messageSource.getMessage("email.content.completed", null, Locale.getDefault());
            default ->  messageSource.getMessage("email.content.default", new Object[]{status}, Locale.getDefault());
        };
    }
}
