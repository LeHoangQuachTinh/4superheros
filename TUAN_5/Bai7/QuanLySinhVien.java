/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_5.Bai7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class QuanLySinhVien {
    private ArrayList<student> danhSachSinhVien = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void themSinhVien() {
        System.out.print("Nhập mã sinh viên: ");
        String maSinhVien = scanner.nextLine();
        System.out.print("Nhập tên sinh viên: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập điểm trung bình: ");
        double diemTrungBinh = scanner.nextDouble();
        scanner.nextLine(); // Đọc dòng trống sau khi nhập số

        student sinhVien = new student(maSinhVien, ten, diemTrungBinh);
        danhSachSinhVien.add(sinhVien);
        System.out.println("Đã thêm sinh viên thành công!");
    }

    public void xoaSinhVien() {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String maSinhVien = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < danhSachSinhVien.size(); i++) {
            if (danhSachSinhVien.get(i).maSinhVien.equals(maSinhVien)) {
                danhSachSinhVien.remove(i);
                found = true;
                System.out.println("Đã xóa sinh viên có mã: " + maSinhVien);
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên với mã: " + maSinhVien);
        }
    }

    public void timKiemSinhVien() {
        System.out.print("Nhập mã sinh viên cần tìm: ");
        String maSinhVien = scanner.nextLine();
        boolean found = false;

        for (student sinhVien : danhSachSinhVien) {
            if (sinhVien.maSinhVien.equals(maSinhVien)) {
                System.out.println(sinhVien);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên với mã: " + maSinhVien);
        }
    }

    public void sapXepSinhVien() {
        danhSachSinhVien.sort((s1, s2) -> Double.compare(s2.diemTrungBinh, s1.diemTrungBinh));
        System.out.println("Danh sách sinh viên sau khi sắp xếp theo điểm trung bình:");
        for (student sinhVien : danhSachSinhVien) {
            System.out.println(sinhVien);
        }
    }
}
