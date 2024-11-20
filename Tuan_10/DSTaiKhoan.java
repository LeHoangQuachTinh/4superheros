/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan_10;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DSTaiKhoan {
    private HashMap<String,TaiKhoan> dsTaiKhoan;

    public DSTaiKhoan() {
        dsTaiKhoan =new HashMap<>();
    }
    public TaiKhoan kiemTraTonTai(String stk){
        return dsTaiKhoan.get(stk);
    }
    
    public void nhap_thanhToan(Scanner scanner,DsCCCD dsCCCD,DSTaiKhoan dstk){
        TaiKhoan tk=new TaiKhoanThanhToan();
        tk.nhap(scanner, dsCCCD,dstk);
        if(kiemTraTonTai(tk.getSoTaiKhoan())==null){
            dsTaiKhoan.put(tk.getSoTaiKhoan(), tk);
        }
        else
            System.out.println("Số tài khoản đã tồn tại trong hệ thống!");
    }
    
    public void InDsTaiKhoan_ThanhToan(){
        int i=0;
        System.out.println("Tài khoản thanh toán!");
        for(TaiKhoan tk:dsTaiKhoan.values()){
            if(tk instanceof TaiKhoanThanhToan){
                i++;
                System.out.println(i+".Số tài khoản:"+tk.soTaiKhoan+"||Chủ tài khoản:"+tk.chuTaiKhoan);  
            }
                
        }    
    }
    
    public void nhap_tietKiem(Scanner scanner,DsCCCD dsCCCD,DSTaiKhoan dstk){
        TaiKhoan tk=new TaiKhoanTietKiem();
        tk.nhap(scanner, dsCCCD,dstk);
        if(kiemTraTonTai(tk.getSoTaiKhoan())==null){
            dsTaiKhoan.put(tk.getSoTaiKhoan(), tk);
        }
        else
            System.out.println("Số tài khoản đã tồn tại trong hệ thống!");
    }
    
    public void InDsTaiKhoan_TietKiem(){
        int i=0;
        System.out.println("Tài khoản tiết kiệm!");
        for(TaiKhoan tk:dsTaiKhoan.values()){
            if(tk instanceof TaiKhoanTietKiem){
                i++;
                System.out.println(i+".Số tài khoản:"+tk.soTaiKhoan+"||Chủ tài khoản:"+tk.chuTaiKhoan);
            }
                
        }    
    }
    
    public boolean kiemTraCCCD(String cccd){
        for(TaiKhoan tk:dsTaiKhoan.values())
            if(tk.getCanCuocCongDan().equals(cccd))
                return false;
        return true;
    }
    
    public void xoa(Scanner scanner){
        System.out.print("Nhập số tài khoản cần xóa:");
        String stk =scanner.nextLine();
        if(kiemTraTonTai(stk)!=null){
            dsTaiKhoan.remove(stk);
            System.out.println("Xóa tài khoản thành công!");
        }
        else
            System.out.println("Số tài khoản cần xóa không tồn tại!");
    }
   
}
