package Java05_22;

// 懒汉式
// 存在多线程安全问题
// 多行代码，有需要分解的代码行，不具有原子性、可见性
public class SingtonLazy {
    public static SingtonLazy SINGTON2;

    private SingtonLazy() {}

    public static SingtonLazy getInstance2() {
        if (SINGTON2 == null) {
            SINGTON2 = new SingtonLazy();
        }
        return SINGTON2;
    }

    // 多线程线程安全版本 ---- 效率低
    public static SingtonLazy SINGTON3;

    // 构造方法 private SingtonLazy() {}

    public synchronized static SingtonLazy getInstance3() {
        if (SINGTON3 == null) {
            SINGTON3 = new SingtonLazy();
        }
        return SINGTON3;
    }


    //  多线程安全版本 ---- 双重校验锁
    public volatile static SingtonLazy SINGTON4;

    // 构造方法 private SingtonLazy() {}

    public static SingtonLazy getInstance4() {
        if (SINGTON4 == null) {
            synchronized (SingtonLazy.class) {
                if (SINGTON4 == null) {
                    SINGTON4 = new SingtonLazy();
                }
            }
        }
        return SINGTON4;
    }
}
