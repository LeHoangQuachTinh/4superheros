/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_6.BAI2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();
        
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhập thông tin sinh viên thứ " + (i + 1) + ":");
            SinhVien sinhVien = new SinhVien("", "", "", 0);
            sinhVien.nhapThongTin();
            danhSachSinhVien.add(sinhVien);
        }

        Collections.sort(danhSachSinhVien, SinhVien.sortByDiemTrungBinh);

        System.out.println("\nDanh sách sinh viên sau khi sắp xếp theo điểm trung bình giảm dần:");
        for (SinhVien sinhVien : danhSachSinhVien) {
            sinhVien.inThongTin();
            System.out.println("-------------");
        }
    }
}
