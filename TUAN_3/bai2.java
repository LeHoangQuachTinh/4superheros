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
public class bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập điểm trung bình: ");
        double diemTrungBinh = scanner.nextDouble();

        if (diemTrungBinh >= 8.0) {
            System.out.println("Xếp loại: Giỏi");
        } else if (diemTrungBinh >= 6.5) {
            System.out.println("Xếp loại: Khá");
        } else if (diemTrungBinh >= 5.0) {
            System.out.println("Xếp loại: Trung bình");
        } else {
            System.out.println("Xếp loại: Yếu");
        }
    }
}
