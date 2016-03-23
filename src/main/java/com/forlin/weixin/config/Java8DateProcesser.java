package com.forlin.weixin.config;

import org.thymeleaf.Arguments;
import org.thymeleaf.Configuration;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor;
import org.thymeleaf.standard.expression.IStandardExpression;
import org.thymeleaf.standard.expression.IStandardExpressionParser;
import org.thymeleaf.standard.expression.StandardExpressions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by cwb on 2015/10/7.
 */
public class Java8DateProcesser extends AbstractTextChildModifierAttrProcessor {

    public Java8DateProcesser() {
        super("date");
    }

    @Override
    protected String getText(Arguments arguments, Element element, String s) {

        Configuration configuration = arguments.getConfiguration();

        IStandardExpressionParser parser =
                StandardExpressions.getExpressionParser(configuration);

        String attributeValue = element.getAttributeValue(s);

        IStandardExpression expression =
                parser.parseExpression(configuration, arguments, attributeValue);

        Object java8Date = expression.execute(configuration,arguments);

        if(java8Date instanceof LocalDateTime) {
            return ((LocalDateTime) java8Date).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        if(java8Date instanceof LocalDate) {
            return ((LocalDate) java8Date).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if(java8Date instanceof LocalTime) {
            return ((LocalTime) java8Date).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
        if(java8Date instanceof Date){
            return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(((Date) java8Date));
        }
        return null;
//        LocalDateTime java8Date = (LocalDateTime)expression.execute(configuration, arguments);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        return java8Date == null ? null: java8Date.format(formatter);
    }

    @Override
    public int getPrecedence() {
        return 10000;
    }
}
