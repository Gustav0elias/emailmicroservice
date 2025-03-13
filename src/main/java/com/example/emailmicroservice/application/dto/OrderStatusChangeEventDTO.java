package com.example.emailmicroservice.application.dto;

import java.util.UUID;

import com.example.emailmicroservice.enums.StatusOrder;

public record OrderStatusChangeEventDTO(UUID orderId, StatusOrder status, String email) {

}
