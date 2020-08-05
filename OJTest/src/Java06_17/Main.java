package Java06_17;

import java.util.Scanner;
// 饥饿的小易
// 4*x+3相当于对2*x+1操作2次,8*x+7相当于对2*x+1操作3次：
//如：f(x)=2*x+1,则 f(f(x)) = f(2*x+1) = 4*x+3;  f(f(f(x))) = f(f(2*x+1)) = f(4*x+3) = 8*x+7;
//因此只需要统计做多少次2*x+1操作就会到1000000007倍数的位置，将此次数记为count；
//而对4*x+3操作3次相当于对8*x+7操作2次：
//如：g(x) = 4*x+3 ; m(x)=8*x+7 ; 则g(g(g(x))) = m(m(x)) = 64*x+63 ;
//因此对4*x+3的操作次数只能为0,1,2 ; 3次时就可以用对8*x+7操作2次来代替。
//对（count+2）/3 就实现了上述。

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            long x = sc.nextInt();
            //分析得4*x+3相当于2*x+1操作2次
            //8*x+7相当于2*x+1操作3次
            //统计做了多少次2*x+1
            int count = 0;
            while(x!=0 && count<=300000){
                x = ((x<<1)+1)%1000000007;
                count++;
            }
            count = (count+2)/3;//4*x+3的操作只能进行0,1,2次
            System.out.println(count >100000 ? -1 : count);
        }
    }
}
