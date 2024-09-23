package Tuan5;
import java.util.Random;
import java.util.Scanner;
public class bai2 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử:");
        int n=sc.nextInt();
        int[] a=new int[n];
        Random rand=new Random();
        for(int i=0;i<n;i++)
            a[i]=rand.nextInt(20);
        for(int i:a)
            System.out.print(i+" ");
        for(int i=0;i<=n/2;i++)
        {
            int tmp=a[i];
            a[i]=a[n-i-1];
            a[n-i-1]=tmp;
        }
        System.out.println();
        for(int i:a)
            System.out.print(i+" ");
    }
}
