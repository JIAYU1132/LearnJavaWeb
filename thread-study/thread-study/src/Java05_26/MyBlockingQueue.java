package Java05_26;

// 阻塞式队列
// (1) 基于数组的循环队列实现
// (2) 提供一个队列, 消费的时候(取出元素), 如果队列为空, 阻塞等待.
//     如果队列为满, 生产的时候(存元素), 阻塞等待

public class MyBlockingQueue<T> {

    private Object[] table;
    private int getIndex; // 取元素的索引
    private int putIndex; // 存元素的索引
    private int size; // 数组有效元素个数

    public MyBlockingQueue(int capacity) {
        table = new Object[capacity];
    }

    public synchronized void put(T element) throws InterruptedException {
        while (size == table.length) {
            // 如果队列满了, 就等待
            wait(); // this 对象绑定的 wait 方法
        }
        // 1. 把元素放到 putIndex 的位置
        table[putIndex] = element; // 存放元素
        // 2. 更新 putIndex 和 size 的值
        size++;
        putIndex = (putIndex + 1) % table.length;
        notifyAll();
        Thread.sleep(500);
    }

    public synchronized T get() throws InterruptedException {
        while (size == 0) {
            // 如果队列为空, 等待
            wait();
        }
        // 1. 把 getIndex 的元素取出
        Object element = table[getIndex]; // 取出元素
        // 2. 更新 getIndex 和 size 的值
        getIndex = (getIndex + 1) % table.length; // 注意这里是加1, 不是减1, 因为这相当于是一个循环队列
        size--;
        notifyAll();
        Thread.sleep(500);
        return (T)element;
    }

    // 这里必须使用 synchronized 加锁, 不能使用 volatile 不加锁, 如果不加锁, 会导致原子性丢失
    // 在 get/put 方法没有结束的时候, 就有可能获取到 size, 此时是没有原子性的
    public synchronized int getSize() {
        return size;
    }

    // 模拟使用自定义阻塞式队列
    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (queue) {
                            // 模拟生产面包
                            queue.put(1);
                            System.out.println("存放面包+1  " + queue.getSize());
                            // 这里直接打印出来的 size 值是不对的, 因为 put 方法和 getSize 方法都是加了锁的操作, 两个方法的实行时间间隔不能保证
                            // put 方法执行完后应该立刻打印此时的 size , 但是 getSize 操作还要竞争对象锁, 所以是没有原子性的, 所以会出现问题
                            // 解决方案: 加锁
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (queue) {
                            // 模拟消费面包
                            Integer e = queue.get();
                            System.out.println("消费面包-1  " + queue.getSize());
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
