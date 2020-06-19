package Java05_23;

// 假设面包店有面包师傅有5个, 可以一直生产面包, 每次生产3个
// 假设面包店有20个消费者, 可以一直消费面包, 每次消费1个
// 假设面包店库存上限是100个, 下限是0

import java.util.Scanner;

public class SignalTest {

    // 库存
    private static int SUM;

    public static void main(String[] args) {
        // 5个面包师傅, 同时启动
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                           synchronized (SignalTest.class) {
                                if (SUM + 3 > 100) {
                                    SignalTest.class.wait();
                                } else {
                                    SUM += 3;
                                    System.out.println(Thread.currentThread().getName() + "生产了面包, 库存:" + SUM);
                                    Thread.sleep(500);
                                    SignalTest.class.notify();
                                }
                           }
                           Thread.sleep(200);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "面包师傅[" + i + "] 号").start();
        }
        // 20个消费者, 同时启动
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            synchronized (SignalTest.class) {
                                if (SUM == 0) {
                                    SignalTest.class.wait();
                                } else {
                                    SUM--;
                                    System.out.println(Thread.currentThread().getName() + "消费了面包, 库存:" + SUM);
                                    Thread.sleep(500);
                                    SignalTest.class.notify(); // 随机通知一个 wait 方法阻塞的线程
//                                    SignalTest.class.notifyAll(); // 随机通知全部 wait 方法阻塞的线程
                                }
                            }
                            Thread.sleep(200);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "消费者[" + i + "] 号").start();
        }
    }
}
