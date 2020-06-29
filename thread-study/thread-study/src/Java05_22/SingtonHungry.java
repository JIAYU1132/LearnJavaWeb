package Java05_22;

// 单例：
// 在某些场景下，需要获取同一个对象

// 饿汉式：在类加载的时候， 就创建好了对象
public class SingtonHungry {

    // 类加载在 JVM 内部执行， 保证了线程间同步互斥
    // 同步互斥导致：(1) 只执行一次 (2) 线程安全
    public static SingtonHungry SINGTON = new SingtonHungry();

    // 私有化默认构造函数，不允许外部独立创建对象，以实现单例
    private SingtonHungry() {} // 私有的构造方法，保证获取到同一个对象

    public static SingtonHungry getInstance() {
        return SINGTON;
    }
}
