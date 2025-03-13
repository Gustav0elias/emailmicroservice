package com.example.emailmicroservice.infrastructure.messaging.listener;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.emailmicroservice.application.dto.EmailSentDTO;
import com.example.emailmicroservice.application.dto.OrderStatusChangeEventDTO;
import com.example.emailmicroservice.application.mapper.EmailSentMapper;
import com.example.emailmicroservice.application.service.BuildEmailContent;
import com.example.emailmicroservice.application.service.EmailServiceImpl;
import com.example.emailmicroservice.domain.serviceports.EmailSentService;
import com.example.emailmicroservice.enums.StatusOrder;
import com.example.emailmicroservice.infrastructure.config.RabbitMqConfig;
import com.example.emailmicroservice.utils.EventValidator;

@Component
public class OrderStatusConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderStatusConsumer.class);
    private final EmailServiceImpl emailService;
    private final BuildEmailContent buildEmailContent;
    private final EventValidator eventValidator;
    private final EmailSentService emailSentService;
    private final EmailSentMapper emailSentMapper;
    private static final String EMAIL_SUBJECT = "Atualização sobre o status do pedido";

    public OrderStatusConsumer(EmailServiceImpl emailService, BuildEmailContent buildEmailContent, EventValidator eventValidator, EmailSentMapper emailSentMapper, EmailSentService emailSentService) {
        this.emailService = emailService;
        this.buildEmailContent = buildEmailContent;
        this.eventValidator = eventValidator;
        this.emailSentMapper = emailSentMapper;
        this.emailSentService = emailSentService;
    }
    @RabbitListener(queues = RabbitMqConfig.ORDER_QUEUE_NAME)
    public void receiveMessage(OrderStatusChangeEventDTO event) {
        logger.info("[CONSUMER] Recebido evento de atualização de status: {}", event);

        try{
        eventValidator.validate(event);
        String emailContent = buildEmailContent.buildEmailContent(event.status());
        emailService.sendEmail(event.email(), EMAIL_SUBJECT, emailContent);
        emailSentService.saveEmail(emailSentMapper.toModel(new EmailSentDTO(EMAIL_SUBJECT, emailContent, event.orderId().toString(), event.email())));      
    
    }
        catch(Exception e){
            logger.error("Erro ao processar mensagem do RabbitMQ", e);
        }
       
      

    }

 
    }

