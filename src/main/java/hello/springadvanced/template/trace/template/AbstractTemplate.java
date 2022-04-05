package hello.springadvanced.template.trace.template;

import hello.springadvanced.template.trace.TraceStatus;
import hello.springadvanced.template.trace.logtrace.TemplateLogTrace;

public abstract class AbstractTemplate<T> {

    private final TemplateLogTrace trace;

    public AbstractTemplate(TemplateLogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message){
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 로직호출
            T result = call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
