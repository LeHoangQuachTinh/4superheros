package Tuan9;

import java.time.LocalDate;
import java.time.Year;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaiKhoanThanhToan extends NganHang {
    private double phiThuongNien;


    
    TaiKhoanThanhToan(){
        super();
        this.sodu=50000;
        this.isLocked=false;
        this.soLanNhapSai=0;
    }
    TaiKhoanThanhToan(String stk, String chutk, String matkhau, String maOTP) {
        super(stk, chutk, matkhau, maOTP);
        this.sodu=50000;
        this.isLocked=false;
        this.soLanNhapSai=0;
        this.phiThuongNien=5000;
  
    }
    TaiKhoanThanhToan(String stk, String chutk, String matkhau, String maOTP,double phiThuongNien){
        super(stk, chutk, matkhau, maOTP);
        this.phiThuongNien=phiThuongNien;
        this.sodu=50000;
    }
    @Override
    public  boolean getLocket(){
        return this.isLocked;
    }
    @Override
    public void display(){
        System.out.printf("TaiKhoanThanhToan(%-10s %-10s %-10.2f₫ %20s)\n",this.stk+"TT",chutk,this.sodu,this.isLocked?"Bị khoá":"Bình thường");
    }
    public void napTiep(double tien) 
    {
        if (tien > 0) 
        {
            this.sodu += tien;
            System.out.printf("\nNạp vào tài khoản thanh toán thành công: %.0f₫\n", tien);
        } 
        else 
            System.out.println("\nSố tiền nạp không hợp lệ");
    }
    @Override
    public void rutTien(double rut)
    {
        if (this.sodu >= rut) 
            this.sodu -= rut;
        else 
            System.out.println("\nSố tiền trong tài khoản tiết kiệm không đủ");
    }
    @Override
    public double getSodu(){
        return this.sodu;
    }
    @Override
    public void setSodu(double sodu) {
        this.sodu = sodu;
    }
    @Override
    public void khoaTaiKhoan(int thoiGianKhoa,String thongBao) {
        isLocked = true;
        System.out.println("\nChức năng thanh toán của bạn đã bị khóa trong " + thoiGianKhoa + " phút do nhập sai quá nhiều lần.");

        scheduler.schedule(() -> {
            this.isLocked = false;
            soLanNhapSai = 0;
            System.out.printf("\nChức năng tài khoản thanh toán của (%s,%s) đã được mở khóa.\n",this.stk,this.chutk);
        }, thoiGianKhoa, TimeUnit.MINUTES);
    }
    public void chuyenTien(TaiKhoanThanhToan tkNhan, double soTien) {
        if (soTien < 0) {
            System.out.println("\nSố tiền không hợp lệ!");
            return;
        }
        if (this.getSodu() >= soTien) 
        {
            this.setSodu(this.getSodu() - soTien); 
            tkNhan.setSodu(tkNhan.getSodu() + soTien);
            
            System.out.printf("\nChuyển thành công %.2f đ\n", soTien);
        } 
        else 
            System.out.println("\nSố tiền không đủ");
    }
    public void truPhiThuongNien() {
        // scheduler.scheduleAtFixedRate(() -> {
        //     this.sodu-=5000;
        //     System.out.println("Đã trừ phí thường niên 5K");
        // }, 365, TimeUnit.DAYS);
        this.scheduler.schedule(() -> {
            this.sodu-=phiThuongNien;
            System.out.println("\nĐã trừ phí thường niên 5K");
        }, 365, TimeUnit.DAYS);

    } 
}
