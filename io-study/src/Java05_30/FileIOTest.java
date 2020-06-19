package Java05_30;

import org.junit.Test;

import java.io.*;

public class FileIOTest {

    // 字节流读取操作 (1. 使用 FileInputStream 2. 使用 getClassLoader)
    @Test
    public void t1() throws IOException {
//        FileInputStream fis = null;
        InputStream fis = null;
        try {
            // 第一种方式: 使用 FileInputStream + 绝对路径
           //  fis = new FileInputStream(new File("F:\\learnJavaWeb\\io-study\\data\\呵呵.txt"));

            // 第二种方式: 使用 ClassLoader + 相对路径(推荐)
            fis = this.getClass().getClassLoader().getResourceAsStream("呵呵.txt");
            // abcdefg. 读取操作, 从当前位置偏移多少 位(read, new String 中的第二个参数), 读取多长(第三个参数)
            byte[] bytes = new byte[1024];
            int len;
            // 固定写法
            while ((len = fis.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                System.out.println(s);
            }
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    // 使用缓冲流来进行字节读取操作
    @Test
    public void t4() throws IOException {
        FileInputStream fis = new FileInputStream("F:\\\\learnJavaWeb\\\\io-study\\\\data\\\\呵呵.txt");
        BufferedInputStream bis = new BufferedInputStream(fis); // 缓冲输入流
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }
    }

    // 字符流读入操作
    @Test
    public void t2() throws IOException {
        FileReader reader = new FileReader("F:\\\\learnJavaWeb\\\\io-study\\\\data\\\\呵呵.txt");
        char[] chars = new char[1024];
        int len;
        // 固定写法
        while ((len = reader.read(chars)) != -1) {
            String s = new String(chars, 0, len);
            System.out.println(s);
        }
    }

    // 字节流转换为字符流(使用缓冲流) 高效
    @Test
    public void t3() throws IOException {
        FileInputStream fis = new FileInputStream("F:\\\\learnJavaWeb\\\\io-study\\\\data\\\\呵呵.txt");
        // 转换流操作, 指定编码格式, java 编译的编码如果和目标文件的编码格式不一致, 就会出现乱码
        InputStreamReader isr = new InputStreamReader(fis,"GBK" );
        BufferedReader br = new BufferedReader(isr); // 包装转换的输入流
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    // 字节流输出操作(使用 PrintWriter 辅助输出)
    @Test
    public void t5() throws FileNotFoundException {
        // 覆盖的方式
        FileOutputStream fos = new FileOutputStream("F:\\\\learnJavaWeb\\\\io-study\\\\data\\\\呵呵.txt");
        // 以追加的形式输出, 追加到文件末尾
//        FileOutputStream fos = new FileOutputStream("F:\\\\learnJavaWeb\\\\io-study\\\\data\\\\呵呵.txt",true);
        PrintWriter pw = new PrintWriter(fos); // 使用 PrintWriter 打印流辅助输出
        pw.println("追加1");
        pw.println("追加2");
        pw.println("追加3");
        pw.flush(); // 手动刷新缓冲区
//        PrintWriter pw = new PrintWriter(fos, true); // 自动刷新缓冲区
    }

    // 字节流输出操作(使用 BufferedWriter , 因为还要输出成字符形式, 所以需要 OutputStreamWriter 转化流)
    @Test
    public void t6() throws IOException {
        // 覆盖的方式
        FileOutputStream fos = new FileOutputStream("F:\\\\learnJavaWeb\\\\io-study\\\\data\\\\呵呵.txt");
        // 追加到文件末尾
//        FileOutputStream fos = new FileOutputStream("F:\\\\learnJavaWeb\\\\io-study\\\\data\\\\呵呵.txt",true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("追加1");
        bw.newLine(); // 换行
        bw.write("追加2");
        bw.newLine(); // 换行
        bw.write("追加3");
        bw.newLine(); // 换行
        bw.flush(); // 手动刷新缓冲区
    }
}

