/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan5_1;
public class Student {
    private String maSV;
    private String ten;
    private double diemTB;

    public Student(String maSV, String ten, double diemTB) {
        this.maSV = maSV;
        this.ten = ten;
        this.diemTB = diemTB;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public void hienThiThongTin() {
        System.out.println("Ma SV: " + maSV + ", Ten: " + ten + ", Điem TB: " + diemTB);
    }
    public static void main(String[] args) {
        
    }
}



