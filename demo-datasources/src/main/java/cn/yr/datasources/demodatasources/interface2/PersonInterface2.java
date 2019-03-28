package cn.yr.datasources.demodatasources.interface2;

import cn.yr.datasources.demodatasources.jta.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

/**
 *
 * @author
 * @since
 */
@Mapper
public interface PersonInterface2 {
    /**
     *
     * @param person
     */
    public void insert(Person person);
    /**
     *
     * @param id
     * @return
     */
    public Person getPerson(Integer id);
}
