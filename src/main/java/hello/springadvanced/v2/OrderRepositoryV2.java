package hello.springadvanced.v2;

import hello.springadvanced.trace.HelloTraceV1;
import hello.springadvanced.trace.HelloTraceV2;
import hello.springadvanced.trace.TraceId;
import hello.springadvanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId) { //저장 로직

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderRepository.save()"); //저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } }