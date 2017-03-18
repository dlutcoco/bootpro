package com.netposa.bootpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;

import com.netposa.bootpro.conf.AppProperties;
import com.netposa.bootpro.conf.DruidProperties;
import com.netposa.bootpro.service.DataService;

@SpringBootApplication
@EnableConfigurationProperties(value = {AppProperties.class, DruidProperties.class})
@MapperScan(basePackages = {"com.netposa"})
public class BootproApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootproApplication.class, args);
	}
	
	@Bean
    public ApplicationListener<ContextRefreshedEvent> applicationListener() {
        return new ApplicationListener<ContextRefreshedEvent>() {
            @Override
            public void onApplicationEvent(ContextRefreshedEvent event) {
                DataService dataService = event.getApplicationContext().getBean(DataService.class);
                dataService.build();
            }
        };
    }
}
