package io.github.kaiouz.config.nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @Autowired
    private Config config;

    @GetMapping("/name")
    public String getName() {
        return configService.getName();
    }

    @GetMapping("/config")
    public Config getConfig() {
        return config;
    }
}
