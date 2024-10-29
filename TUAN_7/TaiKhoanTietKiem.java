/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_7;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */


public class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat;
    private Integer kyHan; 
    private LocalDate ngayGui; 

    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, String matKhau, String cccd, String sdt, double laiSuat, Integer kyHan) {
        super(soTaiKhoan, chuTaiKhoan, matKhau, cccd, sdt);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
        this.ngayGui = LocalDate.now();
    }

    private boolean daDenHan() {
        if (kyHan == null) {
            return true; 
        }
        LocalDate ngayDenHan = ngayGui.plusMonths(kyHan);
        return LocalDate.now().isAfter(ngayDenHan) || LocalDate.now().isEqual(ngayDenHan);
    }

    @Override
    public void guiTien(double tienGui) {
        if (tienGui > 0) {
            this.soDu += tienGui;
            
        } else {
            System.out.println("Số tiền gửi không hợp lệ!");
        }
    }

    @Override
    public void rutTien(double tienRut) {
        if (tienRut <= 0) 
            System.out.println("Số tiền rút không hợp lệ!");

        if (!daDenHan())
            System.out.println("Chưa đến hạn rút tiền! Bạn phải chờ đến kỳ hạn " + kyHan + " tháng.");
        
        else 
            if (this.soDu < tienRut)
                System.out.println("Số dư không đủ để rút tiền!");
            else {
                this.soDu -= tienRut;
                themgiaodich("Rút tiền: -" + tienRut);
                System.out.println("Bạn đã rút thành công: " + tienRut);
            }
    }

    @Override
    public void thongTinTaiKhoan() {
        System.out.println("Thông tin tài khoản tiết kiệm:");
        System.out.println("Chủ tài khoản: " + getChuTaiKhoan());
        System.out.println("Số tài khoản: " + soTaiKhoan);
        System.out.println("Số dư: " + soDu);
        System.out.println("Lãi suất: " + laiSuat + "%");
        if (kyHan != null) {
            System.out.println("Kỳ hạn: " + kyHan + " tháng");
            System.out.println("Ngày gửi: " + ngayGui);
        } 
        else 
            System.out.println("Loại tài khoản: Không kỳ hạn");
    }

  
}

