package Tuan5;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class bai4 {
   public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<Integer,Integer> mp=new HashMap<>();

        System.out.print("Nhập số lượng phần tử:");
        int n=sc.nextInt();
        int[] a=new int[n];
        Random rand=new Random();
        for(int i=0;i<n;i++)
        {

            a[i]=rand.nextInt(20);
            mp.put(a[i],mp.getOrDefault(a[i], 0)+1);
        }
        for(int i:a)
            System.out.print(i+" ");
        System.out.println();
        int max=0;
        int k=0;
        for(int key:mp.keySet())
        {
            int value=mp.get(key);
            if(value>max)
            {
                   max=value;
                   k=key;
            }
        }
        System.out.printf("Phần tử %d xuất hiện nhiều nhất là %d lần",k,max);
        
   }
}
