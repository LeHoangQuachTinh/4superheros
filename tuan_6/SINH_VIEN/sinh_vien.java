/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_6.SINH_VIEN;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class sinh_vien {
    
    private String msv,ten ;
    private String ngaySinh;
    private double dtb;

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }
    
    public void nhap(){
        Scanner sc =new Scanner(System.in);
        System.out.print("nhập mã sinh viên:");
        setMsv(sc.nextLine());
        System.out.print("nhập tên sinh viên:");
        setTen(sc.nextLine());
        System.out.print("nhập ngày sinh:");
        setNgaySinh(sc.nextLine());
        System.out.print("nhập điểm trung bình:");
        setDtb(sc.nextDouble());
        
    }
    public void in(){
        System.out.println("mã sinh viên:"+this.msv);
        System.out.println("tên sinh viên:"+this.ten);
        System.out.println("ngày sinh:"+this.ngaySinh);
        System.out.println("điểm trung bình:"+this.dtb);
        
        
    }
    
    public void sapXep(){
        
    }
}
