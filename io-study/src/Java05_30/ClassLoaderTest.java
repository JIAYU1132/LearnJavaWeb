package Java05_30;

import org.junit.Test;

import java.io.InputStream;

public class ClassLoaderTest {

    @Test
    public void t1() {
//        // 1. 通过 class 获取支援或 IO流
//        InputStream is = this.getClass().getResourceAsStream("data/呵呵.txt");
//        System.out.println(is);
//        // 之前使用 File可以获取到, 现在获取不到了
//
//        // 2. 通过 classloader 获取支援或 IO流
//        InputStream is2 = this.getClass().getClassLoader().getResourceAsStream("data/呵呵.txt");
//        System.out.println(is);
//        // 也获取不到

        // 1. 通过 class 获取支援或 IO流, 以当前 class 编译路径作为相对路径, 所以得把相对路径改为 ../呵呵2.txt
        InputStream is = this.getClass().getResourceAsStream("../呵呵2.txt");
        System.out.println(is);

        // 项目通过相对路径获取资源文件时, 一般使用 Classloader 方式获取, 不使用 File 和 Class 获取
        // 2. 通过 classloader 获取支援或 IO 流, 以整个项目编译的根路径作为相对路径
        InputStream is2 = this.getClass().getClassLoader().getResourceAsStream("呵呵.txt");
        System.out.println(is2);
    }
}
