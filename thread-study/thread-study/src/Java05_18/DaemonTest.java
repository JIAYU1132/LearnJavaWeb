package Java05_18;

public class DaemonTest {

    // 测试 setDaemon 方法


    private static int sum = 1;

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
           //     sum++;
                try {
                    Thread.sleep(999999999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(t.isAlive());
        t.setDaemon(true);
        t.start();
    }
}
