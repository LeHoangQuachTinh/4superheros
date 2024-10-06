/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLySinhVien {
    private ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();

    public void nhapDanhSachSinhVien() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int soLuong = scanner.nextInt();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\nNhap thong tin sinh vien thu " + (i + 1) + ":");
            SinhVien sv = new SinhVien();
            sv.nhapThongTin();
            danhSachSinhVien.add(sv);
        }
    }
    
    public void hienThiDanhSachSinhVien() {
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Danh sach sinh vien trong.");
        } else {
            System.out.println("\nDanh sach sinh vien:");
            for (SinhVien sv : danhSachSinhVien) {
                sv.hienThiThongTin();
            }
        }
    }

    public void sapXepTheoDiemGiamDan() {
        Collections.sort(danhSachSinhVien, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return Double.compare(sv2.getDiemTB(), sv1.getDiemTB());
            }
        });

        System.out.println("\nDanh sach sinh vien sau khi sap xep theo điem trung binh giam dan:");
        hienThiDanhSachSinhVien();
    }

    public static void main(String[] args) {
        QuanLySinhVien qlsv = new QuanLySinhVien();

        qlsv.nhapDanhSachSinhVien();

        qlsv.hienThiDanhSachSinhVien();

        qlsv.sapXepTheoDiemGiamDan();
    }
}

