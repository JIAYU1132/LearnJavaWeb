package Java05_19;

// 有一个共享变量, 初始为 0, 启动 20 个线程, 每个线程执行 10000 次, 每次循环将共享变量 ++ 一次
public class UnsafeThread {

    private  static int SUM;
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    SUM++;
                }
            }).start();
        }
        // 所有子线程执行完毕后, 打印 SUM 的值
        while (Thread.activeCount() > 1) { // 这里的结果就是, 所有的子线程都执行完了, 只剩下当前线程(main 线程)了, 才能继续往下执行
            // Thread.activeCount 这个静态方法在 idea 中使用, 得使用 debug 的方式来运行
            // 因为 idea 中如果用 run 来运行的话, 会重新建立一个线程, 那么这里的条件就得改成 > 2
            Thread.yield(); // 当前线程 (mian 线程) 由运行态转变为就绪态
        }
        System.out.println(SUM);
    }
}
