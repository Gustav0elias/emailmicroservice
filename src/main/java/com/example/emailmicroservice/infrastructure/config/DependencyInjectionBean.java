package com.example.emailmicroservice.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.emailmicroservice.application.service.EmailSentServiceImpl;
import com.example.emailmicroservice.domain.repositoryports.EmailSentRepository;
import com.example.emailmicroservice.domain.serviceports.EmailSentService;

@Configuration
public class DependencyInjectionBean {
     @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
 public EmailSentService emailSentService (EmailSentRepository emailSentRepository) {
    return new EmailSentServiceImpl(emailSentRepository);
 }
}
