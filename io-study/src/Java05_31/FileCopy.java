package Java05_31;

import java.io.*;

// 简单实现一下对文件的拷贝
public class FileCopy {
    public static void main(String[] args) throws IOException {
        copyFile();
    }

    private static void copyFile() throws IOException {
        // 创建输入流对象
        FileInputStream fis = new FileInputStream("D:\\QQ\\386902834\\FileRecv\\IO.png");
        // 创建缓冲输入流对象
        BufferedInputStream bis = new BufferedInputStream(fis);
        // 创建输出流对象
        FileOutputStream fos = new FileOutputStream("F:\\板书\\IO");
        // 创建缓冲输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 准备一个搬运工具
        byte[] bytes = new byte[1024];
        int len = 0;
        // 循环读写数据即可
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        // 释放资源
        bos.flush();
        bos.close();
        bis.close();
        System.out.println("复制成功");
    }
}
