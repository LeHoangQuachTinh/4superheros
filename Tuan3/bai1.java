package Tuan3;

import java.util.Scanner;

public class bai1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số:");
        double a=sc.nextDouble();

        if(a<0)
            System.out.printf("%f là số âm\n",a);
        else if(a>0)
            System.out.printf("%f là số dương\n",a);
        else
            System.out.printf("%f bằng 0\n",a);
        
    }
}