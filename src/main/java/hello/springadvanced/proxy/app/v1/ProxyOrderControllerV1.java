package hello.springadvanced.proxy.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/proxy/v1")
@ResponseBody
public interface ProxyOrderControllerV1 {

    @GetMapping("/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/no-log")
    String noLog();
}
