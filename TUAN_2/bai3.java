/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai3 {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập số thứ 1:");
        a=scanner.nextInt();
        System.out.print("Nhập số thứ 2:");
        b=scanner.nextInt();
        System.out.println("Tổng 2 số:"+(a+b));
        System.out.println("Hiệu 2 số:"+(a-b));
        System.out.println("Tích 2 số:"+(a*b));
        System.out.println("Thương 2 số:"+((a*1.0)/b));
        System.out.println("Phần dư 2 số:"+(a%b));
    }
}
