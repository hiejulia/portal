package com.baeldung.spring.validator;

import com.baeldung.spring.entity.JobPosting;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



import org.springframework.validation.ValidationUtils;

// JobPosting validator implements Validator
public class JobPostingValidator implements Validator {

    // support
    public boolean supports(Class aClass)
    {
        return aClass.equals(JobPosting.class);
    }

    // validate
    public void validate(Object obj, Errors errors)
    {
        JobPosting jobPosting = (JobPosting)obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobLocation", "error.invalid.jobs", "Location Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobDescription", "error.invalid.jobs", "Job Description Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle", "error.invalid.jobs", "Job Title Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "error.invalid.jobs", "Salary is Required");


    }
}
