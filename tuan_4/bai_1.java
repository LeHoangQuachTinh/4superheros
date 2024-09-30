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

public class bai_1 {
    public static int tong(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
           sum+=i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập vào số nguyên n:");
        int n=scanner.nextInt();
        System.out.println("tổng các số từ 1 đến n là:"+tong(n));
            
    }
}
