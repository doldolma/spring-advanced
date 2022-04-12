package hello.springadvanced.proxy.config.v1_proxy;

import hello.springadvanced.proxy.app.v2.ProxyOrderControllerV2;
import hello.springadvanced.proxy.app.v2.ProxyOrderRepositoryV2;
import hello.springadvanced.proxy.app.v2.ProxyOrderServiceV2;
import hello.springadvanced.proxy.config.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import hello.springadvanced.proxy.config.v1_proxy.concrete_proxy.OrderRepositoryConCreteProxy;
import hello.springadvanced.proxy.config.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;
import hello.springadvanced.proxy.trace.logtrace.LogTrace;
import hello.springadvanced.template.v2.OrderRepositoryV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public ProxyOrderControllerV2 ConcreteControllerV2(LogTrace logTrace){
        ProxyOrderControllerV2 controllerV2 = new ProxyOrderControllerV2(ConcreteOrderServiceV2(logTrace));
        return new OrderControllerConcreteProxy(controllerV2, logTrace);
    }

    @Bean
    public ProxyOrderServiceV2 ConcreteOrderServiceV2(LogTrace logTrace){
        ProxyOrderServiceV2 serviceImpl = new ProxyOrderServiceV2(ConcreteOrderRepositoryV2(logTrace));
        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }

    @Bean
    public ProxyOrderRepositoryV2 ConcreteOrderRepositoryV2(LogTrace logTrace){
        ProxyOrderRepositoryV2 repositoryV2 = new ProxyOrderRepositoryV2();
        return new OrderRepositoryConCreteProxy(repositoryV2, logTrace);
    }
}
