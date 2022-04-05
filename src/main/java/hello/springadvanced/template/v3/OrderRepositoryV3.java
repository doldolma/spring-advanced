package hello.springadvanced.template.v3;

import hello.springadvanced.template.trace.TraceStatus;
import hello.springadvanced.template.trace.logtrace.TemplateLogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final TemplateLogTrace trace;

    public void save(String itemId) { //저장 로직

        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()"); //저장 로직
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