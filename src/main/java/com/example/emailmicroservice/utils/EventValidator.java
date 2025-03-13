package com.example.emailmicroservice.utils;

import org.springframework.stereotype.Component;

import com.example.emailmicroservice.application.dto.OrderStatusChangeEventDTO;

@Component
public class EventValidator {
   public void validate(OrderStatusChangeEventDTO event) {
        if (event.status() == null) {
            throw new IllegalArgumentException("Status do pedido não pode ser nulo.");
        }

        if (event.email() == null || event.email().isBlank()) {
            throw new IllegalArgumentException("E-mail do usuário não pode ser nulo ou vazio.");
        }
    }
}
