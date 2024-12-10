package BT.NganHang;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TaiKhoanThanhToan extends TaiKhoan implements INganHang{
    private double phiThuongNien;
    private double laiSuatVay;
    private double soNo;
    private LocalDateTime thoiGianNo;
    private int soNgayHetHang;
    


    public TaiKhoanThanhToan(String stk, String chutk, String matkhau, String maOTP) {
        super(stk, chutk, matkhau, maOTP);
        this.sodu=50000;
        this.isLocked=false;
        this.phiThuongNien=100000;
        this.soNo=0.0;
        this.laiSuatVay=0.001;
        this.thoiGianNo=null;
        this.soNgayHetHang=30;
    }
    public double setLaiSuatVay(double laiSuatVay){
        return this.laiSuatVay=laiSuatVay;
    }
    public double getSoNo(){
        return this.soNo;
    }
    @Override
    public double getSodu(){
        return this.sodu;
    }
    @Override
    public void setSodu(double sodu) {
        this.sodu = sodu;
    }
    public void congTien(double tien){
        this.sodu+=tien;
    }
    @Override
    public void hienThi(){
        System.out.printf("TaiKhoanThanhToan(%-10s %-10s %-10.3f₫ %20s)\n",this.stk+"TT",chutk,this.sodu,this.isLocked?"Bị khoá":"Bình thường");
    }
    public void napTiep(double soTien) 
    {
        if (soTien > 0) 
        {
            System.out.printf("\nNạp vào tài khoản thanh toán thành công: %.0f₫\n", soTien);
            if(soNo>0)
            {
               
                if (soTien >= this.soNo) 
                {
                    soTien -= this.soNo;
                    this.soNo = 0;
                    this.thoiGianNo = null;
                    System.out.println("Bạn đã thanh toán xong số nợ.Có thể vay thêm!");
                } 
                else 
                {
                    this.soNo -= soTien;
                    soTien = 0;
                    System.out.printf("\nSố nợ còn lại của bạn là:%.0f đ\n",this.soNo);
                }  
            }
            this.sodu += soTien;
        } 
        else 
            System.out.println("\nSố tiền nạp không hợp lệ");
    }
    @Override
    public void rutTien(double rut)
    {
        if (this.sodu >= rut) 
        {
            this.sodu -= rut;
            System.out.printf("\nBạn đã rút thành công %.0f đ!\n",rut);
        }
        else 
            System.out.println("\nSố tiền trong tài khoản tiết kiệm không đủ");
    }
    public void congSoDu(double tien) {
        if (this.soNo > 0) 
        {
            if (tien >= this.soNo) 
            {
                tien -= this.soNo;
                this.soNo = 0;
                this.thoiGianNo = null;
            }
            else
            {
                this.soNo -= tien;
                return;
            }
        }
        this.sodu += tien;
    }
    @Override
    public void khoaChucNang(int thoiGianKhoa,String thongBao) {
        isLocked = true;
        System.out.println("\nChức năng thanh toán của bạn đã bị khóa trong " + thoiGianKhoa + " phút do nhập sai quá nhiều lần.");

        scheduler.schedule(() -> {
            this.moKhoa();
            System.out.printf("\nChức năng tài khoản thanh toán của (%s,%s) đã được mở khóa.\n",this.stk,this.chutk);
        }, thoiGianKhoa, TimeUnit.MINUTES);
    }
    public void chuyenTien(TaiKhoanThanhToan tkNhan, double soTien) {
        if (this.getSodu() >= soTien) 
        {
            this.setSodu(this.getSodu() - soTien); 
            tkNhan.congSoDu(soTien);        
            System.out.printf("\nChuyển thành công %.0f đ\n", soTien);
        } 
        else 
            System.out.println("\nSố tiền không đủ");
    }
    public void truPhiThuongNien() {
        try {
            scheduler.schedule(() -> {
                    this.sodu -= phiThuongNien;
                    System.out.println("\nĐã trừ phí thường niên 5K");
                }, 365, TimeUnit.DAYS);
        } 
        catch (Exception e) 
        {
            System.out.println("Lỗi khi lên lịch trừ phí thường niên: " + e.getMessage());
        }

    } 
    public void vayNo(double tienVay){
        this.soNo=tienVay;
        thoiGianNo=LocalDateTime.now().plusMonths(2);
        this.sodu+=tienVay;
        System.out.printf("\nBạn đã vay thành công %.0f đ.Thời hạn tối đa là 2 tháng!\n",tienVay);
    }
    public boolean kiemtraVay() {
        return (this.soNo == 0 && this.thoiGianNo == null && this.sodu<=500);
    }
    @Override
    public double ThoiGianConLai(){
        return ChronoUnit.DAYS.between(LocalDateTime.now(), thoiGianNo);
    }
    public void batDauGioiHanNo() {
        try {
            this.future = scheduler.scheduleAtFixedRate(this::kiemtraNo, 0, 1, TimeUnit.DAYS);
            this.soNo+=soNo*laiSuatVay;
        } 
        catch (Exception e) {
            System.out.println("Lỗi khi lên lịch kiểm tra nợ: " + e.getMessage());
        }
    }
    public void kiemtraNo(){
        if (soNo > 0 && thoiGianNo != null) 
        {
            if (this.ThoiGianConLai() > soNgayHetHang) 
            {
                isLocked = true;
                System.out.println("Tài khoản của bạn đã bị khoá do quá hạn!");
            }
            if (future != null)
                future.cancel(true);
        }   
    }
}
