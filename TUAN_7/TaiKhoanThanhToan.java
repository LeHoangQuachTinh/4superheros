/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_7;

/**
 *
 * @author Admin
 */
public class TaiKhoanThanhToan extends TaiKhoan{
//    private String theThanhToan;
    private String maPin;
//    private double tienLai,phiThuongNien;
    
    

    public TaiKhoanThanhToan(String maPin, String soTaiKhoan, String chuTaiKhoan, String matKhau, String cccd, String sdt) {
        super(soTaiKhoan, chuTaiKhoan, matKhau, cccd, sdt);
        this.maPin = maPin;
    }

    @Override
    public void chuyenKhoan(TaiKhoan tk, double tienChuyenKhoan) {
        if(tienChuyenKhoan>0){
            this.soDu-=tienChuyenKhoan;
            tk.guiTien(tienChuyenKhoan);
            themgiaodich("Chuyển khoản: -" + tienChuyenKhoan);
            System.out.println("Bạn đã chuyển khoản thành công "+tienChuyenKhoan);
        }
        else
            System.out.println("Số tiền gửi không hợp lệ!");
    }

    @Override
    public boolean kiemTraMaPin(String maPin) {
        return this.maPin.equals(maPin);
    }

    
}
