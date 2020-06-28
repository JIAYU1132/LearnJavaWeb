package Java05_25;

// 同时启动三个线程, 按顺序同时打印10次 A, B, C,

// 思路: 每个线程循环10次来打印 A, B, C
//       每次打印结束以后, 等待其余线程打印结束再往下执行
public class SequencePrint2 {
    public static void main(String[] args) {
        print2();
    }

    private static void print2() {
        Thread t1 = new Thread(new Print2("A"));
        Thread t2 = new Thread(new Print2("B"));
        Thread t3 = new Thread(new Print2("C"));
        t2.start();
        t1.start();
        t3.start();
    }

    private static class Print2 implements Runnable{
        private String content;
        // 创建两个和类绑定起来的属性: 字符串数组和下标
        private static String[] ARRAY = {"A", "B", "C"};
        private static int INDEX;

        public Print2(String content) {
            this.content = content;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (ARRAY) {
                        while (!ARRAY[INDEX].equals(content)) {
                            // 这里要进行等待操作, wait 操作必须用在 synchronized 代码块里, 所以要进行加锁操作
                            // 这里每执行一次就得把锁释放掉, 重新判断是否等待, 所以 synchronized 加锁操作就得在 while外面
                            ARRAY.wait();
                        }
                        System.out.print(content);
//                         这里打印必须考虑打印的顺序性
//                         所以考虑在打印之前必须有两个操作: 1. 等待,  2.通知
//                         1. 在 B 打印前等待 A 打印, 在 A 打印完后通知 B 打印
//                         2. 在 C 打印前等待 B 打印, 在 B 打印完后通知 C 打印
//                         3. 在 A 打印前等待 c 打印, 在 C 打印完后通知 A 打印
//                         这样的思路简单易懂, 但是实际写代码想想确实挺麻烦的
//                         每次打印完要 notify 通知另外一个线程, 也就意味着必须有三个不同的锁对象, 这样的代码必定很麻烦
//                         所以直接把这三个字符串放到一个字符串数组中, 每次打印前通过下标来判断打印
//                         如果传入的 content 是字符串数组中下标对应得字符串, 打印, 如果不是, 等待即可

                        // 这里还需要考虑的输出是否规范, 也就是换行符的打印
                        // 逻辑就是: 如果下标指向的是 C 这个字符串, 那就打印换行符
                        if (INDEX == ARRAY.length - 1) {
                            System.out.println();
                        }

                        // 打印完以后, 怎么唤醒
                        // 1. 给下标加一, 更新下标
                        INDEX = (INDEX + 1) % ARRAY.length; // 这里类似于循环队列的操作
                        // 2. 唤醒线程
                        ARRAY.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
