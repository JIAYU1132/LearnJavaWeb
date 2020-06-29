package Java05_22;

public class SingtonRun {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingtonLazy.getInstance3();
            }).start();
        }
    }
}
