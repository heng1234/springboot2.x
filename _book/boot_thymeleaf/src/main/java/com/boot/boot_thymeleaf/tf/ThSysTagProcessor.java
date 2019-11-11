package com.boot.boot_thymeleaf.tf;

import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : kaifa
 * create at:  2019-10-24  15:53
 * @description: 自定义tf标签配置类
 */
public class ThSysTagProcessor  extends AbstractAttributeTagProcessor {
    private static final String TEXT_ATTRIBUTE  = "text";
    private static final int PRECEDENCE = 10000;
    private static final String PATTERN_ATTRIBUTE = "pattern";

    private static final String DEFAULT_PATTERN = "^.{2}(.*).{2}$";
    /**
        templateMode: 模板模式，这里使用HTML模板。
         dialectPrefix: 标签前缀。即xxx:text中的xxx。在此例子中prefix为thSys。
         elementName：匹配标签元素名。举例来说如果是div，则我们的自定义标签只能用在div标签中。为null能够匹配所有的标签。
         prefixElementName: 标签名是否要求前缀。
         attributeName: 自定义标签属性名。这里为text。
         prefixAttributeName：属性名是否要求前缀，如果为true，Thymeeleaf会要求使用text属性时必须加上前缀，即thSys:text。
         precedence：标签处理的优先级，此处使用和Thymeleaf标准方言相同的优先级。
         removeAttribute：标签处理后是否移除自定义属性。*/
    public ThSysTagProcessor( String dialectPrefix) {
        // 方言名称，前缀，处理优先级
        super(TemplateMode.HTML, dialectPrefix, null, false, TEXT_ATTRIBUTE, true, PRECEDENCE, true);
    }

    @Override
    protected void doProcess(ITemplateContext iTemplateContext, IProcessableElementTag iProcessableElementTag, AttributeName attributeName, String s, IElementTagStructureHandler iElementTagStructureHandler) {
        //s为自定义属性text的内容，如果s为表达式，该函数可以获取表达式的值
        final Object value = getExpressionValue(iTemplateContext, s);

        IAttribute patternAttribute = iProcessableElementTag.getAttribute(PATTERN_ATTRIBUTE);
        if (null == patternAttribute) {
            // 设置标签的内容
            iElementTagStructureHandler.setBody(doMasking(value.toString(), DEFAULT_PATTERN), false);
        } else {
            String patternValue = iProcessableElementTag.getAttribute(PATTERN_ATTRIBUTE).getValue();
            iElementTagStructureHandler.setBody(doMasking(value.toString(), patternValue), false);
        }
    }

    private static String doMasking(String target, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(target);
        if (matcher.matches()) {
            if (matcher.groupCount() < 1) {
                return target;
            }
            String group = matcher.group(1);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < group.length(); i++) {
                stringBuilder.append("*");
            }
            return target.replace(group, stringBuilder.toString());
        }
        return target;
    }

    private Object getExpressionValue(ITemplateContext iTemplateContext, String expressionString) {
        final IEngineConfiguration configuration = iTemplateContext.getConfiguration();
        final IStandardExpressionParser parser = StandardExpressions.getExpressionParser(configuration);
        // 解析expression
        final IStandardExpression expression = parser.parseExpression(iTemplateContext, expressionString);
        // 获取expression的执行结果
        return expression.execute(iTemplateContext);
    }
}
