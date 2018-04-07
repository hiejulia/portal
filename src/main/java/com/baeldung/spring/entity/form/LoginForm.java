package com.baeldung.spring.entity.form;


import lombok.Data;

@Data
public class LoginForm {
    private String username;
    private String password;
}
