package org.unlogged.demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegistration {
    @Bean
    public FilterRegistrationBean<FutureFilter> loggingFilter() {
        FilterRegistrationBean<FutureFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new FutureFilter());
        registrationBean.addUrlPatterns("/future/*");
        registrationBean.setOrder(1);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<FutureFilter2> loggingFilter2() {
        FilterRegistrationBean<FutureFilter2> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new FutureFilter2());
        registrationBean.addUrlPatterns("/future/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }
}
