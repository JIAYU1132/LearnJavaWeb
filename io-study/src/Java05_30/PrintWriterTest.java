package Java05_30;

import org.junit.Assert;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintWriterTest {

    @Test
    public void t1() {
        try {
            int i = 1 / 0;
            System.out.println("1/0");
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw); // 把 StringWriter 包裹到 PrintWriter 流里面
            e.printStackTrace(pw);
            // 这样就相当于把堆栈错误的信息输出到 pw 对象里面去了, 而 pw 再次输出, 最终数据跑到 sw 这里了
            System.out.println(sw.toString());
        }
        System.out.println("t1");
    }
}
