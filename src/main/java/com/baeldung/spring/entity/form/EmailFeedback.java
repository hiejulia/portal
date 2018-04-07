package com.baeldung.spring.entity.form;


import lombok.Data;

import java.io.Serializable;

@Data
public class EmailFeedback implements Serializable {

    private String senderName;

    private String senderEmail;

    private String ccEmail;

    private String subject;

    private String body;

    private String receiverName;

    private String receiverEmail;
}
