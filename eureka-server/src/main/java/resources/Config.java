package resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;

@Configuration(proxyBeanMethods = false)
@EnableAspectJAutoProxy
public class Config {

    @Bean
    public TestAspect testAspect() {
        return new TestAspect();
    }

    @Bean
    @Lazy
    public A a() {
        return new A();
    }

//    @Bean
//    @Lazy
//    public B b() {
//        return new B();
//    }

}
