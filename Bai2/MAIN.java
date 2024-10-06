/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bai02_tuan06;

import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author DELL
 */
public class MAIN {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        DANHSACHSINHVIEN dssv = new DANHSACHSINHVIEN();
        int choice;
        do {            
            System.out.println("""
                               Nhap lua chon: 
                               1. Nhap thong tin sinh vien
                               2. In danh sach sinh vien
                               3. Sap xep danh sach sinh vien theo diem trung binh""");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Nhap thong tin sinh vien\n");
                    System.out.println("Nhap ma sinh vien: ");
                    String maSinhVien = sc.nextLine();
                    System.out.println("Nhap ten sinh vien: ");
                    String tenSinhVien = sc.nextLine();
                    System.out.println("Nhap ngay sinh: ");
                    String ngaySinh = sc.nextLine();
                    System.out.println("Nhap diem trung binh: ");
                    double diemTB = sc.nextDouble();
                    SINHVIEN sv = new SINHVIEN(maSinhVien, tenSinhVien, ngaySinh, diemTB);
                    dssv.themSV(sv);
                   break;
                case 2:
                    System.out.println("Danh sach sinh vien ban vua nhap la: ");
                    dssv.in();
                   break;
                case 3:
                    dssv.sapXep();
                    System.out.println("Danh sach sinh vien co diem trung binh tu cao den thap la: ");
                    dssv.in();
                   break;
                case 0:
                    System.out.println("Thoat chuong trinh !");
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai !");
                   break;
            }
        } while (choice != 0);
    }
}
