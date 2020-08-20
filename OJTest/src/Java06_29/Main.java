package Java06_29;


import java.text.DecimalFormat;
import java.util.Scanner;

// 学分绩点

/**
 * 链接：https://www.nowcoder.com/questionTerminal/a0c09a7e0da04e728810a8aca7226b7b
 * 来源：牛客网
 *
 * 北京大学对本科生的成绩施行平均学分绩点制（GPA）。
 * 既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。
 * 公式如下： 实际成绩 绩点 90——100 4.0 85——89 3.7 82——84 3.3 78——81 3.0 75——77 2.7
 * 72——74 2.3 68——71 2.0 64——67 1.5 60——63 1.0 60以下 0
 * 1．一门课程的学分绩点=该课绩点*该课学分
 * 2．总评绩点=所有学科绩点之和/所有课程学分之和 现要求你编写程序求出某人A的总评绩点（GPA）
 *
 * 第一行 总的课程数n（n<10）；
 * 第二行 相应课程的学分（两个学分间用空格隔开）；
 * 第三行 对应课程的实际得分；
 * 此处输入的所有数字均为整数。
 *
 * 输出有一行，总评绩点，精确到小数点后2位小数。（printf("%.2f",GPA);）
 *
 * 输入
 * 5
 * 4 3 4 2 3
 * 91 88 72 69 56
 *
 * 输出
 * 2.52
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] credit = new int[n]; // 课程的学分
            int creditSum = 0;
            int[] score = new int[n]; // 课程的实际得分
            double[] gpas = new double[n]; // 每一门课程的学分绩点
            double gpasSum = 0;
            double gpa = 0;
            for (int i = 0; i < n; i++) {
                credit[i] = sc.nextInt();
                creditSum += credit[i];
            }
            for (int i = 0; i < n; i++) {
                score[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (score[i] >= 90 && score[i] <= 100) {
                    gpas[i] = 4.0 * credit[i];
                }
                if (score[i] >= 85 && score[i] <= 89) {
                    gpas[i] = 3.7 * credit[i];
                }
                if (score[i] >= 82 && score[i] <= 84) {
                    gpas[i] = 3.3 * credit[i];
                }
                if (score[i] >= 78 && score[i] <= 81) {
                    gpas[i] = 3.0 * credit[i];
                }
                if (score[i] >= 75 && score[i] <= 77) {
                    gpas[i] = 2.7 * credit[i];
                }
                if (score[i] >= 72 && score[i] <= 75) {
                    gpas[i] = 2.3 * credit[i];
                }
                if (score[i] >= 68 && score[i] <= 71) {
                    gpas[i] = 2.0 * credit[i];
                }
                if (score[i] >= 64 && score[i] <= 67) {
                    gpas[i] = 1.5 * credit[i];
                }
                if (score[i] >= 60 && score[i] <= 63) {
                    gpas[i] = 1.0 * credit[i];
                }
                if (score[i] < 60) {
                    gpas[i] = 0;
                }
                gpasSum += gpas[i];
            }
            gpa = gpasSum / creditSum;
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(df.format(gpa));
        }
    }
}
