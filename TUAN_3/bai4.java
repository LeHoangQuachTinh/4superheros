/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_3;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập số b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập số c: ");
        double c = scanner.nextDouble();

        double min = a;

        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }

        System.out.println("Số nhỏ nhất là: " + min);
    }
}
