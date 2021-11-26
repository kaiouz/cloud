package io.github.kaiouz.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
public class TestApplication {

//    @Bean
//    public TestBean testBean() {
//        return new TestBean();
//    }

    @Bean
    @Lazy
    public Foo foo() {
        return new Foo();
    }

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(TestApplication.class)
                .run(args);

        context.getBean("foo");

        context.getBean("foo");
    }

}
