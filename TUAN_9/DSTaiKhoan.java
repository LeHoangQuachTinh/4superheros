/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_9;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DSTaiKhoan {
    private HashMap<String,TaiKhoan> ds;

    public DSTaiKhoan() {
        ds=new HashMap<>();
    }

    public DSTaiKhoan(HashMap<String, TaiKhoan> ds) {
        this.ds = ds;
    }
    
    public void nhap(Scanner scanner){
        int c=1;
        while(c==1){
            System.out.println("");
            System.out.println("1.Thêm 1 tài khoản thanh toán!");
            System.out.println("2.Thêm 1 tài khoản tiết kiệm");
            System.out.print("Nhập lựa chọn của bạn:");
            int lc;
            lc=scanner.nextInt();
            System.out.println("");
            scanner.nextLine();
            TaiKhoan tk=null;
            switch(lc){
                case 1:
                    tk=new TaiKhoanThanhToan();
                    tk.nhap(scanner);
                    if(kiemTraTonTai(tk.getSoTaiKhoan())==null){
                        ds.put(tk.getSoTaiKhoan(), tk);
                        tk.in();
                    }
                    else
                        System.out.println("Số tài khoản đã tồn tại trong hệ thống!");
                    scanner.nextLine();
                    break;
                case 2:
                    tk=new TaiKhoanTietKiem();
                    tk.nhap(scanner);
                    if(kiemTraTonTai(tk.getSoTaiKhoan())==null){
                        ds.put(tk.getSoTaiKhoan(), tk);
                        tk.in();
                    }
                    else
                         System.out.println("Số tài khoản đã tồn tại trong hệ thống!");
                    break;                 
            }
            System.out.print("Bạn có muốn tiếp tục không? 1.Tiếp tục | 2.Dừng:");
            c=scanner.nextInt();
            if(c!=1){
                System.out.println("Kết thúc thêm tài khoản!");
                break;
            } 
        }
    }
    
    public TaiKhoan kiemTraTonTai(String stk){
        return ds.get(stk);
    }
    
    public boolean dangNhapTaiKhoan(String stk,String mk){
        TaiKhoan tk=ds.get(stk);
        return tk != null && tk.dangNhap(stk, mk);
    }

    public void InDsTaiKhoan_ThanhToan(){
        int i=0;
        System.out.println("Tài khoản thanh toán!");
        for(TaiKhoan tk:ds.values()){
            if(tk instanceof TaiKhoanThanhToan)
                System.out.println((i+1)+".Số tài khoản:"+tk.soTaiKhoan+"||Chủ tài khoản:"+tk.chuTaiKhoan);
        }    
    }
    
    public void InDsTaiKhoan_TietKiem(){
        int i=0;
        System.out.println("Tài khoản tiết kiệm!");
        for(TaiKhoan tk:ds.values()){
            if(tk instanceof TaiKhoanTietKiem)
                System.out.println((i+1)+".Số tài khoản:"+tk.soTaiKhoan+"||Chủ tài khoản:"+tk.chuTaiKhoan);
        }
    }
}
