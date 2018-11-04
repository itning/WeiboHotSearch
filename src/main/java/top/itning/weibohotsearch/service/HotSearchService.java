package top.itning.weibohotsearch.service;

import top.itning.weibohotsearch.entity.Entry;

import java.io.IOException;
import java.util.List;

/**
 * 热搜服务
 *
 * @author wangn
 */
public interface HotSearchService {
    List<Entry> get() throws IOException;
}
