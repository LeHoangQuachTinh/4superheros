package Tuan5;
import java.util.Random;
import java.util.Scanner;
public class bai1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử:");
        int n=sc.nextInt();
        int tong=0;
        int[] a=new int[n];
        Random rand=new Random();
        for(int i=0;i<n;i++)
        {
            a[i]=rand.nextInt(50);
            tong+=a[i];
        }
        System.out.println("Tổng các phần tử trong mảng:"+tong);
        
        
    }
}
