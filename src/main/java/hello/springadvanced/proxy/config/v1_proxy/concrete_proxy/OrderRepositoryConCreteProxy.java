package hello.springadvanced.proxy.config.v1_proxy.concrete_proxy;

import hello.springadvanced.proxy.app.v2.ProxyOrderRepositoryV2;
import hello.springadvanced.proxy.trace.TraceStatus;
import hello.springadvanced.proxy.trace.logtrace.LogTrace;
import hello.springadvanced.template.trace.TraceId;


public class OrderRepositoryConCreteProxy extends ProxyOrderRepositoryV2 {

    private final ProxyOrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryConCreteProxy(ProxyOrderRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void save(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.request()");
            //target 호출
            target.save(itemId);
            logTrace.end(status);
        } catch(Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
