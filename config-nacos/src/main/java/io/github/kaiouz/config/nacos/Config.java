package io.github.kaiouz.config.nacos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config")
public class Config {

    private String foo;

    private int bar;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }

    @Override
    public String toString() {
        return "Config{" +
                "foo='" + foo + '\'' +
                ", bar=" + bar +
                '}';
    }
}
