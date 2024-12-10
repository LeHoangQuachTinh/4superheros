package BT.NganHang;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public abstract class TaiKhoan{
    protected String stk;
    protected String chutk;
  
    private String matkhau;
    private String maOTP;
    private String SDT;
    protected double sodu;
    protected boolean isLocked; 
    protected ScheduledExecutorService scheduler;
    protected ScheduledFuture<?> future;
    protected String lichSu;
    Scanner sc = new Scanner(System.in);
        Random random = new Random();
    
    TaiKhoan(String stk,String chutk,String matkhau,String SDT)
    {
        this.stk=stk;
        this.chutk=chutk;
        this.matkhau=matkhau;
        this.SDT=SDT;
        this.isLocked=false;
        this.lichSu="";
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.future = null;
    }
    public void ThemLichSu(String str){
        this.lichSu+=str;
    }
    public boolean getLocket(){
        return this.isLocked;
    }
    public String getStk(){
        return this.stk;
    }
    public String getChutk() {
        return chutk;
    }
    public void setSDT(String SDT)
    {
        this.SDT=SDT;
    }
    public boolean ktSDT(String SDT)
    {
        return this.SDT.equals(SDT);
    }
    public void doiMatKhau(String MatKhauMoi){
        this.matkhau=MatKhauMoi;
        System.out.println("\nĐổi mật khẩu thành công.Mật khẩu mới của bạn là:"+this.matkhau);
    }
    public boolean kiemtraMatKhau(String matkhau){
        return this.matkhau.equalsIgnoreCase(matkhau);
    }
    public boolean kiemTraMaOTP(String maOTP){
        if(this.maOTP==null)
            return false;
        else
            return this.maOTP.equalsIgnoreCase(maOTP);
    }
    public void display(){
        System.out.printf("%-10s %-10s %-10s %-10s ₫ %15s\n",stk,chutk,this.matkhau,"***********",this.isLocked?"Bị khoá":"Bình thường");
    }

    public void moKhoa(){
        this.isLocked=false;
    }
    public void khoaTaiKhoan(int thoiGianKhoa,String thongBao) {
        isLocked = true;
        if(thongBao!="")
             System.out.printf("\n%s\n",thongBao);
        else
             System.out.println("\nTài khoản của bạn đã bị khóa trong " + thoiGianKhoa + " phút do nhập sai quá nhiều lần.");
        try{
            scheduler.schedule(() -> {
                this.moKhoa();
                // soLanNhapSai = 0;
                System.out.printf("\nTài khoản (%s,%s) đã được mở khóa. Bạn có thể đăng nhập lại.\n",this.stk,this.chutk);
            }, thoiGianKhoa, TimeUnit.MINUTES);
        }
        catch(Exception e){
            System.out.println("Lỗi khi mở khoá tài khoản chính:"+e.getMessage());
        }
    }
    public void TaoOTP() {
   
        String otp = random.ints(6, 0, 9)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining());
        this.maOTP = otp;
        System.out.printf("\nMã OTP của bạn là %s!\n", otp);
    }
    abstract void rutTien(double rut);
    abstract void napTiep(double tienNap);
    abstract double getSodu();
    abstract void setSodu(double tien);

}
