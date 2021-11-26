package io.github.kaiouz.cloud.auth;

import com.alibaba.cloud.nacos.registry.NacosRegistration;
import com.alibaba.cloud.nacos.registry.NacosRegistrationCustomizer;

public class VersionNacosRegistrationCustomizer implements NacosRegistrationCustomizer {

    private final String version;

    public VersionNacosRegistrationCustomizer(String version) {
        this.version = version;
    }

    @Override
    public void customize(NacosRegistration registration) {
        registration.getMetadata().put("version", version);
    }


}
