package hello.springadvanced.trace.logtrace;

import hello.springadvanced.template.trace.TraceStatus;
import hello.springadvanced.template.trace.logtrace.ThreadLocalTemplateLogTrace;
import org.junit.jupiter.api.Test;

class ThreadLocalTemplateLogTraceTest {

    ThreadLocalTemplateLogTrace trace = new ThreadLocalTemplateLogTrace();


    @Test
    void begin_env_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_env_ex() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }

}