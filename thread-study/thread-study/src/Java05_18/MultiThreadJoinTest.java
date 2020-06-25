package Java05_18;

public class MultiThreadJoinTest {
    // 先打印 0 - 19, 随机同时打印, 全部打印完毕以后, 再打印 main
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            final int j = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                }
            });
            t.start();
            threads[i] = t;
        }
        for (int i = 0; i < 20; i++) {

            // 一定注意, 这个 20 个线程是同时随机执行的, 不是依次遍历执行
            // 假如这里只执行三个线程, 第一个线程执行完毕需要 3s, 第二个线程执行完毕需要 5s, 第三个线程执行完毕需要 4s,
            // 那么, join() 方法只需要等待 5s, 假如他的遍历顺序是 二, 一, 三; 那么等到线程二执行完毕以后, 再去看线程一和三, 此时线程一和三已经执行完毕了
            // 假如遍历顺序是 一. 二, 三; 那么join() 等到线程一执行完, 去看线程二, 发现线程二还没有执行完, 于是再等了 2s, 再去看线程三, 发现线程三也执行完了
            // 重点就是: 这些线程一定是同时执行的!!!

            threads[i].join();
        }
        System.out.println("main");
    }
}
