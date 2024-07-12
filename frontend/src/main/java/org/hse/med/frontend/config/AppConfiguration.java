package org.hse.med.frontend.config;

import org.hse.med.frontend.factory.RestTemplateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public RestTemplateFactory restTemplateFactory() {
        return new RestTemplateFactory();
    }
}
