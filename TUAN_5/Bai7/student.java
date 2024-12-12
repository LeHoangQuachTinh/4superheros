/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_5.Bai7;

/**
 *
 * @author Admin
 */
public class student {
    String maSinhVien;
    String ten;
    double diemTrungBinh;

    public student(String maSinhVien, String ten, double diemTrungBinh) {
        this.maSinhVien = maSinhVien;
        this.ten = ten;
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public String toString() {
        return "Mã sinh viên: " + maSinhVien + ", Tên: " + ten + ", Điểm trung bình: " + diemTrungBinh;
    }
}
