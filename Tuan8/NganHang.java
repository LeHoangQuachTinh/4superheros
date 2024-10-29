package Tuan8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class NganHang{
    private String stk;
    public String chutk;
    private String matkhau;
    private String maOTP;
    private Map<TaiKhoanThanhToan,TaiKhoanTietKiem> taiKhoanCon;
    private boolean isLocked = false; 
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public int soLanNhapSai=0;

    
    public boolean getLocket(){
        return this.isLocked;
    }
    public void setMaOTP(String maOTP) {
        this.maOTP = maOTP;
    }
    NganHang(){
       this.taiKhoanCon = new HashMap<>();
    }
    NganHang(String stk,String chutk,String matkhau,String maOTP)
    {
        this.stk=stk;
        this.chutk=chutk;
        this.matkhau=matkhau;
        this.maOTP=maOTP;
        this.taiKhoanCon = new HashMap<>(); 
    }
    public String getStk(){
        return this.stk;
    }
    public void doiMatKhau(String MatKhauMoi){
        this.matkhau=MatKhauMoi;
        System.out.println("Mật khẩu mới của bạn là:"+this.matkhau);
    }
    public boolean kiemtraMatKhau(String matkhau){
        return this.matkhau.equals(matkhau);
    }
    public boolean kiemTraMaOTP(String maOTP){
        return this.maOTP.equals(maOTP);
    }
    public void display(){
        System.out.printf("%-10s %-10s %-10s₫      %-10s\n",stk,chutk,"***********",this.isLocked?"Bị khoá":"Bình thường");
    }
    public void addTaiKhoanCon(TaiKhoanThanhToan tkThanhToan,TaiKhoanTietKiem tkTietKiem) {
       this.taiKhoanCon.put(tkThanhToan, tkTietKiem);
     
    }
    public Map<TaiKhoanThanhToan,TaiKhoanTietKiem> getTaiKhoanCon() {
        return this.taiKhoanCon;
    }
    public void hienThi(){
        this.getTaiKhoanCon().keySet().iterator().next().display();
        this.getTaiKhoanCon().get(this.getTaiKhoanCon().keySet().iterator().next()).display();;
    }
    public void khoaTaiKhoan() {
        isLocked = true;
        System.out.println("Tài khoản của bạn đã bị khóa trong " + 5 + " phút do nhập sai quá nhiều lần.");

        scheduler.schedule(() -> {
            moKhoaTaiKhoan();
        }, 5, TimeUnit.MINUTES);
    }
    private void moKhoaTaiKhoan() {
        isLocked = false;
        soLanNhapSai = 0;
        System.out.printf("Tài khoản (%s,%s) đã được mở khóa. Bạn có thể đăng nhập lại.\n",this.stk,this.chutk);
    }
  
}
