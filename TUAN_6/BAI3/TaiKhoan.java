/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_6.BAI3;

/**
 *
 * @author Admin
 */
public class TaiKhoan {
    String soTaiKhoan;
    String chuTaiKhoan;
    double soDu;

    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
    }

    public void guiTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Đã gửi " + soTien + " vào tài khoản.");
        } else {
            System.out.println("Số tiền gửi không hợp lệ.");
        }
    }

    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Đã rút " + soTien + " từ tài khoản.");
        } else if (soTien > soDu) {
            System.out.println("Số dư không đủ để rút.");
        } else {
            System.out.println("Số tiền rút không hợp lệ.");
        }
    }

    public void kiemTraSoDu() {
        System.out.println("Số dư tài khoản: " + soDu);
    }
}
