package hello.springadvanced.template;

import hello.springadvanced.template.trace.logtrace.ThreadLocalTemplateLogTrace;
import hello.springadvanced.template.trace.logtrace.TemplateLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public TemplateLogTrace templateLogTrace() {
        return new ThreadLocalTemplateLogTrace();
    }
}
