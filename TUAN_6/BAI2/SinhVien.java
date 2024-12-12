/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_6.BAI2;

import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class SinhVien {
    String maSinhVien;
    String ten;
    String ngaySinh;
    double diemTrungBinh;

    public SinhVien(String maSinhVien, String ten, String ngaySinh, double diemTrungBinh) {
        this.maSinhVien = maSinhVien;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diemTrungBinh = diemTrungBinh;
    }

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sinh viên: ");
        this.maSinhVien = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        this.ten = scanner.nextLine();
        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        this.ngaySinh = scanner.nextLine();
        System.out.print("Nhập điểm trung bình: ");
        this.diemTrungBinh = scanner.nextDouble();
    }

    public void inThongTin() {
        System.out.println("Mã sinh viên: " + maSinhVien);
        System.out.println("Tên sinh viên: " + ten);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Điểm trung bình: " + diemTrungBinh);
    }

    public static Comparator<SinhVien> sortByDiemTrungBinh = new Comparator<SinhVien>() {
        @Override
        public int compare(SinhVien s1, SinhVien s2) {
            return Double.compare(s2.diemTrungBinh, s1.diemTrungBinh);
        }
    };
}
