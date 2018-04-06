package com.baeldung.spring.validator;

import java.util.List;


import com.baeldung.spring.entity.File;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFileValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return File.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors error) {
        File form = (File) obj;
//        MultipartFile files = MultipartFile(form.getName());
        boolean isValid = true;
        StringBuilder sb = new StringBuilder("");
//        for(MultipartFile file:files)
//        {
            if(form.getSize() == 0)
            {
                isValid = false;
                sb.append(form.getName()+" ");
            }
//        }
        if(!isValid)
            error.rejectValue("files","error.file.size",new String[]{sb.toString()},"File size limit exceeded");
    }
}