package io.github.kaiouz.movie.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @Autowired
    private AuthService authService;

    @GetMapping
    public String auth() {
//        return restTemplate.postForObject("http://auth/hello", null, String.class);
        return authService.hello();
    }

}
