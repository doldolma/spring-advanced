package hello.springadvanced.proxy.config.v3_proxyfactory;

import hello.springadvanced.proxy.app.v1.*;
import hello.springadvanced.proxy.app.v2.ProxyOrderControllerV2;
import hello.springadvanced.proxy.app.v2.ProxyOrderRepositoryV2;
import hello.springadvanced.proxy.app.v2.ProxyOrderServiceV2;
import hello.springadvanced.proxy.config.v3_proxyfactory.advice.LogTraceAdvice;
import hello.springadvanced.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProxyFactoryConfigV2 {
    @Bean
    public ProxyOrderControllerV2 proxyOrderControllerV2(LogTrace logTrace){
        ProxyOrderControllerV2 proxyOrderControllerV2 = new ProxyOrderControllerV2(proxyOrderServiceV2(logTrace));
        ProxyFactory factory = new ProxyFactory(proxyOrderControllerV2);
        factory.addAdvisor(getAdvisor(logTrace));
        ProxyOrderControllerV2 proxy = (ProxyOrderControllerV2) factory.getProxy();
        log.info("ProxyFactory proxy = {}, target ={}", proxy.getClass(), proxyOrderControllerV2.getClass());
        return proxy;
    }

    @Bean
    public ProxyOrderServiceV2 proxyOrderServiceV2(LogTrace logTrace){
        ProxyOrderServiceV2 proxyOrderServiceV2 = new ProxyOrderServiceV2(proxyOrderRepositoryV2(logTrace));

        ProxyFactory factory = new ProxyFactory(proxyOrderServiceV2);
        factory.addAdvisor(getAdvisor(logTrace));
        ProxyOrderServiceV2 proxy = (ProxyOrderServiceV2) factory.getProxy();
        log.info("ProxyFactory proxy = {}, target ={}", proxy.getClass(), proxyOrderServiceV2.getClass());
        return proxy;
    }

    @Bean
    public ProxyOrderRepositoryV2 proxyOrderRepositoryV2(LogTrace logTrace) {
        ProxyOrderRepositoryV2 proxyOrderRepositoryV2 = new ProxyOrderRepositoryV2();

        ProxyFactory factory = new ProxyFactory(proxyOrderRepositoryV2);
        factory.addAdvisor(getAdvisor(logTrace));
        ProxyOrderRepositoryV2 proxy = (ProxyOrderRepositoryV2) factory.getProxy();
        log.info("ProxyFactory proxy = {}, target ={}", proxy.getClass(), proxyOrderRepositoryV2.getClass());
        return proxy;
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");

        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
