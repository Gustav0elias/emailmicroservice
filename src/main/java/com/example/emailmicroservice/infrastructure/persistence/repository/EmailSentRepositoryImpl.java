package com.example.emailmicroservice.infrastructure.persistence.repository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.emailmicroservice.domain.model.EmailSent;
import com.example.emailmicroservice.domain.repositoryports.EmailSentRepository;
import com.example.emailmicroservice.infrastructure.messaging.listener.OrderStatusConsumer;
import com.example.emailmicroservice.infrastructure.persistence.entity.EmailSentEntity;
import com.example.emailmicroservice.infrastructure.persistence.repositoryJPA.EmailSentRepositoryJPA;

@Component
public class EmailSentRepositoryImpl implements EmailSentRepository {
    private static final Logger logger = LoggerFactory.getLogger(OrderStatusConsumer.class);
    private final EmailSentRepositoryJPA emailSentRepositoryJPA;
    private final ModelMapper modelMapper;

    public EmailSentRepositoryImpl(EmailSentRepositoryJPA emailSentRepositoryJPA,ModelMapper modelMapper )  {
        this.emailSentRepositoryJPA = emailSentRepositoryJPA;
        this.modelMapper = modelMapper;
    }
    @Override
    public EmailSent saveEmail(EmailSent emailSent) {
        logger.info("EmailSent recebido: {}", emailSent.toString()); // Log para verificar o objeto recebido
    
        EmailSentEntity emailSentEntity = modelMapper.map(emailSent, EmailSentEntity.class);
        logger.info("EmailSentEntity mapeado: {}", emailSentEntity.toString()); // Log para verificar os valores
    
        emailSentRepositoryJPA.save(emailSentEntity);
        return modelMapper.map(emailSentEntity, EmailSent.class);
    }

}
