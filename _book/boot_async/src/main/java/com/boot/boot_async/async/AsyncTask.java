package com.boot.boot_async.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author : kaifa
 * create at:  2019-11-07  09:50
 * @description: 异步类
 * @Async标注为异步方法
 * 如果有返回值需要用Future方式返回
 */
@Component
@Slf4j
public class AsyncTask {
    @Async("asyncThreadPoolTaskExecutor")
    public Future<Boolean> doTask11() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        log.info("异步方法内部线程名称：{}", Thread.currentThread().getName());
        System.out.println("任务1耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }

    @Async("asyncThreadPoolTaskExecutor")
    public Future<Boolean> doTask22() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();
        log.info("异步方法内部线程名称：{}", Thread.currentThread().getName());
        System.out.println("任务2耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }

    @Async("asyncThreadPoolTaskExecutor")
    public Future<Boolean> doTask33() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(600);
        long end = System.currentTimeMillis();
        log.info("异步方法内部线程名称：{}", Thread.currentThread().getName());
        System.out.println("任务3耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }
}
