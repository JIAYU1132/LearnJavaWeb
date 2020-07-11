package Java_0710;

import java.text.DecimalFormat;
import java.util.Scanner;
//已知球的中心点和边上一个点的左边
//求:半径和体积


public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int z1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int z2 = scanner.nextInt();

        double r = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)+Math.pow(z1-z2,2));
        double v = 4/3.0*Math.acos(-1)*Math.pow(r,3);

        DecimalFormat format = new DecimalFormat("0.000");
        System.out.println(format.format(r)+" "+format.format(v));


    }
}
