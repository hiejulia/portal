package com.baeldung.spring.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalHandlerExceptionResolver {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String resolveException(Exception exception, Model model) {
        exception.printStackTrace();
//		System.out.println(exception.getMessage());
//		System.out.println(Arrays.toString(exception.getStackTrace()));
        return "404";
    }
}