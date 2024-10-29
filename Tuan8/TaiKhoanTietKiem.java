
package Tuan8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaiKhoanTietKiem extends NganHang {
    private double laiSuat;
    public LocalDate currenDateTK;
    public LocalDate thoihanDate;
    private double sodu;
    private int soThangGui=0;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public double getSodu() {
        return sodu;
    }

    TaiKhoanTietKiem() {
        this.sodu = 0.0;
        this.currenDateTK = LocalDate.now();
    }

    TaiKhoanTietKiem(String stk, String chutk, String matkhau, String maOTP) 
    {
        super(stk, chutk, matkhau, maOTP);
        this.sodu = 0.0;
        this.currenDateTK = LocalDate.now();
        this.thoihanDate=LocalDate.now();

    }

    TaiKhoanTietKiem(String stk, String chutk, String matkhau, String maOTP, double laiSuat) 
    {
        super(stk, chutk, matkhau, maOTP);
        this.laiSuat = laiSuat;
        this.currenDateTK = LocalDate.now();
    }
    public int getSoThangGui(){
        return this.soThangGui;
    }
    public void setSoThangGui(int month)   {
        this.soThangGui=month;
    }
    public double getTienTietKiem() {
        return this.sodu;
    }

    public void setTienTietKiem(double tienTietKiem) {
        this.sodu = tienTietKiem;
    }
    public void tinhLai() 
    {
        double tienLai = this.sodu * (laiSuat / 100);
        this.sodu += tienLai;
        System.out.printf("\nTiền lãi đã được cộng: %.2f₫.Vui lòng đợi đến hết hạn để gửi tiếp\n", tienLai);
    }
    public void setThoiHang(LocalDate thoihanDateNew){
        this.thoihanDate=thoihanDateNew;
    }

    @Override
    public void display() {
        System.out.printf("TaiKhoanTietKiem (%-10s %-20s %-10.2f₫)\n", this.getStk()+"TK", chutk, this.sodu);
    }
    public void napTiep(double tien) {
        if (tien >= 0) 
        {
            this.sodu += tien;
            System.out.printf("\nNạp vào tài khoản tiết kiệm thành công: %.0f₫\n", tien);
        } 
        else 
            System.out.println("\nSố tiền nạp không hợp lệ");
        
    }
    public void rutTien(double rut) {
        if (this.sodu >= rut) 
        {
            this.sodu -= rut;
            System.out.printf("\nRút từ tài khoản tiết kiệm thành công: %.0f₫\n", rut);
        } 
        else 
            System.out.println("\nSố tiền trong tài khoản tiết kiệm không đủ");
        
    }
    public void congTienLaiCoKyHan(int kihan) {
        switch (kihan) {
            case 3:
                this.laiSuat = 0.1;
                break;
            case 6:
                this.laiSuat = 0.2;
                break;
            case 12:
                this.laiSuat = 0.4;
                break;
            case 24:
                this.laiSuat = 0.6;
                break;
            default:
                System.out.println("Kỳ hạn không hợp lệ!");
                break;
        }
        this.tinhLai();
        this.thoihanDate = currenDateTK.plusMonths(kihan);
    }

    public double ThoiGianConLai() {
        return ChronoUnit.MONTHS.between(LocalDate.now(), this.thoihanDate);
    }
    public boolean ktThoiHan() {
        if(currenDateTK.compareTo(thoihanDate)>=0)
            return true;
        return false;
    }

    public void tienLaiHangNgay() {
        scheduler.schedule(() -> {
            this.sodu+= this.sodu * 0.001;
            System.out.println("Số dư sau khi cộng lãi hằng ngày: " + this.sodu);
        }, 1, TimeUnit.DAYS);
    } 
}
