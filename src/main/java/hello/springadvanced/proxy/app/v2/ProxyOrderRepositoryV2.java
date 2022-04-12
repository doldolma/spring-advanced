package hello.springadvanced.proxy.app.v2;

import hello.springadvanced.template.trace.TraceId;

public class ProxyOrderRepositoryV2 {

    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생!");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void save(TraceId traceId, String itemId){
        sleep(1000);
    }
}
