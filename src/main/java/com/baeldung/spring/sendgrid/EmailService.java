package com.baeldung.spring.sendgrid;


import com.baeldung.spring.entity.form.EmailFeedback;

public interface EmailService {

    // Send email with Sendgrid API
    public boolean send(EmailFeedback message);

}