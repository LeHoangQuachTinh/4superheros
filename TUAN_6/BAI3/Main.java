/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_6.BAI3;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        TaiKhoan taiKhoan = new TaiKhoan("123456789", "Nguyen Van A", 500000);
        System.out.println("Thông tin tài khoản:");
        System.out.println("Số tài khoản: " + taiKhoan.soTaiKhoan);
        System.out.println("Chủ tài khoản: " + taiKhoan.chuTaiKhoan);
        taiKhoan.kiemTraSoDu();

        taiKhoan.guiTien(200000);
        taiKhoan.rutTien(100000);
        taiKhoan.kiemTraSoDu();
    }
}
