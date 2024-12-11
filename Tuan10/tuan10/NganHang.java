package tuan10;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


abstract class NganHang{
    private String stk;
    protected String chutk;
    private String matkhau;
    private String maOTP;
    private String SDT;
    protected double sodu;
    private Map<TaiKhoanThanhToan,TaiKhoanTietKiem> taiKhoanCon;
    private boolean isLocked; 
    protected ScheduledExecutorService scheduler;
    protected ScheduledFuture<?> future,otpTask;
    protected String lichSu;


    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
    public static  NganHang createAccount(String stk, String tentk, String matkhau, String SDT) {
        return new NganHangNew(stk, tentk, matkhau, SDT);
    }
    // Dùng lớp này để tạo lớp cha NganHang
    private  static class NganHangNew extends NganHang {
        public NganHangNew(String stk, String tentk, String matkhau, String SDT) {
            super(stk, tentk, matkhau, SDT);
        }

        @Override
        void rutTien(double rut) {}

        @Override
        void napTiep(double tienNap) {}

        @Override
        void setSodu(double tien) {}

        @Override
        double getSodu() {
            return 0;
        }
    }
    NganHang(String stk,String chutk,String matkhau,String SDT)
    {
        this.stk=stk;
        this.chutk=chutk;
        this.matkhau=matkhau;
        this.SDT=SDT;
        this.isLocked=false;
        this.taiKhoanCon = new HashMap<>();
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
    public void setSDT(String SDT)
    {
        this.SDT=SDT;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
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
    public void addTaiKhoanCon(TaiKhoanThanhToan tkThanhToan,TaiKhoanTietKiem tkTietKiem) {
       this.taiKhoanCon.put(tkThanhToan, tkTietKiem);
     
    }
    public Map<TaiKhoanThanhToan,TaiKhoanTietKiem> getTaiKhoanCon() {
        return this.taiKhoanCon;
    }
    public void hienThi(){
        
        this.getTaiKhoanCon().keySet().iterator().next().hienThi();
        this.getTaiKhoanCon().get(this.getTaiKhoanCon().keySet().iterator().next()).hienThi();
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
                System.out.printf("\nTài khoản (%s,%s) đã được mở khóa. Bạn có thể đăng nhập lại.\n",this.stk,this.chutk);
            }, thoiGianKhoa, TimeUnit.MINUTES);
        }
        catch(Exception e){
            System.out.println("Lỗi khi mở khoá tài khoản chính:"+e.getMessage());
        }
    }
    
    public void TaoOTP() {

            maOTP = random.ints(6, 0, 10)
                          .mapToObj(String::valueOf)
                          .collect(Collectors.joining());
            System.out.printf("Mã OTP của bạn là: %s (Hiệu lực trong 2 phút)\n", maOTP);

            otpTask=scheduler.schedule(() -> {
                if(!otpTask.isCancelled())
                {
                    this.maOTP=null;
                    System.out.println("Mã OTP đã hết hiệu lực!");
                    HienThiLuaChon();
                }
            }, 2, TimeUnit.MINUTES);
    }

    private void HienThiLuaChon() {
           if(!otpTask.isCancelled())
           {
                System.out.println("Bạn có muốn gửi lại mã OTP? (1: Có, 2: Thoát)");
                int luaChon = sc.nextInt();
                if (luaChon == 1) 
                    TaoOTP();
                else {
                    System.out.println("Thoát chương trình...");
                    otpTask.cancel(true);
                    return;   
           }
       }

    }

    abstract void rutTien(double rut);
    abstract void napTiep(double tienNap);
    abstract double getSodu();
    abstract void setSodu(double tien);
    
}
