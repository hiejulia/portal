package com.baeldung.spring.validator;


import com.baeldung.spring.entity.JobSeeker;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;




import org.springframework.validation.ValidationUtils;

public class JobSeekerValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(JobSeeker.class);
    }

    public void validate(Object obj, Errors errors)
    {
        JobSeeker jobSeeker = (JobSeeker) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.jobSeeker", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.jobSeeker", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.jobSeeker", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.jobSeeker", "Password is Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNo", "error.invalid.jobSeeker", "Phone Number Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.jobSeeker", "Email Id Required");


    }
}
