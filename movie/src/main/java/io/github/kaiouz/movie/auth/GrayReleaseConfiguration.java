package io.github.kaiouz.movie.auth;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Configuration;

/**
 * 灰度发布使用的配置
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(GrayReleaseProperties.class)
@LoadBalancerClients(defaultConfiguration = {
        GrayReleaseLoadBalancerConfiguration.class
})
public class GrayReleaseConfiguration {

}
