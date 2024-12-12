/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class bai5 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử trong danh sách: ");
        int n = scanner.nextInt();

        ArrayList<Integer> danhSach = new ArrayList<>();

        System.out.println("Nhập các phần tử của danh sách:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            danhSach.add(scanner.nextInt());
        }

        System.out.println("Các phần tử trong danh sách:");
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println("Phần tử thứ " + (i + 1) + ": " + danhSach.get(i));
        } 
    }

}
