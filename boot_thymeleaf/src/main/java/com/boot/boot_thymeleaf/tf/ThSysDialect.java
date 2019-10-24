package com.boot.boot_thymeleaf.tf;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : kaifa
 * create at:  2019-10-24  16:07
 * @description: 定义方言类
 */
public class ThSysDialect extends AbstractProcessorDialect {
    private static final String PREFIX = "hlvy";
    public ThSysDialect() {
        // 方言名称，前缀，处理优先级
        super("Tf Hlvy", "hlvy", StandardDialect.PROCESSOR_PRECEDENCE);
    }
    @Override
    public Set<IProcessor> getProcessors(String s) {
        // 把所有的自定义tag处理器加入处理器集，这个例子中我们只有这一个自定义处理器
        final Set<IProcessor> processorSet = new HashSet<>();
        ThSysTagProcessor thSysTagProcessor = new ThSysTagProcessor(PREFIX);
        processorSet.add(thSysTagProcessor);
        return processorSet;
    }
}
