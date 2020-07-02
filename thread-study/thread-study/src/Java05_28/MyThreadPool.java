package Java05_28;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {

    private  BlockingQueue<Runnable> queue; // 仓库: 可以使用自定义的阻塞式队列

    // 创建快递公司
    public MyThreadPool(int corePoolSize, int capacity) {
        // 创建仓库
        queue = new ArrayBlockingQueue<>(capacity);
        // 招聘员工
        for (int i = 0; i < corePoolSize; i++) {
            new MyThread(queue).start();
        }
    }

    // 快递公司开放送快递的接口(营业点), 客户调用这个接口(去营业点办业务), 快递仓库存放包裹(往阻塞队列里面加元素)
    private void execute(Runnable task) throws InterruptedException {
        queue.put(task);
    }

    // 正式员工
    private static class MyThread extends Thread{
        private BlockingQueue<Runnable> queue;
        public MyThread(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                // 员工不停的从仓库取包裹, 没有进入到仓库的就阻塞等待, 取到了就执行
                while (true) {
                    Runnable task = queue.take();
                    task.run();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
