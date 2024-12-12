/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai4 {
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

        Map<Integer, Integer> tanSuat = new HashMap<>();
        for (int num : mang) {
            tanSuat.put(num, tanSuat.getOrDefault(num, 0) + 1);
        }

        int phanTuNhieuNhat = mang[0];
        int tanSuatCaoNhat = tanSuat.get(phanTuNhieuNhat);
        for (Map.Entry<Integer, Integer> entry : tanSuat.entrySet()) {
            if (entry.getValue() > tanSuatCaoNhat) {
                phanTuNhieuNhat = entry.getKey();
                tanSuatCaoNhat = entry.getValue();
            }
        }

        System.out.println("Phần tử xuất hiện nhiều nhất: " + phanTuNhieuNhat + " (xuất hiện " + tanSuatCaoNhat + " lần)");
    }
}
