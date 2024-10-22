/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan6;
import java.util.Scanner;
/**
 *
 * @author 123
 */
public class SinhVien {
    private String maSV;
    private String ten;
    private String ngaySinh;
    private double diemTB;

    public SinhVien() {}

    public SinhVien(String maSV, String ten, String ngaySinh, double diemTB) {
        this.maSV = maSV;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ma sinh vien: ");
        maSV = scanner.nextLine();
        
        System.out.print("Nhap ten sinh vien: ");
        ten = scanner.nextLine();
        
        System.out.print("Nhap ngay sinh (dd/mm/yyyy): ");
        ngaySinh = scanner.nextLine();
        
        System.out.print("Nhap diem trung binh: ");
        diemTB = scanner.nextDouble();
    }
    
    public void hienThiThongTin() {
        System.out.println("Ma SV: " + maSV + ", Ten: " + ten + ", Ngay sinh: " + ngaySinh + ", Diem TB: " + diemTB);
    }
    public static void main(String[] args) {
        
    }
}
