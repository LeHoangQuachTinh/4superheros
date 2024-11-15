/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan_10;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TaiKhoanThanhToan extends TaiKhoan {
    private String maPin;
    private double thauChi;
    private double thauChiDaDung=0;

    public void setMaPin(String maPin) {
        this.maPin = maPin;
    }

    public String getMaPin() {
        return maPin;
    }

    public double getThauChi() {
        return thauChi;
    }

    public double getThauChiDaDung() {
        return thauChiDaDung;
    }

    public TaiKhoanThanhToan() {
    }

    public TaiKhoanThanhToan(String maPin, double thauChi, String canCuocCongDan, String soDienThoai, String soTaiKhoan, String chuTaiKhoan, String maKhau) {
        super(canCuocCongDan, soDienThoai, soTaiKhoan, chuTaiKhoan, maKhau);
        this.maPin = maPin;
        this.thauChi = thauChi;
    }
    

    @Override
    public void nhap(Scanner scanner, DsCCCD dsCCCD,DSTaiKhoan dstk) {
        super.nhap(scanner, dsCCCD,dstk);
        if(dsCCCD.kiemTraCanCuocCongDan(getCanCuocCongDan())!=null&&dstk.kiemTraCCCD(super.getCanCuocCongDan())){
            System.out.print("Nhập mã pin:");
            this.maPin = scanner.nextLine();
            System.out.print("Nhập thấu chi:");
            this.thauChi = scanner.nextDouble();
        }
    }

    @Override
    public void in() {
        super.in();
        System.out.println("Mã pin:" + this.maPin);
        System.out.println("Thấu chi:" + this.thauChi);
    }

    public double kiemTraThauChi(double tienGui){
        if(this.thauChiDaDung>0)
            if(tienGui<=this.thauChiDaDung){
                this.thauChiDaDung-=tienGui;
                tienGui=0;
            }
            else{
                tienGui-=this.thauChiDaDung;
                this.thauChiDaDung=0;
            }
        return tienGui;
    }
    
    public void inThongBaoGuiTien(int tinhTrang,double tienGui, double tienGui1) {
        if(tinhTrang==0)
            System.out.println("Tài khoản đã bị đóng trước đó không thể thực hiện giao dịch!");
        else{
            if(tienGui<=0)
                System.out.println("Số tiền gửi không hợp lệ!");
            else
                if(tienGui1==0){
                    System.out.println("Gửi tiền thành công:"+tienGui);
                    System.out.println("Số tiền " + tienGui + " đã được trừ hết vào thấu chi!");
                }  
                else{
                    System.out.println("Gửi tiền thành công:"+tienGui);
                    System.out.println("Số tiền gửi thật sự: " + tienGui + " | Số tiền đã được bù vào thấu chi: " + (tienGui-tienGui1));
                }
        }
    }

    @Override
    public void guiTien(double tienGui) {
        double tienGui1=kiemTraThauChi(tienGui);
        if (super.dongMo) {
            if (tienGui > 0) {
                if (tienGui1 == 0)
                    themGiaoDich("Gửi tiền", tienGui);
                else {
                    super.soDu+=tienGui1;
                    themGiaoDich("Gửi tiền", tienGui);
                }
                inThongBaoGuiTien(1,tienGui, tienGui1);
            } 
            else 
                inThongBaoGuiTien(1,tienGui,tienGui1); 
        } 
        else 
            inThongBaoGuiTien(0,tienGui, tienGui1);
    }
    
    public Double tinhTongTienGiaoDichTrongNgay() {
        Double tienHomNay = 0.0;
        for (LichSuGiaoDich lichSuGiaoDich : super.lichSuGiaoDich)
            if (lichSuGiaoDich.getThoiGian().equals(LocalDate.now())) 
                tienHomNay += lichSuGiaoDich.getSoTien();
        return tienHomNay;
    }
    
    public boolean rutTienThucTe(double tienRut) {
        if (tienRut <= super.soDu + (this.thauChi - this.thauChiDaDung)) {
            if (tienRut <= super.soDu)
                super.soDu -= tienRut;
            else {
                this.thauChiDaDung += tienRut - super.soDu;
                super.soDu = 0;
            }
            themGiaoDich("Rút tiền", tienRut);
            return true;
        }
        return false;
    }
    
    public void inThongBaoRutTien(int maThongBao, double tienRut) {
        switch (maThongBao) {
            case -1:
                System.out.println("Vượt quá giới hạn giao dịch trong ngày.");
                break;
            case -2:
                System.out.println("Số tiền rút không hợp lệ!");
                break;
            case -3:
                System.out.println("Tài khoản đã bị đóng trước đó không thể thực hiện giao dịch!");
                break;
            case 1:
                System.out.println("Rút tiền thành công: " + tienRut);
                break;
        }
    }
    
    @Override
    public void rutTien(double tienRut, Scanner scanner) {
        if (super.dongMo) {
            Double tienTrongNgay = tinhTongTienGiaoDichTrongNgay();
            if (tienTrongNgay + tienRut >= 10000000) 
                inThongBaoRutTien(-1, tienRut);
            else 
                if (rutTienThucTe(tienRut)){
                    inThongBaoRutTien(1, tienRut);
                    System.out.print("Bạn có muốn in biên lai không? 1.Có , 2.Không: ");
                    int lc = scanner.nextInt();
                    if (lc == 1)
                        super.bienLai("Rút tiền", tienRut);
                } 
                else
                    inThongBaoRutTien(-2, tienRut);
        } 
        else 
            inThongBaoRutTien(-3, tienRut);
    }
    
    public void nhanTienChuyenKhoan(double soTien) {
        double tienNhanChuyenKhoan=kiemTraThauChi(soTien);
        themGiaoDich("Nhận chuyển khoản", soTien);
    }
    
    public void inThongBaoChuyenKhoan(int tinhTrang,double tienGui) {
        if(tinhTrang==0)
            System.out.println("Tài khoản đã bị đóng trước đó không thể thực hiện giao dịch!");
        else{
            if(tienGui<=0)
                System.out.println("Số tiền chuyển khoản không hợp lệ!");
            else
                System.out.println("Chuyển khoản thành công:"+tienGui);
        }
    }
    
    public void chuyenKhoan(TaiKhoan tk, double tienChuyenKhoan) {
        if (super.dongMo) {
            if (tienChuyenKhoan <= super.soDu + (this.thauChi - this.thauChiDaDung)) {
                if (tienChuyenKhoan <= super.soDu) {
                    super.soDu -= tienChuyenKhoan;
                    ((TaiKhoanThanhToan) tk).nhanTienChuyenKhoan(tienChuyenKhoan); 
                } 
                else 
                {
                    this.thauChiDaDung += tienChuyenKhoan - super.soDu;
                    super.soDu = 0;
                    ((TaiKhoanThanhToan) tk).nhanTienChuyenKhoan(tienChuyenKhoan);
                }
                inThongBaoChuyenKhoan(1, tienChuyenKhoan);
                themGiaoDich("Chuyển khoản", tienChuyenKhoan);
            } 
            else
                inThongBaoChuyenKhoan(1, tienChuyenKhoan);
        } 
        else 
            inThongBaoChuyenKhoan(0, tienChuyenKhoan);
    }

    
    public void menu(){
        System.out.println("1.Cập nhật chủ tài khoản!");
        System.out.println("2.Cập nhật số điện thoại!");
        System.out.println("3.Cập nhật mã pin");
        System.out.println("4.Cập nhật mật khẩu!");  
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
                    System.out.print("Nhập mã pin mới:");
                    String maPinMoi =scanner.nextLine();
                    this.maPin=maPinMoi;
                    System.out.println("Cập nhật mã pin mới thành công!");
                    break;
                case 4:
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
