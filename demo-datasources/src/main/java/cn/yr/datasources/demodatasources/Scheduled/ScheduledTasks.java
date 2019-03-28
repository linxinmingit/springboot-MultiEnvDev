package cn.yr.datasources.demodatasources.Scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    //private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

   //@Scheduled(fixedRate = 5000)  //每五秒执行一次
   // @Scheduled(cron = "0 0/1 * * * ?")   //隔一分钟执行一次
    public void reportCurrentTime() {
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}