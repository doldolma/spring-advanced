package hello.springadvanced.proxy.config.v1_proxy;

import hello.springadvanced.proxy.app.v1.*;
import hello.springadvanced.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import hello.springadvanced.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import hello.springadvanced.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import hello.springadvanced.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {
    @Bean
    public ProxyOrderControllerV1 orderController(LogTrace logTrace) {
        return new OrderControllerInterfaceProxy(new ProxyOrderControllerV1Impl(orderService(logTrace)), logTrace);
    }

    @Bean
    public ProxyOrderServiceV1 orderService(LogTrace logTrace) {
        return new OrderServiceInterfaceProxy(new ProxyOrderServiceV1Impl(orderRepository(logTrace)), logTrace);
    }

    @Bean
    public ProxyOrderRepositoryV1 orderRepository(LogTrace logTrace) {
        return new OrderRepositoryInterfaceProxy(new ProxyOrderRepositoryV1Impl(), logTrace);
    }
}
