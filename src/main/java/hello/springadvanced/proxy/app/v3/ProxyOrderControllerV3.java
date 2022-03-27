package hello.springadvanced.proxy.app.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/proxy/v3")
public class ProxyOrderControllerV3 {
    private final ProxyOrderServiceV3 orderService;

    public ProxyOrderControllerV3(ProxyOrderServiceV3 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/request")
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/no-log")
    public String noLog() {
        return "ok";
    }
}
