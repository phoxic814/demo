package org.example.excution.order.config;

import org.example.excution.order.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomFilter> loggingFilter(){
        FilterRegistrationBean<CustomFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CustomFilter());
//        registrationBean.addUrlPatterns("/users/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }
}
