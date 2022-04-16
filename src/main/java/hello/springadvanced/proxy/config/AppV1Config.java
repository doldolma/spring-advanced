package hello.springadvanced.proxy.config;


import hello.springadvanced.proxy.app.v1.*;
import hello.springadvanced.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import hello.springadvanced.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import hello.springadvanced.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV1Config {

    @Bean
    public ProxyOrderControllerV1 proxyOrderControllerV1() {
        return new ProxyOrderControllerV1Impl(proxyOrderServiceV1());
    }

    @Bean
    public ProxyOrderServiceV1 proxyOrderServiceV1() {

        return new ProxyOrderServiceV1Impl(proxyOrderRepositoryV1());
    }

    @Bean
    public ProxyOrderRepositoryV1 proxyOrderRepositoryV1() {
        return new ProxyOrderRepositoryV1Impl();
    }
}
