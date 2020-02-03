package top.itning.weibohotsearch.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import top.itning.weibohotsearch.entity.Entry;

/**
 * @author itning
 * @date 2020/2/3 16:25
 */
public interface DieHotRepository extends ReactiveMongoRepository<Entry, String> {
}
