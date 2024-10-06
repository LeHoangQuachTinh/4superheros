/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan5_1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLySinhVien {
    private ArrayList<Student> danhSachSinhVien = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void themSinhVien() {
        System.out.print("Nhap ma sinh vien: ");
        String maSV = scanner.nextLine();
        System.out.print("Nhap ten sinh vien: ");
        String ten = scanner.nextLine();
        System.out.print("Nhap diem trung binh: ");
        double diemTB = scanner.nextDouble();
        scanner.nextLine();

        Student sv = new Student(maSV, ten, diemTB);
        danhSachSinhVien.add(sv);
        System.out.println("Đa them sinh vien thanh cong!");
    }

    public void xoaSinhVien() {
        System.out.print("Nhap ma sinh vien can xoa: ");
        String maSV = scanner.nextLine();
        boolean found = false;

        for (Student sv : danhSachSinhVien) {
            if (sv.getMaSV().equals(maSV)) {
                danhSachSinhVien.remove(sv);
                System.out.println("Đa xoa sinh vien có ma: " + maSV);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien co ma: " + maSV);
        }
    }

    public void timKiemSinhVien() {
        System.out.print("Nhap ma sinh vien can tim: ");
        String maSV = scanner.nextLine();
        boolean found = false;

        for (Student sv : danhSachSinhVien) {
            if (sv.getMaSV().equals(maSV)) {
                System.out.println("Thong tin sinh vien:");
                sv.hienThiThongTin();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay sinh vien co ma: " + maSV);
        }
    }

    public void sapXepSinhVienTheoDiem() {
        Collections.sort(danhSachSinhVien, new Comparator<Student>() {
            @Override
            public int compare(Student sv1, Student sv2) {
                return Double.compare(sv1.getDiemTB(), sv2.getDiemTB());
            }
        });

        System.out.println("Danh sach sinh vien sau khi sap xep theo điem trung binh:");
        for (Student sv : danhSachSinhVien) {
            sv.hienThiThongTin();
        }
    }

    public void hienThiDanhSach() {
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Danh sach sinh viên trong.");
        } else {
            System.out.println("Danh sach sinh vien:");
            for (Student sv : danhSachSinhVien) {
                sv.hienThiThongTin();
            }
        }
    }

    public void menu() {
        int chon;
        do {
            System.out.println("\n--- QUAN LY SINH VIEN ---");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Xoa sinh vien");
            System.out.println("3. Tim kiem sinh vien theo ma");
            System.out.println("4. Sap xep sinh vien theo diem");
            System.out.println("5. Hien thi danh sach sinh vien");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            chon = scanner.nextInt();
            scanner.nextLine(); 

            switch (chon) {
                case 1:
                    themSinhVien();
                    break;
                case 2:
                    xoaSinhVien();
                    break;
                case 3:
                    timKiemSinhVien();
                    break;
                case 4:
                    sapXepSinhVienTheoDiem();
                    break;
                case 5:
                    hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
                    break;
            }
        } while (chon != 0);
    }

    public static void main(String[] args) {
        QuanLySinhVien qlsv = new QuanLySinhVien();
        qlsv.menu();
    }
}

