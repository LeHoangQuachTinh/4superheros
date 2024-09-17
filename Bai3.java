/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan2;

/**
 *
 * @author 123
 */
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập hai số nguyên
        System.out.print("Nhap so nguyen thu nhat: ");
        int num1 = scanner.nextInt();
        System.out.print("Nhap so nguyen thu hai: ");
        int num2 = scanner.nextInt();

        System.out.println("Tong: " + (num1 + num2));
        System.out.println("Hieu: " + (num1 - num2));
        System.out.println("Tich: " + (num1 * num2));
        if (num2 != 0) {
            System.out.println("Thuong: " + (num1 / num2));
            System.out.println("Phan du: " + (num1 % num2));
        } else {
            System.out.println("Khong the chia cho 0");
        }
    }
}

