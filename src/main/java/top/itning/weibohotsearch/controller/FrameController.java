package top.itning.weibohotsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wangn
 */
@Controller
public class FrameController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
