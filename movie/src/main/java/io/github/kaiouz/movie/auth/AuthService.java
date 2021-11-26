package io.github.kaiouz.movie.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "auth")
public interface AuthService {

    @PostMapping("/hello")
    String hello();

}
