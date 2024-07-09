package org.hse.med.frontend.factory;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;

public class RestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean {

    private RestTemplate restTemplate;

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public RestTemplate getObject() throws Exception {
        return restTemplate;
    }

    @Override
    public Class<?> getObjectType() {
        return RestTemplate.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    }
}
