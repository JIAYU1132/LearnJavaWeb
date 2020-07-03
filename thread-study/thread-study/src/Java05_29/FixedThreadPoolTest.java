package Java05_29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {

    private static ExecutorService FIXED_POOL = Executors.newFixedThreadPool(4);

    // 固定大小的线程池
    public static void runFixedThreadPool(Runnable task) {
        FIXED_POOL.execute(task);
    }

    public static void main(String[] args) {
        runFixedThreadPool(()->{
            System.out.println("送快递到北京");
        });
        runFixedThreadPool(()->{
            System.out.println("送快递到上海");
        });
        System.out.println("干自己的事情");
    }
}
