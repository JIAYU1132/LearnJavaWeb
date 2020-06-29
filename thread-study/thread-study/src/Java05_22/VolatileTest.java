package Java05_22;

public class VolatileTest {
    private static volatile int SUM;

    public static void increament(int n) {
        // 分解为三步指令
        // 1. 从主内存读取 SUM 到工作内存
        // 2. 找工作内存中修改 SUM　变量的值为　SUM + 1
        // 3. 将 SUM 写回主内存
        SUM++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increament(j);
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(SUM);
    }
}
