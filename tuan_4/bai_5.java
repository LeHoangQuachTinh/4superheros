/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_4;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai_5 {
    public static int  ucln(int a,int b){
        if(a==b)
            return a;
        else
            if(a>b)
               return ucln(a-b, b);
            else
                return ucln(a, b-a);
    }
    public static int  bcnn(int a,int b){
       
        return (a*b)/ucln(a, b);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập vào 2 số nguyên:");
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        System.out.println("Ước chung lớn nhất của 2 số là:"+ucln(a, b));
        System.out.println("Bội chung nhỏ nhất của 2 số là:"+bcnn(a, b));
    }
}
