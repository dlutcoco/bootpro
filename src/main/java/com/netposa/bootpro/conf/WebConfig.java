package com.netposa.bootpro.conf;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
