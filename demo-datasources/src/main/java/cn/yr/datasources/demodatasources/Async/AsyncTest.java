package cn.yr.datasources.demodatasources.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author
 * @since
 */
@Component
public class AsyncTest {

    @Async
    public void asyncTest()
    {
        for (int i = 1; i < 6; i++) {
            //
            System.out.println("这是异步请求，请求参数【"+i+ "】");
        }
    }
}
