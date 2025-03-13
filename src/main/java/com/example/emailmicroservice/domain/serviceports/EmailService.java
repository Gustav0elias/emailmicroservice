package com.example.emailmicroservice.domain.serviceports;

public interface EmailService {

    public void sendEmail(String to, String subject, String body);
}
