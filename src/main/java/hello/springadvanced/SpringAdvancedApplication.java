package hello.springadvanced;

import hello.springadvanced.proxy.config.AppV1Config;
import hello.springadvanced.proxy.config.AppV2Config;
import hello.springadvanced.proxy.config.v1_proxy.ConcreteProxyConfig;
import hello.springadvanced.proxy.config.v1_proxy.InterfaceProxyConfig;
import hello.springadvanced.proxy.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import hello.springadvanced.proxy.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import hello.springadvanced.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import hello.springadvanced.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import hello.springadvanced.proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import hello.springadvanced.proxy.config.v5_autoproxy.AutoProxyConfig;
import hello.springadvanced.proxy.trace.logtrace.LogTrace;
import hello.springadvanced.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV2.class)
//@Import(BeanPostProcessorConfig.class)
@Import(AutoProxyConfig.class)
@SpringBootApplication(scanBasePackages = {"hello.springadvanced.template","hello.springadvanced.proxy.app"})
public class SpringAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdvancedApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
