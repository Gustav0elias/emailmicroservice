package com.example.emailmicroservice.domain.repositoryports;

import com.example.emailmicroservice.domain.model.EmailSent;

public interface EmailSentRepository {
       public EmailSent saveEmail (EmailSent emailSent);
}
