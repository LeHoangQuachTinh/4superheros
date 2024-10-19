/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_7;
 
//import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class TaiKhoan {
    private String soTaiKhoan,chuTaiKhoan,matKhau;
    private double soDu=0;
    public double getSoDu() {
        return soDu;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }
    
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.matKhau = matKhau;
    }
    
    public void guiTien(double tienGui){
        if(tienGui>0){
            this.soDu+=tienGui;
            System.out.println("Bạn đã gửi thành công "+tienGui);
        }
        else
            System.out.println("Số tiền gửi không hợp lệ!");
    }
    
    public void rutTien(double tienRut){
        if(tienRut>0&&tienRut<=this.soDu){
            this.soDu-=tienRut;
            System.out.println("Bạn đã rút thành công "+tienRut);
        }
        else
            System.out.println("Tiền rút không hợp lệ!");
    }
    
    public void kiemTraSoDu(){
        System.out.println("Số dư trong tài khoản là:"+this.soDu);
    }
    
    public boolean kiemTraMatKhau(String matKhauCu){
        return this.matKhau.equals(matKhauCu);
    }
    
    public void doiMatKhau(String matKhauCu, String matKhauMoi){
        if (kiemTraMatKhau(matKhauCu)){
            this.matKhau=matKhauMoi;
            System.out.println("Đổi mật khẩu thành công!");
        }
    }
    public boolean dangNhap(String soTaiKhoan,String matKhau){
        return this.soTaiKhoan.equals(soTaiKhoan)&&this.matKhau.equals(matKhau);
    }
}
