package cn.yr.datasources.demodatasources.redis;

import cn.yr.datasources.demodatasources.jta.Person;
import cn.yr.datasources.demodatasources.service.PersonService;


import net.sf.json.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class RedisController {
    private  Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private  StringRedisTemplate stringRedisTemplate;//操作key-value都是字符串,不支持泛型

    @Autowired
    private RedisTemplate redisTemplate;//操作key-value都是对象，支持泛型

    @Autowired
    private PersonService personServices;




    /**
     *  Redis常见的五大数据类型：
     *  stringRedisTemplate.opsForValue();[String(字符串)]
     *  stringRedisTemplate.opsForList();[List(列表)]
     *  stringRedisTemplate.opsForSet();[Set(集合)]
     *  stringRedisTemplate.opsForHash();[Hash(散列)]
     *  stringRedisTemplate.opsForZSet();[ZSet(有序集合)]
     */

    /**
     * 查询
     * @return
     */
    @RequestMapping("/testRedis")
    @ResponseBody
    public String test(){
        Person person = personServices.getPerson(20);
        String json = JSONUtils.valueToString(person);
        return json;
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public String insert()
    {
        personServices.save();
        //personServices.getPerson(16);
        return "successful";

    }


    /**
     * 字符串
     */
    @RequestMapping("/str")
    @ResponseBody
    public String setStringRedis()
    {
        //System.out.println(stringRedisTemplate);
        //System.out.println(redisTemplate);
        stringRedisTemplate.opsForValue().append("StringKey","字符串数值");
        return "successful";
    }

    /**
     * 对象
     */
    @RequestMapping("/obj")
    @ResponseBody
    public String  setObjectRedis()
    {
        Person person = personServices.getPerson(20);
        redisTemplate.opsForValue().set("obj",person); //存

        Person obj = (Person) redisTemplate.opsForValue().get("obj"); //取
        System.out.println(obj.toString());
        return "ok";
    }

    /**
     * list
     */
    @RequestMapping("/list")
    @ResponseBody
    public String list()
    {
        List<String> list1=new ArrayList<String>();
        list1.add("a1");
        list1.add("a2");
        list1.add("a3");

        List<String> list2=new ArrayList<String>();
        list2.add("b1");
        list2.add("b2");
        list2.add("b3");

        //添加集合到redis缓存
        redisTemplate.opsForList().leftPush("key1",list1);
        redisTemplate.opsForList().rightPush("key2",list2);

        //从reids缓存中根据key 查询
        List<String> resultList1=(List<String>)redisTemplate.opsForList().leftPop("key1");
        List<String> resultList2=(List<String>)redisTemplate.opsForList().rightPop("key2");

        System.out.println("resultList1:"+resultList1);
        System.out.println("resultList2:"+resultList2);

        return "ok";

    }

    @RequestMapping("/map")
    @ResponseBody
    public String map()
    {
        Map<String,String> map=new HashMap<String,String>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        map.put("key5","value5");
        redisTemplate.opsForHash().putAll("map1",map);
        Map<String,String> resultMap= redisTemplate.opsForHash().entries("map1");
        List<String>reslutMapList=redisTemplate.opsForHash().values("map1");
        Set<String> resultMapSet=redisTemplate.opsForHash().keys("map1");
        String value=(String)redisTemplate.opsForHash().get("map1","key1");

        System.out.println("value:"+value);
        System.out.println("resultMapSet:"+resultMapSet);
        System.out.println("resultMap:"+resultMap);
        System.out.println("resulreslutMapListtMap:"+reslutMapList);

        return "OK";
    }
}
