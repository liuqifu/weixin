package com.forlin.weixin.config;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cwb on 2015/10/7.
 */
public class Java8DateDialect extends AbstractDialect {

    public Java8DateDialect() {
        super();
    }

    @Override
    public String getPrefix() {
        return "hot";
    }

    @Override
    public Set<IProcessor> getProcessors() {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new Java8DateProcesser());
        return processors;
    }
}
