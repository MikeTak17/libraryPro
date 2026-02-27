package com.library.common.constant;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;

import java.awt.*;
import java.io.IOException;

public class VerificationCode {
    private int width = 100;

    private int height = 30;

    private int digit = 4;

    private String captchaCode;

    public SpecCaptcha createVerificationCode() throws IOException, FontFormatException{
        SpecCaptcha specCaptcha = new SpecCaptcha(width, height, digit);
        specCaptcha.setFont(Captcha.FONT_9);
        specCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);
        this.captchaCode = specCaptcha.text().toLowerCase();
        return specCaptcha;
    }

    public String getCaptchaCode(){
        return captchaCode;
    }
}
