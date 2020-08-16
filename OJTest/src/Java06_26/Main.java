    package Java06_26;

    import java.text.DecimalFormat;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    public class Main {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            while(sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] strs = str.split(" ");
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < strs.length; i++) {
                    list.add(Integer.parseInt(strs[i]));
                }
                // A1 = 能被5整除的数字中所有偶数的和
                A1(list);
                // A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
                A2(list);
                // A3 = 被5除后余2的数字的个数；
                A3(list);
                //A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
                A4(list);
                //A5 = 被5除后余4的数字中最大数字。
                A5(list);
            }
        }

        private static void A5(List<Integer> list) {
            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                int tmp = list.get(i);
                if (tmp % 5 == 4) {
                    res = Math.max(res, tmp);
                }
            }
            if (res != 0) {
                System.out.print(res + " ");
            } else {
                System.out.print("N" + " ");
            }
        }

        private static void A4(List<Integer> list) {
            float res = 0;
            float count = 0;
            for (int i = 0; i < list.size(); i++) {
                int tmp = list.get(i);
                if (tmp % 5 == 3) {
                    res += tmp;
                    count++;
                }
            }
            if (res != 0) {
                double num = res / count;
                // 注意这里保留小数点后几位的写法
                DecimalFormat df = new DecimalFormat("0.0");
                System.out.print(df.format(num) + " ");
            } else {
                System.out.print("N" + " ");
            }
        }

        private static void A3(List<Integer> list) {
            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                int tmp = list.get(i);
                if (tmp % 5 == 2) {
                    res++;
                }
            }
            if (res != 0) {
                System.out.print(res + " ");
            } else {
                System.out.print("N" + " ");
            }
        }

        private static void A2(List<Integer> list) {
            int res = 0;
            int flag = 1;
            for (int i = 0; i < list.size(); i++) {
                int tmp = list.get(i);
                if (tmp % 5 == 1) {
                    res += tmp * flag;
                    flag = -flag;
                }
                }
            if (res != 0) {
                System.out.print(res + " ");
            } else {
                System.out.print("N" + " ");
            }
        }

        private static void A1(List<Integer> list) {
            int res = 0;
            for (int i = 0; i < list.size(); i++) {
                int tmp = list.get(i);
                if (tmp % 5 == 0) {
                    if (tmp % 2 == 0) {
                        res += tmp;
                    }
                }
            }
            if (res != 0) {
                System.out.print(res + " ");
            } else {
                System.out.print("N" + " ");
            }
        }
    }
