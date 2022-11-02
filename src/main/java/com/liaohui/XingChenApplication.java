package com.liaohui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author liaohui
 * @date 2022/10/30 15:35
 */
@Slf4j
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class XingChenApplication extends WebMvcConfigurerAdapter {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
    public static void main(String[] args) {
        SpringApplication.run(XingChenApplication.class,args);
        log.info("项目启动成功");
    }
}
