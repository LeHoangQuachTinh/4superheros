/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_6.tkNganHang;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class taiKhoan {
    private String soTaiKhoan,chuTaiKhoan;
    private double soDu;

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }
    public void guiTien(double soTienGui){
        if(soTienGui<0)
            System.out.println("số tiền nạp tiền không đúng");
        else{
            this.soDu+=soTienGui;
            System.out.println("số tiền đã nạp:"+soTienGui+" Số dư hiện tại:"+this.soDu);
        }     
    }
    public void rutTien(double soTienRut){
        if(soTienRut<0||soTienRut>this.soDu)
            System.out.println("số tiền rút không hợp lệ");
        else{
            this.soDu-=soTienRut;
            System.out.println("đã rút :"+soTienRut+" số dư tài khoản:"+this.soDu);
            
        }
    }
    public void soDu(){
        System.out.println("số dư của tài khoản là:"+this.soDu);
    }
}
