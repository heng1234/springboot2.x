package com.boot.boot_log_aop.aspect;

import com.boot.boot_log_aop.annotation.Log;
import com.boot.boot_log_aop.entity.SysLog;
import com.boot.boot_log_aop.mapper.LogMapper;
import com.boot.boot_log_aop.util.HttpContextUtils;
import com.boot.boot_log_aop.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author : kaifa
 * create at:  2019-10-22  17:19
 * @description: log 切面
 */
@Component
@Aspect
public class LogAspect {

    @Autowired
    private LogMapper logMapper;

    @Pointcut("@annotation(com.boot.boot_log_aop.annotation.Log)")
    public void pointcut(){

    }

    /**
     * 要有返回值,不然执行的方法返回为空
     * @param point
     * @return
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){

        Object obj = null;
       // Object[] args = point.getArgs();

        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            obj =  point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(point, time);
        return  obj;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            sysLog.setOperation(logAnnotation.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += "  " + paramNames[i] + ": " + args[i];
            }
            sysLog.setParams(params);
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));
        // 模拟一个用户名
        sysLog.setUsername("hlvy");
        sysLog.setTime((int) time);
        Date date = new Date();
        sysLog.setCreateTime(date);
        // 保存系统日志
        logMapper.saveLog(sysLog);
    }
}
