package com.utnphones.UTNPhonesDiazFtMurrie.configuration;

import com.utnphones.UTNPhonesDiazFtMurrie.session.BackofficeSessionFilter;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@org.springframework.context.annotation.Configuration
@EnableScheduling
public class Configuration {

    @Autowired
    SessionFilter sessionFilter;

    @Autowired
    BackofficeSessionFilter backofficeSessionFilter;

    @Bean
    public FilterRegistrationBean myApiFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter);
        registration.addUrlPatterns("/api/user/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean myBackofficeFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(backofficeSessionFilter);
        registration.addUrlPatterns("/api/backoffice/*");
        return registration;
    }

}
