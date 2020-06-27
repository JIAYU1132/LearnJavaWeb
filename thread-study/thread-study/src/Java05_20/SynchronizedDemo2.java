package Java05_20;

// synchronized 修饰静态方法和普通方法时的区别

public class SynchronizedDemo2 {
    public static synchronized void methond() {
        System.out.println(1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
//    public synchronized void methond() {
//        System.out.println(1);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(2);
//    }

    public static void main(String[] args) {
        SynchronizedDemo2 demo = new SynchronizedDemo2();
//        // 使用同一个对象调用方法
//        new Thread(() -> demo.methond()).start();
//        new Thread(() -> demo.methond()).start();
//        // 使用不同对象调用方法
//        new Thread(() -> demo.methond()).start();
//        SynchronizedDemo2 demo2 = new SynchronizedDemo2();
//        new Thread(() -> demo2.methond()).start();
    }
}


