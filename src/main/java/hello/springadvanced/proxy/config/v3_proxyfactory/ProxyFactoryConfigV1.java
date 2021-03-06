package hello.springadvanced.proxy.config.v3_proxyfactory;

import hello.springadvanced.proxy.app.v1.*;
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
public class ProxyFactoryConfigV1 {

    @Bean
    public ProxyOrderControllerV1 proxyOrderControllerV1(LogTrace logTrace){
        ProxyOrderControllerV1Impl proxyOrderControllerV1 = new ProxyOrderControllerV1Impl(proxyOrderServiceV1(logTrace));
        ProxyFactory factory = new ProxyFactory(proxyOrderControllerV1);
        factory.addAdvisor(getAdvisor(logTrace));
        ProxyOrderControllerV1 proxy = (ProxyOrderControllerV1) factory.getProxy();
        log.info("ProxyFactory proxy = {}, target ={}", proxy.getClass(), proxyOrderControllerV1.getClass());
        return proxy;
    }

    @Bean
    public ProxyOrderServiceV1 proxyOrderServiceV1(LogTrace logTrace){
        ProxyOrderServiceV1Impl proxyOrderServiceV1 = new ProxyOrderServiceV1Impl(proxyOrderRepositoryV1(logTrace));

        ProxyFactory factory = new ProxyFactory(proxyOrderServiceV1);
        factory.addAdvisor(getAdvisor(logTrace));
        ProxyOrderServiceV1 proxy = (ProxyOrderServiceV1) factory.getProxy();
        log.info("ProxyFactory proxy = {}, target ={}", proxy.getClass(), proxyOrderServiceV1.getClass());
        return proxy;
    }

    @Bean
    public ProxyOrderRepositoryV1 proxyOrderRepositoryV1(LogTrace logTrace) {
        ProxyOrderRepositoryV1Impl proxyOrderRepositoryV1 = new ProxyOrderRepositoryV1Impl();

        ProxyFactory factory = new ProxyFactory(proxyOrderRepositoryV1);
        factory.addAdvisor(getAdvisor(logTrace));
        ProxyOrderRepositoryV1 proxy = (ProxyOrderRepositoryV1) factory.getProxy();
        log.info("ProxyFactory proxy = {}, target ={}", proxy.getClass(), proxyOrderRepositoryV1.getClass());
        return proxy;
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");

        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
