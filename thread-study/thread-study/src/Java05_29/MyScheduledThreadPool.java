package Java05_29;

import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

public class MyScheduledThreadPool {

    //员工
    private MyTimer[] threads; // 这里可以去掉, 直接在构造方法里 new 就可以了

    // 仓库(优先级队列)
    private PriorityBlockingQueue<MyTimerTask> queue = new PriorityBlockingQueue<>();

    public MyScheduledThreadPool(int capacity) {
        threads = new MyTimer[capacity];
        for (int i = 0; i < capacity; i++) {
            threads[i] = new MyTimer(queue);
            threads[i].start();
        }
    }

    // 模拟执行定时任务的方法: 任务, 延迟时间(毫秒), 间隔时间
    public void schedule(Runnable runnable, long delay, long period) {
        MyTimerTask task = new MyTimerTask(runnable, new Date().getTime() + delay, period);
        // 这里考虑到一种特殊情况: 如果有个线程的延迟时间是很久, 另外一个延迟时间短的要先执行, 就会出错, 所以必须使用 notify进行唤醒
        synchronized (queue) {
            queue.put(task);
            queue.notifyAll();
        }
    }

    // 员工
    private static class MyTimer extends Thread {
        private PriorityBlockingQueue<MyTimerTask> queue;

        public MyTimer(PriorityBlockingQueue<MyTimerTask> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // take 和 put 方法在达到上限和下限的时候, 会阻塞等待
                    // poll 和 offer 是非阻塞方法. 如果达到上限和下限的时候, 返回空
                    MyTimerTask task = queue.take();
                    synchronized (queue) {
                        long current = System.currentTimeMillis(); // 获取当前时间戳
                        if (current < task.next) {
                            // 如果当前时间小于执行下一个的时间, 就等待
                            queue.wait(task.next - current);
                            // 等待直到满足下次执行时间, 需要从仓库中重新获取包裹 ---> 可能有时间更短的任务(更紧急的包裹需要派送)
                            queue.put(task); // 之前已经从仓库取出来在等待了, 要重新放回去, 此处并没有执行
                        } else {
                            task.run();
                            if (task.period > 0) {
                                // 如果时间间隔大于0
                                task.next = task.next + task.period; // 下次执行时间修改为当前的 next + period
                                queue.put(task);
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 定时任务
    private static class MyTimerTask implements Runnable, Comparable<MyTimerTask> {
        private Runnable runnable;
        private long next; // 下次执行时间
        private long period; // 间隔时间

        public MyTimerTask(Runnable runnable, long next, long period) {
            this.runnable = runnable;
            this.next = next;
            this.period = period;
        }

        @Override
        public void run() {
            runnable.run();
        }

        @Override
        public int compareTo(MyTimerTask o) {
            return Long.compare(next, o.next);
        }
    }

    public static void main(String[] args) {
        MyScheduledThreadPool pool = new MyScheduledThreadPool(4);
        pool.schedule(()->{
            System.out.println("ABC");
        }, 999999999,1000);
        pool.schedule(()->{
            System.out.println("D");
        }, 0,1000);

    }
}
