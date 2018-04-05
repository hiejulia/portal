package com.baeldung.spring.event;


import com.baeldung.spring.entity.JobSeeker;
import org.springframework.context.ApplicationEvent;
import sun.print.SunPrinterJobService;


public class OnPasswordResetEvent extends ApplicationEvent {

    private static final long serialVersionUID = -2205810103730939310L;

    private JobSeeker user;
    private String url;

    public OnPasswordResetEvent(JobSeeker user,
                                String url) {
        super(user);
        this.user = user;
        this.url = url;
    }

    public JobSeeker getUser() {
        return user;
    }

    public void setUser(JobSeeker user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getConfirmUrl() {
        String token = user.getVerificationCode()+"";
        return url + "/" + token;
    }

}