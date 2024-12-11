package tuan10;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TaiKhoanTietKiem extends NganHang implements INganHang{
    private double laiSuatNganHan;
    private double laiSuatDaiHan;
    private LocalDate currenDateTK;
    private LocalDate thoihanDate;
    private int soThangGui;

    TaiKhoanTietKiem(String stk, String chutk, String matkhau, String maOTP) 
    {
        super(stk, chutk, matkhau, maOTP);
        this.sodu = 0.0;
        this.currenDateTK = LocalDate.now();
        this.thoihanDate=LocalDate.now();
        this.soThangGui=0;
        this.laiSuatDaiHan=0.001;
    }
    TaiKhoanTietKiem(String stk, String chutk, String matkhau, String maOTP, double laiSuatNganHan,double laiSuatDaiHan) 
    {
        super(stk, chutk, matkhau, maOTP);
        this.laiSuatNganHan = laiSuatNganHan;
        this.laiSuatDaiHan= laiSuatDaiHan;
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
    public double getLaiSuatDaiHan() {
        return laiSuatDaiHan;
    }
    public void setLaiSuatDaiHan(double laiSuatDaiHan) {
        this.laiSuatDaiHan = laiSuatDaiHan;
    }
    public void tinhLai() 
    {
        double tienLai = this.sodu * (laiSuatNganHan / 100);
        this.sodu += tienLai;
        System.out.printf("\nTiền lãi đã được cộng: %.3f₫.Vui lòng đợi đến hết hạn để gửi tiếp\n", tienLai);
    }
    public void setThoiHang(LocalDate thoihanDateNew){
        this.thoihanDate=thoihanDateNew;
    }
    public void congTienLaiCoKyHan(int kihan) {
        switch (kihan) {
            case 3->this.laiSuatNganHan = 0.1;
            case 6->this.laiSuatNganHan = 0.2;
            case 12->this.laiSuatNganHan = 0.4;
            case 24->this.laiSuatNganHan = 0.6;
            default->
                System.out.println("Kỳ hạn không hợp lệ!");
        }
        this.tinhLai();
        this.thoihanDate = currenDateTK.plusMonths(kihan);
    }
    @Override
    public double ThoiGianConLai() {
        return ChronoUnit.MONTHS.between(LocalDate.now(), this.thoihanDate);
    }
    public boolean ktThoiHan() {
        return (currenDateTK.compareTo(thoihanDate)>=0);

    }
    public boolean guiKhongKyHan(){
        if (future == null || future.isCancelled()) {                                                                        
            future = scheduler.scheduleAtFixedRate(
                    this::tienLaiHangNgay, 0, 1, TimeUnit.DAYS);
            System.out.println("\nBạn đã chọn thành công gửi không thời hạn.Lãi suất là "+ this.laiSuatDaiHan+" và được cộng vào số dư theo NGÀY\n");
            return true;
        } 
        return false;
    }
    public boolean huyGuiKhongKyHan(){
        if (future != null) 
        {
            future.cancel(true);
            future=null;
            System.out.println("\nBạn đã hủy bỏ gửi không kỳ hạn thành công!\n");
            return true;
        } 
        return false;
    }
    public int guiCoKyHan(int luachon){
        int month=0;
        if (this.ktThoiHan() && future==null) 
        {              
            switch (luachon) 
            {
                case 1 -> month = 3;
                case 2 -> month = 6;
                case 3 -> month = 12;
                case 4 -> month = 24;
                default ->
                {
                    System.out.println("Lựa chọn không đúng!");
                    return 0;
                }
            }
            scheduler.shutdown();
            this.setSoThangGui(month);
            this.currenDateTK=LocalDate.now();
            this.congTienLaiCoKyHan(month);
            return month;
        } 
        return 0;
    }
    public void tienLaiHangNgay() {
        try {
            this.scheduler.schedule(() -> {
                    this.sodu += this.sodu * laiSuatDaiHan;
                    System.out.println("Số dư sau khi cộng lãi hằng ngày: " + this.sodu);
            }, 1, TimeUnit.DAYS);
        } 
        catch (Exception e) {
            System.out.println("Lỗi khi lập lịch cộng lãi hằng ngày: " + e.getMessage());
        }
    }
    @Override
    public double getSodu() {
        return sodu;
    }
    @Override void setSodu(double soduNew){
        this.sodu=soduNew;
    }
    @Override
    public void hienThi() {
        System.out.printf("TaiKhoanTietKiem (%-10s %-10s %-10.3f₫ %20s)\n", this.getStk()+"TK", chutk, this.sodu,this.getLocket()?"Bị khoá":"Bình thường");
    }
    @Override
    public void napTiep(double tien) {
        if (tien >= 0) 
        {
            this.sodu += tien;
            System.out.printf("\nNạp vào tài khoản tiết kiệm thành công: %.0f₫\n", tien);
            super.ThemLichSu("\nBạn đã nộp tiền vào tài khoản tiết kiệm "+tien+"00đ lúc "+LocalDateTime.now().format(formatter).toString());
        } 
        else 
            System.out.println("\nSố tiền nạp không hợp lệ");
    }
    @Override
    public void rutTien(double rut) {
        if (this.sodu >= rut) 
        {
            if(rut>0)
            {
                this.sodu -= rut;
                System.out.printf("\nRút từ tài khoản tiết kiệm thành công: %.0f₫\n", rut);
                super.ThemLichSu("\nBạn đã rút "+rut+"00đ từ tài khoản tiết kiệm về tài khoản thanh toán lúc "+LocalDateTime.now().format(formatter).toString());
            }
            else
                System.out.println("\nSố tiền rút không hợp lệ!");
        } 
        else 
            System.out.println("\nSố tiền trong tài khoản tiết kiệm không đủ");
    }
    @Override
    public void khoaChucNang(int thoiGianKhoa,String thongBao) {
       this.setLocked(true);
        System.out.println("\nChức năng tiết kiệm của bạn đã bị khóa trong " + thoiGianKhoa + " phút do nhập sai quá nhiều lần.");
        try{
            scheduler.schedule(() -> {
                this.moKhoa();
                System.out.printf("\nChức năng tài khoản tiết kiệm của (%s,%s) đã được mở khóa.\n",this.getStk(),this.chutk);
            }, thoiGianKhoa, TimeUnit.MINUTES);
        }
        catch(Exception e)
        {
            System.out.println("Lỗi khi Mở khoá tài khoản:"+e.getMessage());
        }
    }
}
