package io.github.kaiouz.cloud;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@Configuration(proxyBeanMethods = false)
public class Config {

    @Bean
    public TestBeanPostProcessor testBeanPostProcessor(Environment environment) {
        return new TestBeanPostProcessor();
    }

    public static class TestBeanPostProcessor implements BeanPostProcessor {

    }

}
