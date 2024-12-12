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
public class bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập cạnh a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập cạnh b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập cạnh c: ");
        double c = scanner.nextDouble();

        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) {
                System.out.println("Đây là tam giác đều.");
            } else if (a == b || b == c || a == c) {
                System.out.println("Đây là tam giác cân.");
            } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                System.out.println("Đây là tam giác vuông.");
            } else {
                System.out.println("Đây là tam giác thường.");
            }
        } else {
            System.out.println("Ba cạnh không tạo thành một tam giác.");
        }

    }
}
