package hello.springadvanced.proxy.pureproxy.concreteprxoy;

import hello.springadvanced.proxy.pureproxy.concreteprxoy.code.ConcreteClient;
import hello.springadvanced.proxy.pureproxy.concreteprxoy.code.ConcreteLogic;
import hello.springadvanced.proxy.pureproxy.concreteprxoy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
