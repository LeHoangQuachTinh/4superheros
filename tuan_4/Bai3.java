/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan4;

import java.util.Scanner;

/**
 *
 * @author 123
 */
public class Bai3 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap vao mot so nguyen duong:");
            int n = scanner.nextInt();
            if(n<0)
                System.out.println("Yeu cap nhap lai so nguyen duong");
            else 
            {
                int giaithua = 1;
                for(int i=1;i<=n;i++)
                    giaithua = giaithua *i;
                System.out.println("Giai thua cua so " +n+ " la: " +giaithua);
            }
    }
}
