package hello.springadvanced.proxy.config;

import hello.springadvanced.proxy.app.v2.ProxyOrderControllerV2;
import hello.springadvanced.proxy.app.v2.ProxyOrderRepositoryV2;
import hello.springadvanced.proxy.app.v2.ProxyOrderServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {

    @Bean
    public ProxyOrderControllerV2 proxyOrderControllerV2() {
        return new ProxyOrderControllerV2(proxyOrderServiceV2());
    }

    @Bean
    public ProxyOrderServiceV2 proxyOrderServiceV2() {
        return new ProxyOrderServiceV2(proxyOrderRepositoryV2());
    }

    @Bean
    public ProxyOrderRepositoryV2 proxyOrderRepositoryV2() {
        return new ProxyOrderRepositoryV2();
    }
}
