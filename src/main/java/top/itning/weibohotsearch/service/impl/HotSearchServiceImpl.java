package top.itning.weibohotsearch.service.impl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.itning.weibohotsearch.entity.Entry;
import top.itning.weibohotsearch.service.HotSearchService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangn
 */
@Service
public class HotSearchServiceImpl implements HotSearchService {
    private static final Logger logger = LoggerFactory.getLogger(HotSearchServiceImpl.class);

    @Override
    public List<Entry> get() throws IOException {
        List<Entry> list = new ArrayList<>(50);
        Connection.Response response = Jsoup.connect("https://s.weibo.com/top/summary")
                .method(Connection.Method.GET)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36")
                .header("Host", "s.weibo.com")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .header("Accept-Language", "zh-CN,zh;q=0.9")
                .execute();
        response.parse().getElementsByClass("td-02")
                .stream()
                .skip(1)
                .forEach(element -> {
                    Elements aTag = element.getElementsByTag("a");
                    Elements spanTag = element.getElementsByTag("span");
                    Entry entry = new Entry();
                    entry.setHot(Integer.parseInt(spanTag.text()));
                    entry.setValue(aTag.text());
                    list.add(entry);
                });
        logger.debug("list size :" + list.size());
        return list;
    }
}
