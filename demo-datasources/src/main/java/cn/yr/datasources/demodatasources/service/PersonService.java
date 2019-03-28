package cn.yr.datasources.demodatasources.service;

import cn.yr.datasources.demodatasources.jta.Person;
import org.springframework.cache.annotation.Cacheable;

public interface PersonService {
    /**
     *添加
     */
    void save();

    /**
     * 查询
     * @param id
     * @return
     */
    Person getPerson(Integer id);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);
}
