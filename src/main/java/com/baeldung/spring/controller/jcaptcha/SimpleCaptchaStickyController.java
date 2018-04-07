package com.baeldung.spring.controller.jcaptcha;



import static nl.captcha.Captcha.NAME;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.CaptchaBean;
import nl.captcha.servlet.CaptchaServletUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *  This class generates the SimpleCaptcha images for the client-side validation
 *  SimpleCaptcha Images for the client - side validation
 */

@Controller
public class SimpleCaptchaStickyController{

    // CaptchaBean
    @Autowired
    private CaptchaBean captchaBean;

    // return view
    @RequestMapping("/captcha/simple")
    public String getSimple(){
        return "sc";
    }


    @RequestMapping("/captcha/getSimpleCaptchaImage.bmp")
    public void getSimpleCaptchaImage(HttpServletRequest request,
                                      HttpServletResponse response) throws ServletException, IOException {
    //build
        captchaBean.build();
    // captchaServletUtil.writeImage : response, captchaBean.getImage

        CaptchaServletUtil.writeImage(response, captchaBean.getImage());
        // request . getSession.setAttribute : name
        request.getSession().setAttribute(NAME, captchaBean);
    }



}
