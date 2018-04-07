package com.baeldung.spring.validator;

import com.baeldung.spring.entity.form.LoginForm;
import org.springframework.validation.Errors;

import javax.validation.Validator;

public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return LoginForm.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        LoginForm loginForm = (LoginForm) obj;

        if(loginForm.getUsername().length() == 0 || loginForm.getUsername() == null){
            errors.rejectValue("username", "error.login.username");
        }

        if(loginForm.getPassword().length() == 0 || loginForm.getPassword() == null || loginForm.getPassword().length()<6){
            errors.rejectValue("password", "error.login.password");
        }
    }
}
