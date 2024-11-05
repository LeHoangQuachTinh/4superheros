package Tuan9;
import java.util.Hashtable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class DSTaiKhoang {
    private String maQuanTri;
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    Hashtable<String, NganHang> DS;

   
    DSTaiKhoang() {
        this.DS= new Hashtable<>();
        this.maQuanTri="tinh123";//mã quản trị đầu tiên của Quản trị viên Tỉnh
    }
    public void addAcount(NganHang account) {
        this.DS.put(account.getStk(), account); 

    }
    public void deleteAccount(String stk)
    {
        this.DS.remove(stk);
    }
    public void showAccount() {
        this.DS.values().forEach(taikhoan -> taikhoan.display());
    }
    public boolean kiemtraMaQuanTri(String maQuanTri) {
        return this.maQuanTri.equals(maQuanTri);
    }  
    public void setMaQuanTri(String maQuanTri) {
        this.maQuanTri = maQuanTri;
    }  
    public boolean kiemTraTrung(String stk, String tentk) {
        if (DS.containsKey(stk)) 
        {
            System.out.println("\nSố tài khoản đã tồn tại!");
            return true;
        }
        
        for (NganHang account : DS.values()) 
        {
            if (account.chutk.equalsIgnoreCase(tentk)) 
            {
                System.out.println("Tên tài khoản đã tồn tại!");
                return true;
            }
        }
        return false;
    }
    public NganHang searchAcount(String stk) {
        return this.DS.get(stk);
    }  
    public static boolean kiemTraMatKhauHopLe(String matkhau) 
    {
        if (matkhau.length() < 1) 
            return false;
        if (!matkhau.matches(".*[A-Z].*")) 
            return false;
        if (!matkhau.matches(".*[a-z].*")) 
            return false;
        if (!matkhau.matches(".*\\d.*")) 
            return false;
        if (!matkhau.matches(".*[!@#$%^&*()].*")) 
            return false;
        return true;
    }
    public void dangKiTaiKhoan(){

        Scanner sc=new Scanner(System.in);
        System.out.print("Tạo số tài khoản: ");
        String stk = sc.nextLine();
        System.out.print("Tạo chủ tài khoản: ");
        String tentk = sc.nextLine();
        System.out.print("Tạo mật khẩu cho tài khoản(Mật khẩu phải chứa kí tự Hoa,Thường,Số,Kí tự đặt biệt và đủ 5 kí tự): ");
        String matkhau = sc.nextLine();
        int dem=1;
        String maOTP;
        if(!this.kiemTraTrung(stk, tentk))
        {
            if(!DSTaiKhoang.kiemTraMatKhauHopLe(matkhau))
            {
                while (dem<=5 && !kiemTraMatKhauHopLe(matkhau)) 
                {
                    System.out.printf("Tạo mật khẩu cho tài khoản lần %d/5:",dem);
                    matkhau = sc.nextLine();
                    if(kiemTraMatKhauHopLe(matkhau))
                    {
                        System.out.print("Tạo mã OTP:");
                        maOTP=sc.nextLine();
                        NganHang account = NganHang.createAccount(stk, tentk, matkhau, maOTP);

                        TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan(stk, tentk,matkhau,maOTP) ;                 
                        TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem(stk, tentk,matkhau,maOTP);
                                                // tkThanhToan.truPhiThuongNien();
                        scheduler.scheduleAtFixedRate(
                            tkThanhToan::truPhiThuongNien, 0, 365, TimeUnit.DAYS);
                        account.addTaiKhoanCon(tkThanhToan,tkTietKiem); 
                        this.addAcount(account);
                        System.out.printf("\nTài khoản vừa mới thêm là: Account(stk: %s, tentk: %s, matkhau: %s,sodu:50000₫)\n", stk, tentk,matkhau);  
                        break;
                    }
                    else
                        dem++;
                }
                if(dem>=5)
                    System.out.println("Tạo tài khoản không thành công!");
            }
            else
            {
                System.out.print("Tạo mã OTP:");
                maOTP=sc.nextLine();
                NganHang account = NganHang.createAccount(stk, tentk, matkhau, maOTP);

                TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan(stk, tentk,matkhau,maOTP) ;                 
                TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem(stk, tentk,matkhau,maOTP);
                                            // tkThanhToan.truPhiThuongNien();
                scheduler.scheduleAtFixedRate(
                    tkThanhToan::truPhiThuongNien, 0, 365, TimeUnit.DAYS);
                account.addTaiKhoanCon(tkThanhToan,tkTietKiem); 
                this.addAcount(account);
                System.out.printf("\nTài khoản vừa mới thêm là: Account(stk: %s, tentk: %s, matkhau: %s,sodu:50000₫)\n", stk, tentk,matkhau);
            }
        }
        else
            System.out.println("\nSố tài khoản hoặc tên tài khoản đã tồn tại. Vui lòng nhập lại!");
    }
}
