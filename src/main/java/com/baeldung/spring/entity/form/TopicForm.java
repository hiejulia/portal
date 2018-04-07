package com.baeldung.spring.entity.form;


import com.baeldung.spring.botcaptcha.BotModel;
import lombok.Data;

@Data
public class TopicForm {

    // TopicForm: id, title, description, botModel


    private Integer id;

    private String title;

    private String description;

    private BotModel botModel;


}
