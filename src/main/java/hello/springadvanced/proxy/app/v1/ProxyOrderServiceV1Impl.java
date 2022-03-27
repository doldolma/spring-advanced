package hello.springadvanced.proxy.app.v1;

public class ProxyOrderServiceV1Impl implements ProxyOrderServiceV1 {

    private final ProxyOrderRepositoryV1 orderRepository;

    public ProxyOrderServiceV1Impl(ProxyOrderRepositoryV1 orderRepositoryV1) {
        this.orderRepository = orderRepositoryV1;
    }

    @Override
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
