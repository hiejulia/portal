package com.baeldung.spring.entity.form;


import lombok.Data;

@Data
public class FeedbackForm {

    // Feedback Form : topicId, name, email, feedback, id
    private Integer topicId ;

    private String name;

    private String email;

    private String feedback;

    private Integer id;
}
