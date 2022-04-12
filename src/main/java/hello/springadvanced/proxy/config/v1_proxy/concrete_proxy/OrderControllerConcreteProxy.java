package hello.springadvanced.proxy.config.v1_proxy.concrete_proxy;

import hello.springadvanced.proxy.app.v2.ProxyOrderControllerV2;
import hello.springadvanced.proxy.app.v2.ProxyOrderServiceV2;
import hello.springadvanced.proxy.trace.TraceStatus;
import hello.springadvanced.proxy.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends ProxyOrderControllerV2 {

    private final ProxyOrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(ProxyOrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            //target 호출
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch(Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return super.noLog();
    }
}
