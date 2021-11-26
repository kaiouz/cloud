package io.github.kaiouz.cloud.auth.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${server.port}")
    private int port;

    @PostMapping
    public String sayHello() {
        return "hello " + port;
    }

}
