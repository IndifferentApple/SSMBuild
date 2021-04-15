import com.imooc.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：peter
 * @description：TODO
 * @date ：2020/9/3 10:16
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {

    /**
     * 采用内存型的存储方式 -> Map
     */
    private final ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();
    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户对象
     *
     * @param user
     * @return 如果保持成功，返回<code>true</code>,
     * 否则返回<code>false</code>
     */
    public boolean save(User user) {
//        boolean success = false;
        //ID从1开始
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
//        repository.put(id,user);
        return repository.put(id,user) == null;
    }

    public Collection<User> findAll() {
        return  repository.values();
    }
}
