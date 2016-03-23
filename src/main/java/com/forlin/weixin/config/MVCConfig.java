package com.forlin.weixin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.Arrays;
import java.util.List;

/**
 * Created by forlin on 2016/2/27.
 */
@Configuration
@EnableWebMvc
@EnableScheduling
@EnableTransactionManagement
@ComponentScan({
        "com.forlin.weixin.controller"
})
public class MVCConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;

    /**
     * for upload
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        converters.add(converter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
        registry.viewResolver(viewResolver());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    }

    public ThymeleafViewResolver viewResolver() {

        ServletContextTemplateResolver rootTemplateResolver = new ServletContextTemplateResolver();
        rootTemplateResolver.setPrefix("/");
        rootTemplateResolver.setSuffix(".html");
        rootTemplateResolver.setTemplateMode("HTML5");
        rootTemplateResolver.setCharacterEncoding("UTF-8");
        if(env.acceptsProfiles("!container")){
            rootTemplateResolver.setCacheable(false);
        }else{
            rootTemplateResolver.setCacheable(true);
        }

        SpringTemplateEngine engine = new SpringTemplateEngine();
        //engine.addDialect(new SpringSecurityDialect());
        engine.addDialect(new Java8TimeDialect());
        engine.addDialect(new Java8DateDialect());
        engine.setTemplateResolver(rootTemplateResolver);

        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setOrder(1);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateEngine(engine);

        return resolver;
    }

}
