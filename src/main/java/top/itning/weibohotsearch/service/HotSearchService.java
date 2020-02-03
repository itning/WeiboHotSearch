package top.itning.weibohotsearch.service;

import top.itning.weibohotsearch.entity.Entry;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * 热搜服务
 *
 * @author wangn
 */
public interface HotSearchService {
    List<Entry> get() throws IOException;

    Set<Entry> getDie();
}
