package com.example.springbootprojectjdo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

@Configuration
public class WebConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> studentServlet() {
        ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
        servRegBean.setServlet(new StudentServlet());
        servRegBean.addUrlMappings("/");
        servRegBean.setLoadOnStartup(1);
        return servRegBean;
    }
}
