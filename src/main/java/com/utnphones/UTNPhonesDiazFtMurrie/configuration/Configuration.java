package com.utnphones.UTNPhonesDiazFtMurrie.configuration;

import com.utnphones.UTNPhonesDiazFtMurrie.session.BackofficeSessionFilter;
import com.utnphones.UTNPhonesDiazFtMurrie.session.InfrastructureSessionFilter;
import com.utnphones.UTNPhonesDiazFtMurrie.session.SessionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@org.springframework.context.annotation.Configuration
@EnableScheduling
public class Configuration {
    //region Properties:
    @Autowired
    SessionFilter sessionFilter;

    @Autowired
    BackofficeSessionFilter backofficeSessionFilter;

    @Autowired
    InfrastructureSessionFilter infrastructureSessionFilter;
    //endregion

    //region Methods:
    @Bean
    public FilterRegistrationBean myApiFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter);
        registration.addUrlPatterns("/api/client/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean myBackofficeFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(backofficeSessionFilter);
        registration.addUrlPatterns("/api/backoffice/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean myInfrastructureFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(infrastructureSessionFilter);
        registration.addUrlPatterns("/api/infrastructure/*");
        return registration;
    }
    //endregion
}
