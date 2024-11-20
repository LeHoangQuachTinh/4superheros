/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_9;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TaiKhoanThanhToan extends TaiKhoan{
    private String maPin;
    private double thauChi;
    
    public TaiKhoanThanhToan() {
    }

    public TaiKhoanThanhToan(String maPin, double thauChi, String soTaiKhoan, String chuTaiKhoan, String matKhau) {
        super(soTaiKhoan, chuTaiKhoan, matKhau);
        this.maPin = maPin;
        this.thauChi = thauChi;
    }

    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner); 
        System.out.print("Nhập mã pin:");
        this.maPin=scanner.nextLine();  
        System.out.print("Nhập thấu chi:");
        this.thauChi=scanner.nextDouble();
    }

    @Override
    public void in() {
        System.out.println("");
        System.out.println("Thông tin tài khoản thanh toán:"+soTaiKhoan);
        super.in(); 
        System.out.println("Mã pin:"+this.maPin);
        System.out.println("Thấu chi:"+this.thauChi);
    }   
    
    @Override
    public void rutTien(double tienRut) {
       if(tienRut<=super.soDu+this.thauChi){
            if(tienRut<=super.soDu)
                super.soDu-=tienRut;
            else{
                this.thauChi-=tienRut-super.soDu;
                super.soDu=0;
            }   
            System.out.println("Rút tiền thành công:"+tienRut);
            themGiaoDichThanhToan("Rút tiền", tienRut);
        }   
        else
            System.out.println("Số tiền rút không hợp lệ!");
    }    

    @Override
    public boolean kiemTraMaPin(String maPin) {
        return this.maPin.equals(maPin);
    }
    
    @Override
    public void chuyenKhoan(TaiKhoan tk, double tienChuyenKhoan) {
        tk.guiTien(tienChuyenKhoan);
        super.soDu-=tienChuyenKhoan;
        System.out.println("Chuyển khoản thành công:"+tienChuyenKhoan);
        themGiaoDichThanhToan("Chuyển khoản", tienChuyenKhoan);
    }
    
    
}
