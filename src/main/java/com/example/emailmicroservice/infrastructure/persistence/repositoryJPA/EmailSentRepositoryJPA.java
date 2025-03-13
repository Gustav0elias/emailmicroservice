package com.example.emailmicroservice.infrastructure.persistence.repositoryJPA;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emailmicroservice.infrastructure.persistence.entity.EmailSentEntity;

public interface EmailSentRepositoryJPA  extends JpaRepository<EmailSentEntity, UUID> {

}
