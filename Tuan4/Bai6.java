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
public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao so nguyen:");
        int n= scanner.nextInt();
        if(sodoixung(n))
            System.out.println("La day so doi xung");
        else
            System.out.println("Khong la so doi xung");
    }
    public static boolean sodoixung(int n) {
        int sobandau = n;
        int sodaonguoc = 0;
        while(n != 0){
            int num = n%10;
            sodaonguoc = sodaonguoc * 10 + num;
            n/=10;
        }
         return sobandau == sodaonguoc;
    }
}
