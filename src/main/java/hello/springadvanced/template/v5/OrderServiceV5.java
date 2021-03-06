package hello.springadvanced.template.v5;

import hello.springadvanced.template.trace.callback.TraceTemplate;
import hello.springadvanced.template.trace.logtrace.TemplateLogTrace;
import org.springframework.stereotype.Service;
@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, TemplateLogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {

        template.execute("OrderService.orderItem()", () -> {
           orderRepository.save(itemId);
           return null;
        });
    }
}
