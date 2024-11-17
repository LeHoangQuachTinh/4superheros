/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan6;

/**
 *
 * @author 123
 */
public class MainTaiKhoan {
    public static void main(String[] args) {
        TaiKhoan tk = new TaiKhoan("123456789", "Nguyen Van A", 1000000);
        tk.kiemTraSoDu();
        tk.guiTien(500000);
        tk.rutTien(200000);
        tk.kiemTraSoDu();
    }
}
