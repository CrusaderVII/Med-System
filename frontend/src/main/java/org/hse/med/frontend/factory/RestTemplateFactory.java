package org.hse.med.frontend.factory;


import lombok.RequiredArgsConstructor;
import org.hse.med.frontend.controller.advice.RestTemplateExceptionHandler;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class RestTemplateFactory implements FactoryBean<RestTemplate> {

    private final RestTemplateBuilder restTemplateBuilder;
    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public RestTemplate getObject() {
        RestTemplate restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateExceptionHandler())
                .build();

        return restTemplate;
    }

    @Override
    public Class<?> getObjectType() {
        return RestTemplate.class;
    }

}
