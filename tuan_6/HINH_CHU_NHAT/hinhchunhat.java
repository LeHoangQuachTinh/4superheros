/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_6.HINH_CHU_NHAT;

/**
 *
 * @author Admin
 */
public class hinhchunhat {
    private double chieuDai;
    private double chieuRong;
    
    public void setChieuDai(double chieuDai) {
        this.chieuDai = chieuDai;
    }

    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }

    
    public double dienTich(){
        return this.chieuDai*this.chieuRong ;
    }
    public double chuVi(){
        return (this.chieuDai+this.chieuRong)*2;
    }
    public void in(){
        System.out.printf("Diện tích hình chữ nhật:%.3f",dienTich());
        System.out.println("");
        System.out.printf("Chu vi hình chữ nhật:%.3f",chuVi());
    }
}
