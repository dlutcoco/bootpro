package com.netposa.bootpro.conf;

import javax.validation.Validator;

import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class WebConfig {

    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean servlet = new ServletRegistrationBean(statViewServlet);
        servlet.addInitParameter("resetEnable", "true");
//        servlet.addInitParameter("loginUsername", "druid");
//        servlet.addInitParameter("loginPassword", "druid");
        servlet.addUrlMappings("/druid/*");
        
        return servlet;
    }

    @Bean
    public Validator jsr303Validator(MessageSource messageSource) {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
        factoryBean.setValidationMessageSource(messageSource);
        return factoryBean;
    }
}
