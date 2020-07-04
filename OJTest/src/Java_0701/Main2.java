package Java_0701;

import java.util.Scanner;

// 整数与ip地址之间的相互转换
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String strIp = sc.nextLine();
            long numIp = Long.valueOf(sc.nextLine());
            System.out.println(ipToNum(strIp));
            System.out.println(numToIp(numIp));
        }
    }

    public static long ipToNum(String str){
        String[] strlist = str.split("\\.");
        StringBuilder sbAll = new StringBuilder();
        for(int i=0;i<strlist.length;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(Long.toBinaryString(Long.valueOf(strlist[i])));
            while(sb.length()<8){
                sb.insert(0, 0);
            }
            sbAll.append(sb);
        }
        return Long.valueOf(sbAll.toString(), 2);
    }

    public static String numToIp(long n){
        StringBuilder sb = new StringBuilder();
        StringBuilder numSb = new StringBuilder();
        sb.append(Long.toBinaryString(n));
        while(sb.length()<32){
            sb.insert(0, 0);
        }
        for(int i=0;i<4;i++){
            String temp = sb.substring(i*8, i*8+8);
            numSb.append(Long.valueOf(temp, 2));
            numSb.append(".");
        }
        numSb.deleteCharAt(numSb.length()-1);
        return numSb.toString();
    }
}
