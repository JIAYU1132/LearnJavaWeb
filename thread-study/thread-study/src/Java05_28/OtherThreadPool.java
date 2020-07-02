package Java05_28;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OtherThreadPool {
    ExecutorService pool = Executors.newSingleThreadExecutor();
    ExecutorService pool2 = Executors.newFixedThreadPool(4);
    ExecutorService pool3 = Executors.newScheduledThreadPool(4);
    ExecutorService pool4 = Executors.newCachedThreadPool();
}
