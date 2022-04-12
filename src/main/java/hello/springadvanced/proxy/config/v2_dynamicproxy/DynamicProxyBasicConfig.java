package hello.springadvanced.proxy.config.v2_dynamicproxy;

import hello.springadvanced.proxy.app.v1.*;
import hello.springadvanced.proxy.config.v2_dynamicproxy.handler.LogTraceBasicHandler;
import hello.springadvanced.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyBasicConfig {
    
    @Bean
    public ProxyOrderControllerV1 proxyOrderControllerV1(LogTrace logTrace){
        ProxyOrderControllerV1 proxyOrderControllerV1 = new ProxyOrderControllerV1Impl(proxyOrderServiceV1(logTrace));
        ProxyOrderControllerV1 proxy = (ProxyOrderControllerV1) Proxy.newProxyInstance(ProxyOrderControllerV1.class.getClassLoader(),
                new Class[]{ProxyOrderControllerV1.class}, new LogTraceBasicHandler(proxyOrderControllerV1, logTrace));
        return proxy;
    }

    @Bean
    public ProxyOrderServiceV1 proxyOrderServiceV1(LogTrace logTrace) {
        ProxyOrderServiceV1 orderServiceV1 = new ProxyOrderServiceV1Impl(proxyOrderRepositoryV1(logTrace));
        ProxyOrderServiceV1 proxy = (ProxyOrderServiceV1) Proxy.newProxyInstance(ProxyOrderServiceV1.class.getClassLoader(),
                new Class[]{ProxyOrderServiceV1.class}, new LogTraceBasicHandler(orderServiceV1, logTrace));
        return proxy;
    }

    @Bean
    public ProxyOrderRepositoryV1 proxyOrderRepositoryV1(LogTrace logTrace) {
        ProxyOrderRepositoryV1 orderRepositoryV1 = new ProxyOrderRepositoryV1Impl();

        ProxyOrderRepositoryV1 proxy = (ProxyOrderRepositoryV1) Proxy.newProxyInstance(ProxyOrderRepositoryV1.class.getClassLoader(),
                new Class[]{ProxyOrderRepositoryV1.class},
                new LogTraceBasicHandler(orderRepositoryV1, logTrace));
        return proxy;

    }
}
