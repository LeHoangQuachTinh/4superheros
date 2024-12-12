/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_5;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai2 {
    public static void inMang(int[] mang) {
        for (int value : mang) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử trong mảng: ");
        int n = scanner.nextInt();

        int[] mang = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            mang[i] = scanner.nextInt();
        }

        System.out.println("Mảng ban đầu:");
        inMang(mang);

        // Đảo ngược mảng
        for (int i = 0; i < n / 2; i++) {
            int temp = mang[i];
            mang[i] = mang[n - 1 - i];
            mang[n - 1 - i] = temp;
        }

        System.out.println("Mảng sau khi đảo ngược:");
        inMang(mang);
    }
}
