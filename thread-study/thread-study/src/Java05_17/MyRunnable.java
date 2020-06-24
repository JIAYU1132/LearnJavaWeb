package Java05_17;
// 创建线程 - 方法2: 实现 Runnable 接口
// 通过实现 Runnable 接口, 并且调用 Thread 的构造方法将 Runnable 对象作为目标参数传入来创建线程对象
// 该方法的好处是可以规避类的单继承

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程运行");
    }
    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
    }
}


