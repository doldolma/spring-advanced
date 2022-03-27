package hello.springadvanced.proxy.app.v2;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequestMapping("/proxy/v2")
@ResponseBody
public class ProxyOrderControllerV2 {

    private final ProxyOrderServiceV2 orderService;

    public ProxyOrderControllerV2(ProxyOrderServiceV2 orderService) {
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
