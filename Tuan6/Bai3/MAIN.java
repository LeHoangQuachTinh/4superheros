/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bai03_tuan06;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class MAIN {
    public static void main(String[] args) {
        TAIKHOAN tk = new TAIKHOAN();
        tk.nhapTK();
        tk.inTK();
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Nhap lua chon cua ban: ");
            System.out.println("1. Gui tien\n"
                    + "2. Rut tien\n"
                    + "3. Kiem tra so du\n"
                    + "0. Thoat chuong trinh");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Ban da chon phuong thuc gui tien !");
                    tk.guiTien();
                    break;
                case 2:
                    System.out.println("Ban da chon phuong thuc rut tien !");
                    tk.rutTien();
                    break;
                case 3:
                    System.out.println("Ban da chon phuong thuc kiem tra so du !");
                    tk.kiemTra();
                    break;  
                case 0:
                    System.out.println("Thoat chuong trinh");
                    break;      
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        }while(choice != 0);
    }
}
