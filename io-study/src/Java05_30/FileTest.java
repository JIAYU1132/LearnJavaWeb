package Java05_30;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

    @Test
    public void t1() {
        // 文件的相对路径和绝对路径
        // 绝对路径: 加上盘服的全路径
        // 相对路径: ./ (当前目录)  ../ (上一级目录)
        // 全路径
        File file = new File("F:\\learnJavaWeb\\io-study\\data\\呵呵.txt");
        System.out.println(file.exists()); // 判断文件是否存在
        // 相对路径
        File file1 = new File("../data/呵呵.txt");
        System.out.println(file1.exists());
        // 查看当前 Java 代码的的路径(当前目录)
        File file2 = new File(".");
        System.out.println(file2.getAbsolutePath()); // 获取绝对路径
        File file3 = new File("data/呵呵.txt"); // File 类写相对路径的方式不建议在真实的项目中使用
        System.out.println(file3.exists()); // exists() 文件是否存在
        System.out.println(file3.getPath()); // 获取路径
        System.out.println(file3.lastModified()); // 获取上次修改时间
    }

    @Test
    public void t2() {
        File file4 = new File("F:\\learnJavaWeb");
        File[] children = file4.listFiles(); // 返回目录下一级的子文件和子文件夹数组
        for (File child : children) {
            System.out.println(child.getName()); // 获取文件名
        }
    }

    // 递归获取目录下的所有子文件和子文件夹
    public static List<File> list(File file) {
        List<File> files = new ArrayList<>();
        if (file.isFile()) {
            files.add(file);
        } else {
            File[]  children = file.listFiles(); // 下一级子文件和子文件夹
            for (File child : children) {
                List<File> ret = list(child);
                files.addAll(ret);
            }
        }
        return files;
    }

    @Test
    public void t3() {
        File file4 = new File("F:\\learnJavaWeb");
        List<File> children = list(file4);
        for (File child : children) {
            System.out.println(child.getName()); // 获取文件名
        }
    }

    @Test
    public void t4() {
        File file5 = new File("data//呵呵.txt");
        String s = file5.getParent();
        System.out.println(s);
    }
}
