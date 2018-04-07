package com.baeldung.spring.botcaptcha;


 // This is pojo model for the botcaptcha integration
// This captures all the form data from the view
public class BotModel {
    private String userCaptchaCode, captchaCodeCorrect, captchaCodeIncorrect;

    public String getCaptchaCodeTextBox() {
        return userCaptchaCode;
    }

    public void setCaptchaCodeTextBox(String userCaptchaCode) {
        this.userCaptchaCode = userCaptchaCode;
    }

    public String getCaptchaCodeCorrect() {
        return captchaCodeCorrect;
    }

    public void setCaptchaCodeCorrect(String captchaCodeCorrect) {
        this.captchaCodeCorrect = captchaCodeCorrect;
    }

    public String getCaptchaCodeIncorrect() {
        return captchaCodeIncorrect;
    }

    public void setCaptchaCodeIncorrect(String captchaCodeIncorrect) {
        this.captchaCodeIncorrect = captchaCodeIncorrect;
    }

}