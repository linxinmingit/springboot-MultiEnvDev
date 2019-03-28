package cn.yr.datasources.demodatasources;


import cn.yr.datasources.demodatasources.jta.atomikos.DBConfig1;
import cn.yr.datasources.demodatasources.jta.atomikos.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication
@ComponentScan(basePackages={"cn.yr.datasources.demodatasources","cn.yr.datasources.demodatasources.mapper.mapper1","cn.yr.datasources.demodatasources.mapper.mapper2","cn.yr.datasources.demodatasources.datasourceConfig"})
@EnableAutoConfiguration
//@EnableCaching   //开启缓存
//@SpringBootApplication
//@EnableScheduling  //开启定时任务
//@EnableAsync  //开启异步
//@ComponentScan(basePackages={"cn.yr.datasources.demodatasources.jta","cn.yr.datasources.demodatasources.interface1","cn.yr.datasources.demodatasources.interface1"})
//@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
public class DemoDatasourcesApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoDatasourcesApplication.class, args);
		//System.setProperty("net.sf.ehcache.enableShutdownHook","true");
	}

}
