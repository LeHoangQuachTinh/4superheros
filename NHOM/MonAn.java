/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NHOM;

/**
 *
 * @author Admin
 */
public class MonAn {
    String tenMon;
    double gia;
    int soLuong; 

    public String getTenMon() {
        return tenMon;
    }

    public double getGia() {
        return gia;
    }

    public MonAn(String tenMon, double gia, int soLuong) {
        this.tenMon = tenMon;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return tenMon + " - " + gia + " VND  " + soLuong + " = " + gia * soLuong + " VND";
    }
}
