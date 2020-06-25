package Java05_18;

public class Test {

    // 测试多线程执行效率问题

    private static int SUM;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SUM++;
                }
            }).start();
        }

        for (int i = 0; i < 20; i++) {
            SUM++;
        }

    }
}
