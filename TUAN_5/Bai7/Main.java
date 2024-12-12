/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_5.Bai7;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        QuanLySinhVien quanLySinhVien = new QuanLySinhVien();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo mã");
            System.out.println("4. Sắp xếp sinh viên theo điểm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int chucNang = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống

            switch (chucNang) {
                case 1:
                    quanLySinhVien.themSinhVien();
                    break;
                case 2:
                    quanLySinhVien.xoaSinhVien();
                    break;
                case 3:
                    quanLySinhVien.timKiemSinhVien();
                    break;
                case 4:
                    quanLySinhVien.sapXepSinhVien();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Chọn sai, vui lòng chọn lại.");
            }
        }
    }
    }
