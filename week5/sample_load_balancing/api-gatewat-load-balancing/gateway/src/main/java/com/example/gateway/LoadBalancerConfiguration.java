package com.example.gateway;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class LoadBalancerConfiguration {

    @Bean
public ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context) {
    return ServiceInstanceListSupplier.builder()
        .withFixedInstances("example-service",
            new DefaultServiceInstance("example-service-1", "example-service", "localhost", 8081, false),
            new DefaultServiceInstance("example-service-2", "example-service", "localhost", 8082, false))
        .build(context);
}
    @Bean
    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
            LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        if (name == null) {
            name = "example-service"; // fallback
        }
        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name,
                ServiceInstanceListSupplier.class), name);
    }
}