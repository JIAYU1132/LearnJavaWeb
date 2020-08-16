package Java06_26;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.util.Collections;
public class Test{
    public static void main(String[] args){
        int i = 0;
        int sum;
        int countA2 = 0;
        int countA4 = 0;
        int countA5 = 0;
        int A1 = 0;
        int A2 = 0;
        int A3 = 0;
        double A4 = 0;
        int A5 = 0;
        List<Integer> list = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        sum = input.nextInt();
        int[] array = new int[sum];
        while(i<sum){
            array[i] = input.nextInt();
            i++;
        }
        // Arrays.sort(array);
        for(int j=0;j<array.length;j++){
            int r = array[j]%5;
            switch(r){
                case 0:{
                    if(array[j]%2==0){
                        A1+= array[j];
                    }
                    break;
                }
                case 1:{
                    A2 += (((countA2%2==0)?(1):(-1))*array[j]);
                    countA2++;
                    break;
                }
                case 2:{
                    A3 ++;
                    break;
                }
                case 3:{
                    A4 += array[j];
                    countA4++;
                    break;
                }
                case 4:{
                    list.add(array[j]);
                    A5 = list.get(countA5);
                    countA5++;
                    break;
                }
                default:
                    break;
            }
        }
        if(A1 == 0){
            System.out.print("N"+" ");
        }else{
            System.out.print(A1+" ");
        }
        if(A2 == 0){
            System.out.print("N"+" ");
        }else{
            System.out.print(A2+" ");
        }
        if(A3 == 0){
            System.out.print("N"+" ");
        }else{
            System.out.print(A3+" ");
        }
        if(A4 == 0){
            System.out.print("N"+" ");
        }else{
            DecimalFormat df = new DecimalFormat("#.0");
            System.out.print(df.format(A4/countA4)+" ");
        }
        if(A5 == 0){
            System.out.print("N");
        }else{
            A5 = Collections.max(list);
            System.out.print(A5);
        }
    }

}