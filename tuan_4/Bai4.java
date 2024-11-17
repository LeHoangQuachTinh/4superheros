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
public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao mot so nguyen:");
        int n = scanner.nextInt();
        if (songuyento(n)) {
            System.out.println(n + " la so nguyen to.");
        } else {
            System.out.println(n + " khong phai la so nguyen to.");
        }
        scanner.close();
    }
    // Hàm kiểm tra số nguyên tố
    public static boolean songuyento(int n) {
        if (n < 2) {
            return false;
        }
        // Kiểm tra có chia hết cho 1 và chính nó
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; 
            }
        }  
        return true;
    }
}
