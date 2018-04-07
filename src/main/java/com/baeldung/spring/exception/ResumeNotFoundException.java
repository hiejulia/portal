package com.baeldung.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Job Applicant Resume Not Found")
public class ResumeNotFoundException extends Exception {

    private static final long serialVersionUID = -3332292346834265371L;

    public ResumeNotFoundException(){
        super("ResumeNotFoundException");
    }
}
