/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_9;

//import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public abstract class TaiKhoan {
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected double soDu=0;
    protected String matKhau;
    protected List<LichSuGiaoDich> lichSuGiaoDich;
    
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public double getSoDu() {
        return soDu;
    }
    
    public TaiKhoan() {
        this.lichSuGiaoDich = new ArrayList<>();
    }

    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.matKhau = matKhau;
    }
    
    public String generateMaGiaoDich() {
        return "GD" + (lichSuGiaoDich.size() + 1);
    }

    public void themGiaoDich(String loaiGiaoDich, double soTien) {
        LichSuGiaoDich giaoDich=new LichSuGiaoDich(generateMaGiaoDich(), loaiGiaoDich, soTien, LocalDate.now());
        lichSuGiaoDich.add(giaoDich);
    }
    
    public void inLichSuGiaoDich(){
        System.out.println("Lich sử giao dịch");
        for(LichSuGiaoDich gd: lichSuGiaoDich){
            System.out.println(gd);
        }
    }
    
    public void guiTien(double tienGui){
        if(tienGui>0){
            this.soDu+=tienGui;
            System.out.println("Gửi tiền thành công:"+tienGui);
            themGiaoDich("Gửi tiền", tienGui);
        }
        else
            System.out.println("Tiền gửi không hợp lệ!");
        
    }
    
    public void kiemTraSoDu(){
        System.out.println("Số dư tài khoản là:"+this.soDu);
    }
    
    public abstract void rutTien(double tienRut);
    
    public void chuyenKhoan(TaiKhoan tk,double tienChuyenKhoan){ 
        
    }
    
    public double LaiXuat(){
        return 0;
    }
    
    public boolean kiemTraMatKhauManh(String matkhau) {
        if (matkhau.length() >= 5 
            &&matkhau.matches(".*[A-Z].*") 
            &&  matkhau.matches(".*[a-z].*")
            &&matkhau.matches(".*\\d.*") 
            && matkhau.matches(".*[!@#$%^&*()].*")) 
            return true;  
        return false;
    }
    public void nhap(Scanner scanner){
        System.out.print("Nhập số tài khoản:");
        this.soTaiKhoan=scanner.nextLine();
        System.out.print("Nhập chủ tài khoản:");
        this.chuTaiKhoan=scanner.nextLine();
        do{
            System.out.print("Nhập mật khẩu([A-Z]&&[a-z]&&[0-9]&&kí tự đăc biệt&&đủ 5 kí tự):");
            this.matKhau=scanner.nextLine();
            if(!kiemTraMatKhauManh(matKhau))
                System.out.println("Mật khẩu không hợp lệ!");
        }
        while(!kiemTraMatKhauManh(matKhau));
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
   
    public void in(){
        System.out.println("Số tài khoản:"+this.soTaiKhoan);
        System.out.println("Chủ tài khoản:"+this.chuTaiKhoan);
        System.out.println("Số dư:"+this.soDu);
        System.out.println("Mật khẩu:"+this.matKhau);
    }

    public boolean dangNhap(String stk,String mk){
        return this.soTaiKhoan.equals(stk)&&this.matKhau.equals(mk);
    }
    
    public boolean kiemTraMaPin(String maPin){
        return true;
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
}
