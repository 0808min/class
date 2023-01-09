package com.app.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class Auditing {

    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }


}
