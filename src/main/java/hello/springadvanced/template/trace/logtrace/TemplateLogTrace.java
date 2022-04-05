package hello.springadvanced.template.trace.logtrace;

import hello.springadvanced.template.trace.TraceStatus;

public interface TemplateLogTrace {

    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
