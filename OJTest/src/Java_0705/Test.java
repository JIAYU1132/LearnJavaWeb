package Java_0705;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// Callable创建线程
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call");
                return "ok";
            }
        };
        FutureTask task = new FutureTask(c);
        Thread t = new Thread(task);
        t.start();
        System.out.println(task.get());
        System.out.println("main");
    }
}
