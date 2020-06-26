package Java05_19;

public class InterruptThread {

    public static void main(String[] args) throws InterruptedException {

        // 第一段代码: 在主线程阻塞的时候中断
//        Thread t = new Thread(() ->{
//            try {
//                while(!Thread.interrupted()) { // 判断当前线程是否被中断 ------> 判断中断的标志位
//                    System.out.println(Thread.currentThread().getName());
//                    // sleep 线程阻塞的时候也可以中断, 但是是以抛出 InterruptedException 异常来中断的
//                    Thread.sleep(10000);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t.start();
//        Thread.sleep(2000);
//        // 特殊情况出现, 要中断子线程
//        t.interrupt();

        // 第二段代码:
        // 这里有几个重点:
        // (1) 线程初始时, 中断标志位 = false
        // (2) 调用线程的 interrupt() 方法, 该线程的中断标志位 = true
        // (3) 如果线程处于阻塞态, 中断抛出 InterruptedException 异常的时候, 会重置中断标志位 = false

//        Thread t = new Thread(() ->{ // isInterrupted = false
//                while(!Thread.interrupted()) { // 判断当前线程是否被中断 ------> 判断中断的标志位
//                    try {
//                        System.out.println(Thread.currentThread().getName());
//                        // sleep 线程阻塞的时候也可以中断, 但是是以抛出 InterruptedException 异常来中断的
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        // 线程阻塞的时候, 抛出 InterruptedException 中断线程,
//                        // 然后重置标志位 isInterrupted = false;
//                        e.printStackTrace();
//                    }
//                }
//        });
//        t.start();
//        Thread.sleep(2000);
//        // 特殊情况出现, 要中断子线程
//        t.interrupt(); // 这里是修改标志位 isInterrupted 改为 true

        // 第三段代码: 测试静态方法 Thread.interrupted() 作用
//        Thread t = new Thread(() -> { // isInterrupted = false
//            for (int i = 0; i < 20; i++) {
//                // Thread.interrupted(); 返回当前的中断标志位 (true / false), 并且重置标志位
//                // 内部代码:
//                // (1) boolean tmp = isInterrupted;
//                // (2) isInterrupted = false;
//                // (3) return tmp;
//
//                System.out.println(Thread.interrupted());
//            }
//        });
//        t.start();
//        t.interrupt(); // isInterrupted = true

        // 第四段代码: 测试实例方法 线程对象.isInterrupted() 方法
        Thread t = new Thread(() -> { // isInterrupted = false
            for (int i = 0; i < 20; i++) {
                // isInterrupted() 方法: 只返回中断标志位, 不多标志位做任何修改
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        t.start();
        t.interrupt(); // isInterrupted = true
    }
}
