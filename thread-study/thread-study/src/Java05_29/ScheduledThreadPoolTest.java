package Java05_29;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
    private static ScheduledExecutorService SCHEDULED_POOL = Executors.newScheduledThreadPool(4);

    public static void main(String[] args) {
        SCHEDULED_POOL.scheduleAtFixedRate(()->{
            Date date = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(date));
        }, 1, // 延迟多少秒之后执行一次
                1, // 每间隔多少秒执行一次
                TimeUnit.SECONDS); // 时间单位
        SCHEDULED_POOL.scheduleAtFixedRate(()->{
            System.out.println("abc");
        }, 0, 2, TimeUnit.SECONDS);
    }
}
