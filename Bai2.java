/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan3;

import java.util.Scanner;

/**
 *
 * @author 123
 */
public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao diem cua ban:");
        double n = scanner.nextDouble();
        if (n >= 0 && n <= 10) 
        {
        if(n>=8.5)
            System.out.println("Gioi");
        else
            if(n>=6.5)
                System.out.println("Kha");
            else
                if(n<6.5 && n>=3.5)
                    System.out.println("Trung binh");
                else
                    System.out.println("Yeu");
        }
        else
            System.out.println("Diem so khong the danh gia, hay nhap lai!");
}
}