package cn.yr.datasources.demodatasources.interface1;

import cn.yr.datasources.demodatasources.jta.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 *
 * @author
 * @since
 */

@Mapper
@CacheConfig(cacheNames = "helloworld1")
public interface PersonInterface1 {

    /**
     * 添加
     *
     * @param person
     */
    @Cacheable(key = "insert")
    public void insert(Person person);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @Cacheable(value = "query", key = "#p0")   //@Cacheable注解会先查询是否已经有缓存，有会使用缓存，没有则会执行方法并缓存。
    public Person getPerson(Integer id);


    @CacheEvict(value = "delete")
    public void delete(Integer id);

}
