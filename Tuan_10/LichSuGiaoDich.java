/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan_10;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class LichSuGiaoDich {
    private String maGiaoDich;
    private String loaiGiaoDich;
    private double soTien;
    private LocalDate thoiGian;

    public LichSuGiaoDich() {
    }

    public LichSuGiaoDich(String maGiaoDich, String loaiGiaoDich, double soTien, LocalDate thoiGian) {
        this.maGiaoDich = maGiaoDich;
        this.loaiGiaoDich = loaiGiaoDich;
        this.soTien = soTien;
        this.thoiGian = thoiGian;
    }

    public double getSoTien() {
        return soTien;
    }

    public LocalDate getThoiGian() {
        return thoiGian;
    }

    @Override
    public String toString() {
        return "Giao dịch{" +
                "Mã giao dịch='" + maGiaoDich + '\'' +
                ", Loại giao dịch='" + loaiGiaoDich + '\'' +
                ", Số tiền=" + soTien +
                ", Thời gian giao dịch=" + thoiGian +
                '}';
    }
}
