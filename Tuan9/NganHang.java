package Tuan9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

abstract class NganHang{
    protected String stk;
    protected String chutk;
    private String matkhau;
    private String maOTP;
    protected double sodu;
    private Map<TaiKhoanThanhToan,TaiKhoanTietKiem> taiKhoanCon;
    protected boolean isLocked; 
    protected ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    protected int soLanNhapSai;
   
    public String lichSu="";
    
    public static  NganHang createAccount(String stk, String tentk, String matkhau, String maOTP) {
        return new NganHangNew(stk, tentk, matkhau, maOTP);
    }
    // Lớp con thực hiện chi tiết của NganHang
    private  static class NganHangNew extends NganHang {
        public NganHangNew(String stk, String tentk, String matkhau, String maOTP) {
            super(stk, tentk, matkhau, maOTP);
        }
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
        this.isLocked=false;
        this.soLanNhapSai=0;
        this.taiKhoanCon = new HashMap<>(); 
    }
    public int getSoLanNhapSai() {
        return soLanNhapSai;
    }
    public void setSoLanNhapSai(int soLanNhapSai) {
        this.soLanNhapSai = soLanNhapSai;
    }
    public boolean getLocket(){
        return this.isLocked;
    }
    public void setMaOTP(String maOTP) {
        this.maOTP = maOTP;
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
        System.out.printf("%-10s %-10s %-10s %-10s ₫ %15s\n",stk,chutk,this.matkhau,"***********",this.isLocked?"Bị khoá":"Bình thường");
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
    public void khoaTaiKhoan(int thoiGianKhoa,String thongBao) {
        isLocked = true;
        if(thongBao!="")
             System.out.printf("\n%s\n",thongBao);
        else
             System.out.println("\nTài khoản của bạn đã bị khóa trong " + thoiGianKhoa + " phút do nhập sai quá nhiều lần.");
       

        scheduler.schedule(() -> {
            isLocked = false;
            soLanNhapSai = 0;
            System.out.printf("\nTài khoản (%s,%s) đã được mở khóa. Bạn có thể đăng nhập lại.\n",this.stk,this.chutk);
        }, thoiGianKhoa, TimeUnit.MINUTES);
    }
    abstract void rutTien(double rut);
    abstract void napTiep(double tienNap);
    abstract double getSodu();
    abstract void setSodu(double tien);

}
