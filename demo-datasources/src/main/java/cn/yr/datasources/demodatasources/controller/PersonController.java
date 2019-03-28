package cn.yr.datasources.demodatasources.controller;


import cn.yr.datasources.demodatasources.jta.Person;
import cn.yr.datasources.demodatasources.service.PersonService;
import cn.yr.datasources.demodatasources.service.PersonServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class PersonController {
    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    // @Autowired
    //private CacheManager cacheManager;


    @RequestMapping("/testDatesources")
    public String save()
    {
       //personService.save();
      /* Person person = personService.getPerson(30);
       logger.info(person.toString());*/

        logger.info("77777777777777777");
        logger.warn("3333333333333333");
        logger.debug("99999999999999999");
        return "successful";
    }

    @RequestMapping("/personDel")
    public String delete()
    {
        personService.delete(30);
        return "OK";
    }

    /**
     * 清除cache
     * @return
     */
    @RequestMapping("/cleanCache")
    public String removeCache()
    {
        //cacheManager.getCache("helloworld1").clear();
        return "clean successful!";
    }

    /**
     * 自定义参数
     */

    //@Value("${mqtt.topic}")
    private String topic;
    //@Value("${mqtt.serverURI}")
    private String serverUrl ;


    /**
     * 多环境配置
     */
    //@Value("${com.yr}")
    private String environment;

     @RequestMapping("/getValue")
     @ResponseBody
    public String setValue()
     {
         //return "[ topic :"+topic+" , serverURL :"+serverUrl+"]";
         return "environment ："+environment;
     }
}
