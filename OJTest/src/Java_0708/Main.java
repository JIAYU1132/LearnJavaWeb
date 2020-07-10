package Java_0708;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Model A = new Model();
        Model B = new Model();

        for (int i = 0; i < N; i++) {
            String a = sc.next();
            String b = sc.next();
            judge(a, b, A, B);
        }

        System.out.println(A.win + " " + A.equal + " " + A.lose);
        System.out.println(B.win + " " + B.equal + " " + B.lose);
        System.out.println(getMost(A.map) + " " + getMost(B.map));
    }

    public static void judge(String a, String b, Model mA, Model mB) {
        if (a.equals("C")) {
            if (b.equals("C")) {
                mA.equal++;
                mB.equal++;
            } else if (b.equals("J")) {
                mA.win++;
                mB.lose++;
                mA.map.put("C", mA.map.get("C") + 1);
            } else {
                mA.lose++;
                mB.win++;
                mB.map.put("B", mA.map.get("B") + 1);
            }
        } else if (a.equals("J")) {
            if (b.equals("C")) {
                mA.lose++;
                mB.win++;
                mB.map.put("C", mA.map.get("C") + 1);
            } else if (b.equals("J")) {
                mA.equal++;
                mB.equal++;
            } else {
                mA.win++;
                mB.lose++;
                mA.map.put("J", mA.map.get("J") + 1);
            }
        } else {
            if (b.equals("C")) {
                mA.win++;
                mB.lose++;
                mA.map.put("B", mA.map.get("B") + 1);
            } else if (b.equals("J")) {
                mA.lose++;
                mB.win++;
                mB.map.put("J", mA.map.get("J") + 1);
            } else {
                mA.equal++;
                mB.equal++;
            }
        }
    }

    public static String getMost(Map<String, Integer> map) {
        if (map.get("C") >= map.get("J")) {
            if (map.get("C") > map.get("B")) {
                return "C";
            } else {
                return "B";
            }
        } else {
            if (map.get("J") > map.get("B")) {
                return "J";
            } else {
                return "B";
            }
        }
    }

    static class Model {
        int win;
        int equal;
        int lose;
        Map<String, Integer> map;

        Model() {
            map = new HashMap<>();
            map.put("B", 0);
            map.put("C", 0);
            map.put("J", 0);
        }
    }
}
