package top.itning.weibohotsearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.itning.weibohotsearch.entity.Entry;
import top.itning.weibohotsearch.service.HotSearchService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author wangn
 */
@Controller
@ResponseBody
public class HotSearchController {
    private static final Logger logger = LoggerFactory.getLogger(HotSearchController.class);

    private final HotSearchService hotSearchService;

    @Autowired
    public HotSearchController(HotSearchService hotSearchService) {
        this.hotSearchService = hotSearchService;
    }

    @GetMapping("/get")
    public List<Entry> get() {
        try {
            return hotSearchService.get();
        } catch (IOException e) {
            logger.error("error: ", e);
            return Collections.emptyList();
        }
    }

    @GetMapping("/getDie")
    public Set<Entry> getDie() {
        try {
            return hotSearchService.getDie();
        } catch (Exception e) {
            logger.error("error: ", e);
            return Collections.emptySet();
        }
    }
}
