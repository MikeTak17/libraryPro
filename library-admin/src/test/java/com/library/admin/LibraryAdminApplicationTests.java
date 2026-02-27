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
        String content = "測試";
        String title = "郵件發送測試";
        emailUtil.sendFromEmail(userEmail, content, title);
        System.out.println("發送成功");
    }
}
