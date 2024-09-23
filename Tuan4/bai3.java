package Tuan4;
import java.util.Scanner;

public class bai3 {
    public static int Giaithua(int n){
        if(n==0)
            return 1;
        return n*Giaithua(n-1);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số nguyên dương n:");
        int n=sc.nextInt();
        System.out.printf("Giai thừa của %d là:%d\n",n,Giaithua(n));
    }
   
}
