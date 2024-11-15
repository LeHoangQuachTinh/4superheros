/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan_10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TaiKhoanTietKiem extends TaiKhoan{
    private double laiSuat;
    private int kyHan; 
    private LocalDate ngayGui; 

    public TaiKhoanTietKiem() {
    }

    public TaiKhoanTietKiem(double laiSuat, int kyHan, LocalDate ngayGui, String canCuocCongDan, String soDienThoai, String soTaiKhoan, String chuTaiKhoan, String maKhau) {
        super(canCuocCongDan, soDienThoai, soTaiKhoan, chuTaiKhoan, maKhau);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
        this.ngayGui = ngayGui;
    }
    
    
    public boolean daDenHan() {
        if (kyHan == 0) {
            return true; 
        }
        LocalDate ngayDenHan = ngayGui.plusMonths(kyHan);
        return LocalDate.now().isAfter(ngayDenHan) || LocalDate.now().isEqual(ngayDenHan);
    }
    
    public double LaiXuat(){
        if(daDenHan())
            return super.soDu*this.laiSuat;
        return 0;
    }
    
    @Override
    public void nhap(Scanner scanner, DsCCCD dsCCCD, DSTaiKhoan dstk) {
        super.nhap(scanner, dsCCCD, dstk); 
        if(dsCCCD.kiemTraCanCuocCongDan(getCanCuocCongDan())!=null&&dstk.kiemTraCCCD(super.getCanCuocCongDan()))
        {
            System.out.print("Nhập lãi suất:");
            laiSuat=scanner.nextDouble();
            System.out.print("Nhập kỳ hạn(tháng):");
            this.kyHan=scanner.nextInt();
            scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.ngayGui = null;
            boolean tt = false;
            while (!tt) {
                System.out.print("Nhập ngày gửi (dd/MM/yyyy): ");
                String ngayGuiStr = scanner.nextLine();
                try {
                    this.ngayGui = LocalDate.parse(ngayGuiStr, formatter);
                    tt = true;  
                } catch (DateTimeParseException e) {
                    System.out.println("Ngày nhập không hợp lệ. Vui lòng nhập lại.");
                }
            }
        }  
    }

    @Override
    public void in() {
        super.in(); 
        System.out.println("Ngày gửi:"+this.ngayGui);
        System.out.println("Kỳ hạn:"+this.kyHan);
        System.out.println("Lãi xuất:"+this.laiSuat);
        System.out.println("Tiền lãi suất là:"+LaiXuat());
    }

    @Override
    public void guiTien(double tienGui) {
        if(super.dongMo){
            if(tienGui>0){
                this.soDu+=tienGui;
                System.out.println("Gửi tiền thành công:"+tienGui);
                themGiaoDich("Gửi tiền", tienGui);
            }
            else
                System.out.println("Tiền gửi không hợp lệ!");
        }
        else
            System.out.println("Tài khoản tiết kiệm đã bị đóng trước đó!");
            
    }
    
    @Override
    public void rutTien(double tienRut, Scanner scanner) {
        if(super.dongMo){
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
                        themGiaoDich("Rút tiền", tienRut);
                        System.out.println("Bạn đã rút thành công: " + tienRut);
                        System.out.print("Bạn có muốn in biên lai không? 1.Có , 2.Không: ");
                        int lc = scanner.nextInt();
                        if (lc == 1)
                            super.bienLai("Rút tiền", tienRut);
                    }
        }
        else
            System.out.println("Tài khoản tiết kiệm đã bị đóng trước đó!");
    }
    
    public void menu(){
        System.out.println("1.Cập nhật chủ tài khoản!");
        System.out.println("2.Cập nhật số điện thoại!");
        System.out.println("3.Cập nhật lại lãi suất!");
        System.out.println("4.Cập nhật lại kỳ hạn!");
        System.out.println("5.Cập nhật mật khẩu!");  
    }
    
    public void capNhat(Scanner scanner){
        int tt=1;
        while(tt==1){
            this.menu();
            System.out.print("Nhập lựa chọn của bạn:");
            int lc=scanner.nextInt();
            scanner.nextLine();
            switch(lc){
                case 1:
                    System.out.print("Nhập chủ tài khoản mới:");
                    String chuTaiKhoanMoi=scanner.nextLine();
                    super.setChuTaiKhoan(chuTaiKhoanMoi);
                    System.out.println("Cập nhật thành công!");
                    break;
                case 2:
                    System.out.print("Nhập số điện thoại mới:");
                    String soDienThoaiMoi =scanner.nextLine();
                    super.setSoDienThoai(soDienThoaiMoi);
                    System.out.println("Cập nhật thành công!");
                    break;
                case 3:
                    System.out.print("Nhập lãi suất mới:");
                    double laiSuatMoi =scanner.nextDouble();
                    this.laiSuat=laiSuatMoi;
                    System.out.println("Cập nhật thành công!");
                    break;
                case 4:
                    System.out.print("Nhập kỳ hạn mới:");
                    Integer kyHanMoi =scanner.nextInt();
                    this.kyHan=kyHanMoi;
                    System.out.println("Cập nhật thành công!");
                    break;
                case 5:
                    System.out.print("Nhập mật khẩu cũ:");
                    String matKhauCu =scanner.nextLine();
                    if(super.kiemTraMatKhau(matKhauCu)){
                        String matKhauMoi;
                        do{
                            System.out.print("Nhập mật khẩu([A-Z]&&[a-z]&&[0-9]&&kí tự đăc biệt&&đủ 5 kí tự):");
                            matKhauMoi=scanner.nextLine();
                            if(!kiemTraMatKhauManh(matKhauMoi))
                                System.out.println("Mật khẩu không hợp lệ!");
                        }
                        while(!kiemTraMatKhauManh(matKhauMoi));
                        super.setMaKhau(matKhauMoi);
                    }
                    else
                        System.out.println("Mật khẩu nhập cũ không hợp lệ!Không thể cập nhật");
                    break;
            }
            System.out.print("Bạn có muốn tiếp tục không? 1.Tiếp tục, 2.Dừng");
            tt=scanner.nextInt();
        }
    }
}
