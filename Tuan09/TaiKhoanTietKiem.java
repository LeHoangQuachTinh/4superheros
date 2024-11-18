
package Tuan9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaiKhoanTietKiem extends NganHang {
    private double laiSuat;
    public LocalDate currenDateTK;
    private LocalDate thoihanDate;
    private int soThangGui;

   

    TaiKhoanTietKiem() {
        super();
        this.sodu = 0.0;
        this.currenDateTK = LocalDate.now();
    }

    TaiKhoanTietKiem(String stk, String chutk, String matkhau, String maOTP) 
    {
        super(stk, chutk, matkhau, maOTP);
        this.sodu = 0.0;
        this.currenDateTK = LocalDate.now();
        this.thoihanDate=LocalDate.now();
        this.soThangGui=0;
    }

    TaiKhoanTietKiem(String stk, String chutk, String matkhau, String maOTP, double laiSuat) 
    {
        super(stk, chutk, matkhau, maOTP);
        this.laiSuat = laiSuat;
        this.sodu = 0.0;
        this.currenDateTK = LocalDate.now();
        this.thoihanDate=LocalDate.now();
        this.soThangGui=0;
    }
   
    public int getSoThangGui(){
        return this.soThangGui;
    }
    public void setSoThangGui(int month)   {
        this.soThangGui=month;
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
    public void congTienLaiCoKyHan(int kihan) {
        switch (kihan) {
            case 3->this.laiSuat = 0.1;
            case 6->this.laiSuat = 0.2;
            case 12->this.laiSuat = 0.4;
            case 24->this.laiSuat = 0.6;
            default->
                System.out.println("Kỳ hạn không hợp lệ!");
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
        this.scheduler.schedule(() -> {
            this.sodu+= this.sodu * 0.001;
            System.out.println("Số dư sau khi cộng lãi hằng ngày: " + this.sodu);
        }, 1, TimeUnit.DAYS);
    } 
    @Override
    public double getSodu() {
        return sodu;
    }
    @Override void setSodu(double soduNew){
        this.sodu=soduNew;
    }
    @Override
    public void display() {
        System.out.printf("TaiKhoanTietKiem (%-10s %-10s %-10.2f₫ %20s)\n", this.stk+"TK", chutk, this.sodu,this.isLocked?"Bị khoá":"Bình thường");
    }
    @Override
    public void napTiep(double tien) {
        if (tien >= 0) 
        {
            this.sodu += tien;
            System.out.printf("\nNạp vào tài khoản tiết kiệm thành công: %.0f₫\n", tien);
        } 
        else 
            System.out.println("\nSố tiền nạp không hợp lệ");
        
    }
    @Override
    public void rutTien(double rut) {
        if (this.sodu >= rut) 
        {
            this.sodu -= rut;
            System.out.printf("\nRút từ tài khoản tiết kiệm thành công: %.0f₫\n", rut);
        } 
        else 
            System.out.println("\nSố tiền trong tài khoản tiết kiệm không đủ");
        
    }
    
}
