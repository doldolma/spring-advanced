package hello.springadvanced.template.trace.callback;

import hello.springadvanced.template.trace.TraceStatus;
import hello.springadvanced.template.trace.logtrace.TemplateLogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TraceTemplate {
    private final TemplateLogTrace trace;

    public TraceTemplate(TemplateLogTrace trace){
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            // 로직호출
            T result = callback.call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
