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
public class bai_3 {
    public static int giaithua(int n){
        if(n==0)
            return 1;
        else
            return n*giaithua(n-1);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập vào 1 số nguyên:");
        int a=scanner.nextInt();
        System.out.println("Giai thừa của "+a+" là: "+giaithua(a));
    }
}
