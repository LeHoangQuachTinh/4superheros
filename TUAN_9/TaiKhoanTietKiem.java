/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TaiKhoanTietKiem extends TaiKhoan{
    private double laiSuat;
    private Integer kyHan; 
    private LocalDate ngayGui; 

    public TaiKhoanTietKiem() {
    }

    public TaiKhoanTietKiem(double laiSuat, Integer kyHan, LocalDate ngayGui, String soTaiKhoan, String chuTaiKhoan, String matKhau) {
        super(soTaiKhoan, chuTaiKhoan, matKhau);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
        this.ngayGui = ngayGui;
    }

    private boolean daDenHan() {
        if (kyHan == null) {
            return true; 
        }
        LocalDate ngayDenHan = ngayGui.plusMonths(kyHan);
        return LocalDate.now().isAfter(ngayDenHan) || LocalDate.now().isEqual(ngayDenHan);
    }

    @Override
    public void rutTien(double tienRut) {
        if (!daDenHan())
            System.out.println("Chưa đến hạn rút tiền! Bạn phải chờ đến kỳ hạn " + kyHan + " tháng.");
        else 
            if (this.soDu < tienRut)
                System.out.println("Số dư không đủ để rút tiền!");
            else
                if(tienRut <=0)
                    System.out.println("Tiền rút không hợp lệ!");
                else {
                    this.soDu -= tienRut;
                    themGiaoDichThanhToan("Rút tiền", tienRut);
                    System.out.println("Bạn đã rút thành công: " + tienRut);
                }
    }

    @Override
    public double LaiXuat() {
        if(daDenHan())
            return super.soDu*this.laiSuat;
        return 0;
    }

    @Override
    public void nhap(Scanner scanner) {
        super.nhap(scanner); 
        System.out.print("Nhập lãi suất:");
        laiSuat=scanner.nextDouble();
        System.out.print("Nhập kỳ hạn(tháng):");
        this.kyHan=scanner.nextInt();
        scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Nhập ngày gửi(dd/MM/yyyy):");
        String ngayGuiStr=scanner.nextLine();
        this.ngayGui = LocalDate.parse(ngayGuiStr, formatter);
    }

    
    @Override
    public void in() {
        super.in(); 
        System.out.println("Ngày gửi:"+this.ngayGui);
        System.out.println("Kỳ hạn:"+this.kyHan);
        System.out.println("Lãi xuất:"+this.laiSuat);
        System.out.println("Tiền lãi suất là:"+LaiXuat());
    }
    
}
