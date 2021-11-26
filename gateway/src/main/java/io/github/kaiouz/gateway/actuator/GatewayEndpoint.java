package io.github.kaiouz.gateway.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

@Endpoint(id = "testGateway")
public class GatewayEndpoint {

    @ReadOperation
    public String test() {
        return "testGateway";
    }

}
