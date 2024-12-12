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
public class bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> danhSach = new ArrayList<>();
        
        System.out.print("Nhập số lượng phần tử ban đầu trong danh sách: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            danhSach.add(scanner.nextInt());
        }

        System.out.print("Nhập phần tử cần thêm: ");
        int phanTuThem = scanner.nextInt();
        System.out.print("Nhập vị trí muốn thêm: ");
        int viTriThem = scanner.nextInt();
        danhSach.add(viTriThem, phanTuThem);

        for (int i = 0; i < danhSach.size(); i++) {
            System.out.print(danhSach.get(i) + " ");
        }
        System.out.println();

        System.out.print("Nhập vị trí muốn xóa: ");
        int viTriXoa = scanner.nextInt();
        danhSach.remove(viTriXoa);

        for (int i = 0; i < danhSach.size(); i++) {
            System.out.print(danhSach.get(i) + " ");
        }
        System.out.println();
    }
}
