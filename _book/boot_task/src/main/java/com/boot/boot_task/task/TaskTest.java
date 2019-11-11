package com.boot.boot_task.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : kaifa
 * create at:  2019-11-08  14:26
 * @description: 定时任务
 */

@Component
public class TaskTest {
    // 定义每过10秒执行任务
   // @Scheduled(fixedRate = 10000)
    @Scheduled(cron = "10 * * * * ?")
    public void Task1() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Task1当前线程名称:"+Thread.currentThread().getName()+"现在时间：" + dateFormat.format(new Date()));
    }

    // 定义每过10秒执行任务
    @Scheduled(cron = "10 * * * * ?")
    public void Task2() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Task2当前线程名称:"+Thread.currentThread().getName() +"现在时间："+ dateFormat.format(new Date()));
    }


}
