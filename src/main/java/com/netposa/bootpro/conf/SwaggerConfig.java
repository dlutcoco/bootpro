package com.netposa.bootpro.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("boorpro", "bootpro", "1.0", null, new Contact("fangyuan_xa", "www.netposa.com", "fangyuan_xa@netposa.com"),
                "netposa-licence", "http://www.netposa.com");
    }
}
