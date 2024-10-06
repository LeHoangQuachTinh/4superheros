/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bai02_tuan06;





/**
 *
 * @author DELL
 */
public class SINHVIEN {
    private String maSV;
    private String tenSV;
    private String ngaySinh;
    private double diemTrungBinh;

    public SINHVIEN(String maSV, String tenSV, String ngaySinh, double diemTrungBinh) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.ngaySinh = ngaySinh;
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    @Override
    public String toString() {
        return "Ma Sinh Vien: "+maSV+"\n"+
                "Ho va ten: "+tenSV+"\n"+
                "Ngay sinh: "+ngaySinh+"\n"+
                "Diem trung binh: "+diemTrungBinh+"\n"+
                "==============================";
    }
    
    
   
}
