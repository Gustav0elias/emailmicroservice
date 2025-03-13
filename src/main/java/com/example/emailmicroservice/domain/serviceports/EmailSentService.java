package com.example.emailmicroservice.domain.serviceports;

import com.example.emailmicroservice.domain.model.EmailSent;

public interface EmailSentService {

    public EmailSent saveEmail (EmailSent emailSent);
}
