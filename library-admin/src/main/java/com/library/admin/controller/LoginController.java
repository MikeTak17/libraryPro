package com.library.admin.controller;

import com.library.common.constant.CacheTimeConstant;
import com.library.common.constant.RedisKeyConstant;
import com.library.common.constant.VerificationCode;
import com.library.common.response.Result;
import com.library.common.util.FileUtils;
import com.library.common.util.RedisUtil;
import com.wf.captcha.SpecCaptcha;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("web")
public class LoginController {
    @Resource
    private RedisUtil redisUtil;
    /**
     * 獲取帳號登入驗證碼
     *
     * @params
     * @return
     * @throws IOException
     */
    @GetMapping("/captcha")
    public Result getVerifyCode() throws IOException, FontFormatException{
        // 將請求標頭設置為輸出圖片類型
        VerificationCode code = new VerificationCode();
        SpecCaptcha specCaptcha = code.createVerificationCode();
        String captchaCode = code.getCaptchaCode();
        // 建立位元組陣列輸出串流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 将验证码图片输出到字节数组输出流中
        specCaptcha.out(baos);
        // 将字节数组转换为 Base64 编码
        byte[] imageBytes = baos.toByteArray();
        String base64String = FileUtils.getBase64String(imageBytes);
        redisUtil.set(RedisKeyConstant.LOGIN_VERIFY_CODE + captchaCode, captchaCode, CacheTimeConstant.verifyCodeTime, TimeUnit.MINUTES);
        return Result.success("", base64String);
    }

}
