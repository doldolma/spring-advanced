package hello.springadvanced.proxy.trace.logtrace;

import hello.springadvanced.proxy.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
