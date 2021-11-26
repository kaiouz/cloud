package io.github.kaiouz.cloud;

import org.springframework.beans.factory.FactoryBean;

public class TestBean implements FactoryBean<String> {

    @Override
    public String getObject() throws Exception {
        return "ddddddd";
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }
}
