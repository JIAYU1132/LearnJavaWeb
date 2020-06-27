package Java05_20;

// 线程的所有状态
public class ThreadState {
    public static void main(String[] args) {
        for (Thread.State state : Thread.State.values()) {
            // Thread.State 就相当于一个类
            System.out.println(state);
        }
    }
}
