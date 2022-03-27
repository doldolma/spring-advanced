package hello.springadvanced.proxy.app.v2;

import hello.springadvanced.proxy.app.v2.ProxyOrderRepositoryV2;

public class ProxyOrderServiceV2 {
    private final ProxyOrderRepositoryV2 orderRepository;

    public ProxyOrderServiceV2(ProxyOrderRepositoryV2 orderRepositoryV2) {
        this.orderRepository = orderRepositoryV2;
    }

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
