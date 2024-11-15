/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan_10;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public abstract class TaiKhoan implements ITaiKhoan{
    private String canCuocCongDan;
    protected String soDienThoai;
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected double soDu=0;
    private String maKhau;
    protected List<LichSuGiaoDich> lichSuGiaoDich;
    protected boolean dongMo=true;

    public TaiKhoan() {
        this.lichSuGiaoDich=new ArrayList<>();
    }

    public TaiKhoan(String canCuocCongDan, String soDienThoai, String soTaiKhoan, String chuTaiKhoan, String maKhau) {
        this.canCuocCongDan = canCuocCongDan;
        this.soDienThoai = soDienThoai;
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.maKhau = maKhau;
    }

    public double getSoDu() {
        return soDu;
    }
    

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }

    public void setMaKhau(String maKhau) {
        this.maKhau = maKhau;
    }

    public void dongTaiKhoan(){
        this.dongMo=false;
        System.out.println("Tài khoản:"+this.soTaiKhoan+" đã được đóng!");
    }
    
    public void moTaiKhoan(){
        this.dongMo=true;
        System.out.println("Tài khoản:"+this.soTaiKhoan+" đã được mở lại!");
    }

    public String MaGiaoDich() {
        return "GD" + (lichSuGiaoDich.size() + 1);
    }

    public void themGiaoDich(String loaiGiaoDich, double soTien) {
            LichSuGiaoDich giaoDich=new LichSuGiaoDich(MaGiaoDich(), loaiGiaoDich, soTien, LocalDate.now());
            lichSuGiaoDich.add(giaoDich);
        }
    
    public void inLichSuGiaoDich(){
        System.out.println("Lich sử giao dịch");
        for(LichSuGiaoDich gd: lichSuGiaoDich){
            System.out.println(gd);
        }
    }

    @Override
    public void bienLai(String tinhTrang, double soTien){
        System.out.println("Ngân hàng:QuyenBank!");
        System.out.println("Số tài khoản:"+this.soTaiKhoan);
        System.out.println("Ngày giờ giao dịch"+LocalDate.now());
        System.out.println("Số tiền "+tinhTrang+" :"+soTien);
        System.out.println("Số dư sau giao dịch"+soDu());
    }

    @Override
    public double soDu(){
        return this.soDu;
    }

    @Override
    public abstract void rutTien(double tienRut, Scanner scanner);

    @Override
    public abstract void guiTien(double tienGui);

    public String random(int so){
        SecureRandom random=new SecureRandom();
        StringBuilder otp=new StringBuilder();
        for(int i=0;i<so;i++){
            int soOtp=random.nextInt(10);
            otp.append(soOtp);
        }
        return otp.toString();
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
    
    public void nhap(Scanner scanner,DsCCCD dsCCCD,DSTaiKhoan dstk){
        System.out.print("Nhập căn cước công dân:");
        this.canCuocCongDan=scanner.nextLine();
        if(dsCCCD.kiemTraCanCuocCongDan(canCuocCongDan) != null&&dstk.kiemTraCCCD(canCuocCongDan))
        {
            System.out.print("Nhập số điện thoại:");
            this.soDienThoai=scanner.nextLine();
            String otp=random(6);
            System.out.println("Mã otp:"+otp);
            String OTP;
            do{
                System.out.print("Nhập mã otp:");
                 OTP =scanner.nextLine();
                 if(!OTP.equals(otp))
                     System.out.println("Nhập sai otp! Nhập lại");
            }
            while(!OTP.equals(otp));
            
            if(OTP.equals(otp)){
                do{
                   System.out.print("Tạo số tài khoản:");
                   this.soTaiKhoan=scanner.nextLine();
                   if(dstk.kiemTraTonTai(this.soTaiKhoan)!=null)
                        System.out.println("Số tài khoản tồn tại trong hệ thống!Nhập lại!");
                }
                while(dstk.kiemTraTonTai(this.soTaiKhoan)!=null);
                System.out.print("Tạo chủ tài khoản:");
                this.chuTaiKhoan=scanner.nextLine();
                do{
                    System.out.print("Tạo mật khẩu([A-Z]&&[a-z]&&[0-9]&&kí tự đăc biệt&&đủ 5 kí tự):");
                    this.maKhau=scanner.nextLine();
                    if(!kiemTraMatKhauManh(this.maKhau))
                        System.out.println("Mật khẩu không hợp lệ!");
                }
                while(!kiemTraMatKhauManh(this.maKhau));
            }
        }
        else
            System.out.println("Số căn cước công dân không tồn tại hoặc số căn cước đã được sử dụng!");
    }
    
    public void in(){
        System.out.println("Số tài khoản:"+this.soTaiKhoan);
        System.out.println("Chủ tài khoản:"+this.chuTaiKhoan);
        System.out.println("Số dư:"+this.soDu);
        System.out.println("Mật khẩu:"+this.maKhau);
    }
    

    public boolean dangNhap(String stk ,String mk){
        return this.soTaiKhoan.equals(stk) && this.maKhau.equals(mk);
    }
      
    public boolean kiemTraMatKhau(String matKhauCu){
        return this.maKhau.equals(matKhauCu);
    }
    
}
