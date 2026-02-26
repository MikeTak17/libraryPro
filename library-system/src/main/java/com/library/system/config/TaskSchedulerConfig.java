package com.library.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @author: xyh
 * @create: 2023-07-01
 **/
@Configuration
@EnableScheduling
public class TaskSchedulerConfig {
    private final int cpus = Runtime.getRuntime().availableProcessors();

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        // 根据需要进行相关设置
        // 设置线程池大小
        taskScheduler.setPoolSize(cpus);
        // 设置线程名称前缀
        taskScheduler.setThreadNamePrefix("TaskScheduler-");
        taskScheduler.setAwaitTerminationSeconds(60);
        //初始化任务调度器
        taskScheduler.initialize();
        return taskScheduler;
    }

}
