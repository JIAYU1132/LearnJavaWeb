package Java05_20;

// 演示 synchronized 方法

public class SynchronizedDemo {

    // 语法1. 静态同步方法上
    public static synchronized void test1() {

    }
    // test1 = test1_2
    public static void test1_2() {
        synchronized (SynchronizedDemo.class) {

        }
    }

    // 语法2. 实例同步方法上
    public synchronized void test2() {

    }
    // // test2 = test2_2
    public void test2_2() {
        synchronized (this) {

        }
    }


    public static void main(String[] args) {
        Object o = new Object();

        // 1. 对象锁: 每个对象有对象头, 每个对象头里面都包含锁
        // 2. synchronized 是获取对象锁的操作:
        //      (1) 申请对象锁成功:
        //              a. 持有对象锁, 进入代码块,
        //              b. 执行代码,
        //              c. 退出代码块, 归还对象锁
        //              -> JVM 会把竞争锁失败的线程唤醒, 唤醒的线程重新竞争, 循环(1)(2)的逻辑
        //      (2) 申请对象锁失败:
        //              线程进入一个同步队列中阻塞
        //              ----- JVM 管理 synchronized 竞争失败线程:
        //              a. 由运行态转变为阻塞态
        //              b. 将线程放到一个同步队列的数据结构中
        //              c. 对象锁再次可用的时候, 将所有竞争这个对象锁失败的线程唤醒(线程由阻塞态 -> 被唤醒的状态)
        // 3. 对象: 普通的 Java 对象、类对象(JVM 是把类当作对象来管理)
        // 4. 注意事项:
        //      (1) 多个线程只有对同一个对象申请对象锁时, 才会有同步互斥的作用
        //          ----- 同步互斥: 同步代码块, 在一个时间点, 只有一个线程运行
        //      (2) 多个线程竞争不同对象的对象锁, 不会有同步互斥
        // 5. 对于静态同步方法和实例同步方法都可以转变成同步代码块的写法

        //  // 3. 同步代码块
        synchronized(o) {

        }
    }
}
