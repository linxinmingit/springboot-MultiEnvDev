package cn.yr.datasources.demodatasources.service;


import cn.yr.datasources.demodatasources.Async.AsyncTest;
import cn.yr.datasources.demodatasources.Scheduled.ScheduledTasks;
import cn.yr.datasources.demodatasources.interface1.PersonInterface1;

import cn.yr.datasources.demodatasources.interface2.PersonInterface2;
import cn.yr.datasources.demodatasources.jta.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *
 * @author
 * @since
 */
@Service
//@Transactional
public class PersonServiceImpl implements PersonService{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonInterface1 personInterface1;

    @Autowired
   private PersonInterface2 personInterface2;

    @Autowired
    private ScheduledTasks scheduledTasks;

    @Autowired
    private AsyncTest asyncTest;

    @Autowired
    private RedisTemplate redisTemplate;

    @Transactional
    public void save()
    {

        //logger.info("接口1："+personInterface1);
        //asyncTest.asyncTest();
        //logger.info("接口2："+personInterface2);


       //scheduledTasks.reportCurrentTime();

        Person person = new Person();
        person.setName("hejiaoyan");
        person.setAge(52);
        person.setAddr("hunan");

        personInterface2.insert(person);

        personInterface1.insert(person);
        //logger.info(personInterface1.getPerson(21).toString());
        //int c = 2/0;
    }

    @Override
    public Person getPerson(Integer id) {
        //return personInterface1.getPerson(id);
        return personInterface2.getPerson(id);
    }

    @Override
    public void delete(Integer id) {
        personInterface1.delete(id);
    }
}
