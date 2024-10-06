/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bai03_tuan06;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class TAIKHOAN {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private Scanner sc;
    
    //Constructor

    public TAIKHOAN(String soTaiKhoan, String chuTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.sc = new Scanner(System.in);
    }
    
    public TAIKHOAN() {
        this.sc=new Scanner(System.in);
    }
    
    public void nhapTK(){
        System.out.println("Nhap so tai khoan: ");
        soTaiKhoan=sc.nextLine();
        System.out.println("Nhap ten tai khoan: ");
        chuTaiKhoan=sc.nextLine();
        System.out.println("Nhap so du: ");
        soDu=sc.nextDouble();
    }
    public void inTK(){
        System.out.println(
                "TAI KHOAN\n"+
                "So tai khoan: "+this.soTaiKhoan+"\n"+
                "Chu tai khoan: "+this.chuTaiKhoan+"\n"+
                "So du: "+this.soDu+"\n"+
                "========================"
        );
    }
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }
    
    //Phương thức gửi tiền
    public void guiTien(){
        System.out.println("Nhap so tien can gui: ");
        double soTien = sc.nextDouble();
        if(soTien>0){
            this.soDu+=soTien;
            System.out.println("Gui tien thanh cong.\n"
                    + "So du hien tai cua ban la: "+this.soDu);
        }
        else {
            System.out.println("So tien phai lon hon 0!");
        }
    }
    
    //Phương thức rút tiền
    public void rutTien(){
        System.out.println("Nhap so tien can rut: ");
        double soTien = sc.nextDouble();
        if(soTien > 0 && soTien <= this.soDu){
            this.soDu -= soTien;
            System.out.println("Rut tien thanh cong\n"
                    + "So du hien tai cua ban la: "+this.soDu);
        }
        else
            System.out.println("Khong the rut !");
    }
   
    //Phương thức kiểm tra số dư
    public void kiemTra(){
        System.out.println("So du hien tai cua ban la: "+this.soDu);
    }
}
