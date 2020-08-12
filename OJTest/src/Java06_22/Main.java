package Java06_22;

import java.util.*;

/**
 * 查找和排序
 *
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 *
 * 示例：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 * 从低到高
 * smith     67
 * jack      70
 * Tom      70
 * peter     96
 *
 * 输入
 * 3
 * 0
 * fang 90
 * yang 50
 * ning 70
 * 输出
 * fang 90
 * ning 70
 * yang 50
 */
class Student {
    public String name;
    public int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int judge = sc.nextInt();
            List<Student> list = new ArrayList<Student>();
            for (int i = 0; i < n; i++) {
                list.add(new Student(sc.next(), sc.nextInt()));
            }
            if (judge == 0) {// 降序
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.score - o1.score;
                    }
                });
            } else if (judge == 1) {// 升序
                Collections.sort(list, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.score - o2.score;
                    }
                });
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).name + " " + list.get(i).score);
            }
        }
    }
}
