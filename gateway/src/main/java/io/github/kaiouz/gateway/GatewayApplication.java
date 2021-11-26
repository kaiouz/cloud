package io.github.kaiouz.gateway;

import io.github.kaiouz.gateway.actuator.GatewayEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    @Bean
    public GatewayEndpoint gatewayEndpoint() {
        return new GatewayEndpoint();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class)
                .run(args);
    }

}
