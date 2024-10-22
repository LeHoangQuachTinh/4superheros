/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baitaptuan6;

/**
 *
 * @author 123
 */
public class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;
    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }   
    public double getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(double chieuDai) {
        this.chieuDai = chieuDai;
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }
    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }
     public void hienThiThongTin() {
        System.out.println("Chieu dai: " + chieuDai + ", Chieu rong: " + chieuRong);
        System.out.println("Dien ttch: " + tinhDienTich());
        System.out.println("Chu vi: " + tinhChuVi());
    }
    public static void main(String[] args) {
    }
}

