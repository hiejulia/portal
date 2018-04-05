package com.baeldung.spring.listener;



import com.baeldung.spring.dao.impl.JobSeekerDaoImpl;
import com.baeldung.spring.entity.JobSeeker;
import com.baeldung.spring.event.OnPasswordResetEvent;
import com.baeldung.spring.mail.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;



@Component
public class ResetPasswordListener implements ApplicationListener<OnPasswordResetEvent> {



    @Autowired
    private JobSeekerDaoImpl jobSeekerDao;

    @Autowired
    private EmailServiceImpl emailService;

    @Value("${email.username}")
    private String from;

    @Override
    public void onApplicationEvent(OnPasswordResetEvent event) {

        try {
//            userService.resetUser(event.getUser());
            // reset the user
        } catch (Exception e) {
            e.printStackTrace();
        }

        String confirmUrl = event.getConfirmUrl();

//        emailService.sendSimpleMessage(from, event.getUser().getEmailId(), "noreply",
//                "Please follow the link to set new password " + confirmUrl);
        emailService.sendSimpleMessage(event.getUser().getEmailId(),"Reset password","Please follow the link to set new password " + confirmUrl);

    }

}