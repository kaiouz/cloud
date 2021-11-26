package io.github.kaiouz.config.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@RefreshScope
public class ConfigService {

    @Value("${config.name}")
    private String name;

    @PostConstruct
    public void init() {
        System.out.println("init: " + name);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy: " + name);
    }

    public String getName() {
        return name;
    }
}
