package io.github.kaiouz.movie.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;

/**
 * 替换默认的负载均衡器
 *
 * 使用方式:
 * @LoadBalancerClients(defaultConfiguration = {
 *         GrayReleaseLoadBalancerConfiguration.class
 * })
 *
 */
public class GrayReleaseLoadBalancerConfiguration {

    @Bean
    public GrayReleaseLoadBalancer versionLoadBalancer(@Value("${spring.cloud.nacos.discovery.clusterName}") String cluster,
                                                       @Value("${" + LoadBalancerClientFactory.PROPERTY_NAME + "}") String serviceId,
                                                       LoadBalancerClientFactory loadBalancerClientFactory, GrayReleaseProperties grayReleaseProperties) {
        return new GrayReleaseLoadBalancer(loadBalancerClientFactory.getLazyProvider(serviceId, ServiceInstanceListSupplier.class),
                serviceId, cluster, "nacos.cluster", grayReleaseProperties);
    }

}
