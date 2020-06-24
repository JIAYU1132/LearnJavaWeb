package Java05_17;

// 创建线程 - 方法1: 继承 Thread 类
// 这种方法的好处就是: this 代表的就是当前线程, 不需要使用 Thread.currentThread() 方法来获取当前线程的引用
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程运行");
    }

    public static void main(String[] args) {
        new MyThread().start();
        }
}