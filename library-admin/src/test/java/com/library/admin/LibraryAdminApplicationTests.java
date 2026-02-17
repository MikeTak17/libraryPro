package com.library.admin;

import com.library.common.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LibraryAdminApplicationTests {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        redisUtil.set("name", "圖書管理系統");
        System.out.println(redisUtil.get("name"));
    }
}
