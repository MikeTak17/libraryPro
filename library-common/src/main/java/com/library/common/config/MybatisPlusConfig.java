package com.library.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    /*增加分頁外掛程式*/
    @Bean
    /*用來註冊 MyBatis-Plus 的核心攔截器，沒有的話分頁與進階功能全部不會生效*/
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //MybatisPlusInterceptor物件，內置分頁攔截器與樂觀鎖攔截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        //MybatisPlus提供的分頁外掛程式，用於處理分頁邏輯查詢
        PaginationInnerInterceptor innerInterceptor = new PaginationInnerInterceptor();

        innerInterceptor.setDbType(DbType.MYSQL);

        //啟用溢位處理
        innerInterceptor.setOverflow(true);

        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        interceptor.addInnerInterceptor(innerInterceptor);
        return interceptor;
    }
}