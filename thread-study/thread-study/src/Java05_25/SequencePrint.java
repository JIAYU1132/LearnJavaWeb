package Java05_25;

//同时启动三个线程, 按顺序打印 ABC三个字符串.

// 三个线程:
// 第一个只能打印 A
// 第二个只能打印 B
// 第三个只能打印 C
// 同时执行, 要求打印结果: ABC

public class SequencePrint {

    public static void main(String[] args) throws InterruptedException {
        print();
    }

    private static void print() {
        Thread t1 = new Thread(new Print("A", null));
        Thread t2 = new Thread(new Print("B", t1));
        Thread t3 = new Thread(new Print("C", t2));
        // 这里建立一个依赖关系
        // t2 依赖于 t1, 传入 t 后, 就会进入 if 语句, 等待 t1 执行完毕才会执行 t2, 打印 B
        // t3 依赖于 t2, 传入 t 后, 只有等 t2 执行完毕才会执行 t3, 也即只有 t1 和 t2 执行完毕, 才会打印 C
        // 这里这个依赖关系就直接导致了这三个线程传入后, 无论传入的顺序如何(这三个线程的系统轮转调度如何), 都会按顺序打印
        t2.start();
        t1.start();
        t3.start();
    }


    private static class Print implements Runnable{
        private String content;
        private Thread t;

        public Print(String content, Thread t) {
            this.content = content;
            this.t = t;
        }

        @Override
        public void run() {
            try {
                if (t != null) {
                    // 如果传入的 t 不为 null, 那就是 t2 和 t3 线程, 那就让他 join 等待前一个线程执行结束在执行
                    t.join();
                }
                // 如果不是 null, 那此时传入的就是 t1 线程, 直接打印即可
                System.out.println(content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
