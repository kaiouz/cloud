package io.github.kaiouz.movie.auth;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.loadbalancer.core.DelegatingServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 灰度发布使用的负载均衡器
 * 灰度发布时, 只会调用相同集群的服务
 */
public class GrayReleaseLoadBalancer extends RoundRobinLoadBalancer {

    public GrayReleaseLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider,
                                   String serviceId, String cluster, String clusterMetadataKeyName, GrayReleaseProperties grayReleaseProperties) {
        super(new DelegatingObjectProvider(serviceInstanceListSupplierProvider,
                        supplier -> new ClusterPreferenceServiceInstanceListSupplier(clusterMetadataKeyName, cluster, grayReleaseProperties, supplier)),
                serviceId);
    }

    private static class ClusterPreferenceServiceInstanceListSupplier extends DelegatingServiceInstanceListSupplier {

        private final String clusterMetadataKeyName;
        private final String cluster;

        private final GrayReleaseProperties grayReleaseProperties;

        public ClusterPreferenceServiceInstanceListSupplier(String clusterMetadataKeyName, String cluster,
                                                            GrayReleaseProperties grayReleaseProperties,
                                                            ServiceInstanceListSupplier delegate) {
            super(delegate);
            this.grayReleaseProperties = grayReleaseProperties;
            this.clusterMetadataKeyName = clusterMetadataKeyName;
            this.cluster = cluster;
        }

        @Override
        public Flux<List<ServiceInstance>> get(Request request) {
            return getDelegate().get(request).map(this::filter);
        }

        @Override
        public Flux<List<ServiceInstance>> get() {
            return getDelegate().get().map(this::filter);
        }

        private List<ServiceInstance> filter(List<ServiceInstance> list) {
            if (grayReleaseProperties.getEnabled()) {
                return list.stream().filter(it -> match(it.getMetadata().get(clusterMetadataKeyName))).collect(Collectors.toList());
            } else {
                return list;
            }
        }

        private boolean match(String version) {
            return cluster.equals(version);
        }
    }

    private static class DelegatingObjectProvider implements ObjectProvider<ServiceInstanceListSupplier> {

        private final ObjectProvider<ServiceInstanceListSupplier> delegating;
        private final Function<ServiceInstanceListSupplier, ServiceInstanceListSupplier> wrapper;

        public DelegatingObjectProvider(ObjectProvider<ServiceInstanceListSupplier> delegating,
                                        Function<ServiceInstanceListSupplier, ServiceInstanceListSupplier> wrapper) {
            this.delegating = delegating;
            this.wrapper = wrapper;
        }

        private ServiceInstanceListSupplier wrap(ServiceInstanceListSupplier supplier) {
            if (supplier == null) {
                return null;
            }
            return wrapper.apply(supplier);
        }

        @Override
        public ServiceInstanceListSupplier getObject(Object... args) throws BeansException {
            return wrap(delegating.getObject(args));
        }

        @Override
        public ServiceInstanceListSupplier getIfAvailable() throws BeansException {
            return wrap(delegating.getIfAvailable());
        }

        @Override
        public ServiceInstanceListSupplier getIfUnique() throws BeansException {
            return wrap(delegating.getIfUnique());
        }

        @Override
        public ServiceInstanceListSupplier getObject() throws BeansException {
            return wrap(delegating.getObject());
        }
    }

}
