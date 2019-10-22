package com.boot.boot_log_aop.mapper;

import com.boot.boot_log_aop.entity.SysLog;

/**
 * @author : kaifa
 * create at:  2019-10-22  17:30
 * @description: log mapper接口
 */
public interface LogMapper {
    /**
     * 切面保存日志
     * @param sysLog
     * @return
     */
    public int saveLog(SysLog sysLog);
}
