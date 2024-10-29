package Tuan8;

import java.time.LocalDate;
import java.time.Year;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaiKhoanThanhToan extends NganHang {
    public double phiThuongNien;
    public double thoigian;
    public LocalDate currentDateTT;
    private double sodu;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private boolean isLocked = false; 
    // public int soLanNhapSai=0;
    
    TaiKhoanThanhToan(){

    }
    TaiKhoanThanhToan(String stk, String chutk, String matkhau, String maOTP) {
        super(stk, chutk, matkhau, maOTP);
        this.sodu=50000;
        this.isLocked=false;
        this.soLanNhapSai=0;

        currentDateTT=LocalDate.now();
  
    }
    TaiKhoanThanhToan(double phiThuongNien,double thoigian){
        this.phiThuongNien=phiThuongNien;
        this.thoigian=thoigian;
        this.sodu=50000;
    }
    @Override
    public  boolean getLocket(){
        return this.isLocked;
    }
    @Override
    public void display(){
        System.out.printf("TaiKhoanThanhToan(%-10s %-20s %-10.2f₫)\n",this.getStk()+"TT",chutk,this.sodu);
    }
    public void napTiep(double tien) 
    {
        if (tien >= 0) 
        {
            this.sodu += tien;
            System.out.printf("\nNạp vào tài khoản thanh toán thành công: %.0f₫\n", tien);
        } 
        else 
            System.out.println("\nSố tiền nạp không hợp lệ");
    }
    public void rutTien(double rut)
    {
        if (this.sodu >= rut) 
            this.sodu -= rut;
        else 
            System.out.println("\nSố tiền trong tài khoản tiết kiệm không đủ");
    }
    public Double getSodu(){
        return this.sodu;
    }
    public void setSodu(double sodu) {
        this.sodu = sodu;
    }
    public void chuyenTien(TaiKhoanThanhToan tkNhan, double soTien) {
        if (soTien < 0) {
            System.out.println("Số tiền không hợp lệ!");
            return;
        }
        if (this.getSodu() >= soTien) 
        {
            this.setSodu(this.getSodu() - soTien); 
            tkNhan.setSodu(tkNhan.getSodu() + soTien);
            
            System.out.printf("Chuyển thành công %.2f đ\n", soTien);
        } 
        else 
            System.out.println("Số tiền không đủ");
    }
    @Override
    public void khoaTaiKhoan() {
        isLocked = true;
        System.out.println("Chức năng thanh toán của bạn đã bị khóa trong " + 5 + " phút do nhập sai quá nhiều lần.");

        scheduler.schedule(() -> {
            this.moKhoaTaiKhoan();
        }, 5, TimeUnit.MINUTES);
    }
    // @Override
    private void moKhoaTaiKhoan() {
        isLocked = false;
        soLanNhapSai = 0;
        System.out.printf("\nChức năng tài khoản thanh toán của (%s,%s) đã được mở khóa.\n",this.getStk(),this.chutk);
    }
    public void truPhiThuongNien() {
        // scheduler.scheduleAtFixedRate(() -> {
        //     this.sodu-=5000;
        //     System.out.println("Đã trừ phí thường niên 5K");
        // }, 365, TimeUnit.DAYS);
        scheduler.schedule(() -> {
            this.sodu-=5000;
            System.out.println("\nĐã trừ phí thường niên 5K");
        }, 365, TimeUnit.DAYS);

    } 
}
