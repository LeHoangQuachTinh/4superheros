package Tuan4;
import java.util.Scanner;

public class bai1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập n:");
        int n=sc.nextInt();
        int tong=0;

        for(int i=0;i<=n;i++)
            tong+=i;
        System.out.printf("Tổng từ 1 đến %d là:%d",n,tong);
    }
}
