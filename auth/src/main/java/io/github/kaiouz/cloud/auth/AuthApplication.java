package io.github.kaiouz.cloud.auth;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AuthApplication {

//    @Bean
//    public VersionNacosRegistrationCustomizer versionNacosRegistrationCustomizer(
//            @Value("${spring.application.version}") String version) {
//        return new VersionNacosRegistrationCustomizer(version);
//    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(AuthApplication.class)
                .run(args);
    }

}
