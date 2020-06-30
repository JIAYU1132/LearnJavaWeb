package Java05_27;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadVsThreadPool {

    public static void main(String[] args) {

        // 1. 没有使用线程, 送快递
        // 相当于老板自己送快递, 再干自己的活
        System.out.println("送快递到北京"); // 模拟送快递, 有可能送快递是比较耗时的
        System.out.println("送快递到上海");
        System.out.println("处理自己的业务");

        // 2. 使用手动创建线程的方式, 送快递
        // 相当于雇佣了两个人, 他们在送快递, 此时老板也在干自己的事情
        new Thread(()->{
            System.out.println("送快递到北京");
        }).start();
        new Thread(()->{
            System.out.println("送快递到上海");
        }).start();
        System.out.println("处理自己的业务");

        // 3. 使用 JDK 的线程池来送快递
        // 创建线程池对象, 相当于开了一家送快递的公司, 专门处理送快递的任务
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4, // 核心线程数: 快递公司的正式员工 ---- 线程
                10, // 最大线程数: 快递公司的总员工(正式工 + 临时工) ---- 线程
                // 临时工 + 空闲时间: 正式员工数量不够处理任务的时候, 招聘临时工, 临时工常超过空闲时间, 就解雇
                60, // 空闲时间数
                TimeUnit.SECONDS, // 时间单位
                new ArrayBlockingQueue<>(1000), // 阻塞队列: 快递公司的仓库, 用来保存快递包裹 ---- 存放线程的容器
                new ThreadFactory() { // 匿名内部类
                    @Override
                    public Thread newThread(Runnable r) { // 线程的工厂类: 快递公司招聘标准 ---- 创建线程的方式
                        return new Thread(r);
                    }
                },
                // 拒绝策略: 接受到新的快递单, 但此时仓库容量不够存放快递包裹
//                new ThreadPoolExecutor.AbortPolicy() // 抛异常的方式:RejectedExecutionException
//                new ThreadPoolExecutor.CallerRunsPolicy() // 谁把包裹交给我的, 让他自己去送(execute 代码所在线程自己执行)
//                new ThreadPoolExecutor.DiscardOldestPolicy() // 把仓库中最旧的包裹丢弃
                new ThreadPoolExecutor.DiscardPolicy() // 把仓库中最新的丢掉
        );
        pool.execute(()->{
            System.out.println("送快递到北京");
        });
        pool.execute(()->{
            System.out.println("送快递到上海");
        });
        System.out.println("处理自己的业务");
    }

}
