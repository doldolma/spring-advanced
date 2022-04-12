package hello.springadvanced.proxy.config.v1_proxy.concrete_proxy;

import hello.springadvanced.proxy.app.v2.ProxyOrderRepositoryV2;
import hello.springadvanced.proxy.app.v2.ProxyOrderServiceV2;
import hello.springadvanced.proxy.trace.TraceStatus;
import hello.springadvanced.proxy.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

public class OrderServiceConcreteProxy extends ProxyOrderServiceV2 {

    private final ProxyOrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(ProxyOrderServiceV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.request()");
            //target 호출
            target.orderItem(itemId);
            logTrace.end(status);
        } catch(Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
