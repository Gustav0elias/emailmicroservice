package com.example.emailmicroservice.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.emailmicroservice.domain.model.EmailSent;
import com.example.emailmicroservice.domain.repositoryports.EmailSentRepository;
import com.example.emailmicroservice.domain.serviceports.EmailSentService;
import com.example.emailmicroservice.infrastructure.messaging.listener.OrderStatusConsumer;

public class EmailSentServiceImpl implements EmailSentService {
    private static final Logger logger = LoggerFactory.getLogger(OrderStatusConsumer.class);

    private final EmailSentRepository emailSentRepository;
    public EmailSentServiceImpl(EmailSentRepository emailSentRepository) {
        this.emailSentRepository = emailSentRepository;
    }

    @Override
    public EmailSent saveEmail(EmailSent emailSent) {
        logger.info("EmailSent dentro do service  {}", emailSent.toString());
    return  emailSentRepository.saveEmail(emailSent);
      
    }

}
