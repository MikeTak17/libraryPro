package com.library.admin;

import com.library.system.util.EmailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LibraryAdminApplicationTests {
    @Autowired
    private EmailUtil emailUtil;

    @Test
    void mailTest() {
        String userEmail = "shentai40@gmail.com";
        String content = "您好親";
        String title = "我是你爹";
        emailUtil.sendFromEmail(userEmail, content, title);
        System.out.println("發送成功");
    }
}
