/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai_3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("nhap vao 2 so nguyen:");
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        System.out.println("tong cua 2 so la:"+(a+b));
        System.out.println("hieu cua 2 so la:"+(a-b));
        if (b != 0) {
            System.out.println("thuong cua 2 so la:"+(a/b));
            System.out.println("phan du cua 2 so la:"+(a%b));
        }
       else 
            System.out.println("khong thuc hien duoc");
        
    }
}
