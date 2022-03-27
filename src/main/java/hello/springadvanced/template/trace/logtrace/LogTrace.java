package hello.springadvanced.template.trace.logtrace;

import hello.springadvanced.template.trace.TraceStatus;
import org.springframework.stereotype.Component;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
