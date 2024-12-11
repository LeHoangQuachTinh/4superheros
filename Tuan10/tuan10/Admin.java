package tuan10;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Admin {
    private String maQuanTri;
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private Hashtable<String, NganHang> DS;

    Admin() {
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
    public Hashtable<String, NganHang> getDS() {
        return this.DS;
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
        if (matkhau.length() < 5) 
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
    public static boolean kiemtraSDTHopLe(String SDT) {
        if (SDT.length() != 11 && SDT.length() != 10) 
            return false;
        if (SDT.matches(".*[A-Z].*") || SDT.matches(".*[a-z].*"))
            return false;
        if( SDT.charAt(0)!='0')
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
        String SDT;
        if(!this.kiemTraTrung(stk, tentk))
        {
            if(!Admin.kiemTraMatKhauHopLe(matkhau))
            {
                while (dem<=5 && !kiemTraMatKhauHopLe(matkhau)) 
                {
                    System.out.printf("Tạo mật khẩu cho tài khoản lần %d/5:",dem);
                    matkhau = sc.nextLine();
                    if(kiemTraMatKhauHopLe(matkhau))
                    {
                        do
                        {
                            System.out.print("Tạo số điện thoại để khôi phục:");
                            SDT=sc.nextLine();
                            if(kiemtraSDTHopLe(SDT))
                            {
                                NganHang account = NganHang.createAccount(stk, tentk, matkhau, SDT);

                                TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan(stk, tentk,matkhau,SDT) ;                 
                                TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem(stk, tentk,matkhau,SDT);
                                                        // tkThanhToan.truPhiThuongNien();
                                scheduler.scheduleAtFixedRate(
                                    tkThanhToan::truPhiThuongNien, 0, 365, TimeUnit.DAYS);
                                account.addTaiKhoanCon(tkThanhToan,tkTietKiem); 
                                this.addAcount(account);
                                System.out.printf("\nTài khoản vừa mới thêm là: Account(stk: %s, tentk: %s, matkhau: %s,sodu:50000₫)\n", stk, tentk,matkhau); 
                                break;
                            }
                            else
                                System.out.println("\nSai định dạng số điện thoại.Vui lòng thử lại\n");
                        }while(kiemtraSDTHopLe(SDT));
                    }
                    else
                        dem++;
                }
                if(dem>=5)
                    System.out.println("Tạo tài khoản không thành công!");
            }
            else
            {
                do
                {
                    System.out.print("Tạo số điện thoại để khôi phục:");
                    SDT=sc.nextLine();
                    if(kiemtraSDTHopLe(SDT)){
                        NganHang account = NganHang.createAccount(stk, tentk, matkhau, SDT);

                        TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan(stk, tentk,matkhau,SDT) ;                 
                        TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem(stk, tentk,matkhau,SDT);
                                                    // tkThanhToan.truPhiThuongNien();
                        scheduler.scheduleAtFixedRate(
                            tkThanhToan::truPhiThuongNien, 0, 365, TimeUnit.DAYS);
                        account.addTaiKhoanCon(tkThanhToan,tkTietKiem); 
                        this.addAcount(account);
                        System.out.printf("\nTài khoản vừa mới thêm là: Account(stk: %s, tentk: %s, matkhau: %s,sodu:50000₫)\n", stk, tentk,matkhau);
                        break;
                    }
                    else
                        System.out.println("\nSai định dạng số điện thoại.Vui lòng thử lại\n");
                }while(kiemtraSDTHopLe(SDT));
                
            }
        }
        else
            System.out.println("\nSố tài khoản hoặc tên tài khoản đã tồn tại. Vui lòng nhập lại!");
    }
    public void docFileTaiKhoan(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
    
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                if (line.contains(";")) {
                    String[] taikhoanInfo = line.split(";");
                    String stk = taikhoanInfo[0].trim();
                    String tentk = taikhoanInfo[1].trim();
                    String matkhau = taikhoanInfo[2].trim();
                    String SDT = taikhoanInfo[3].trim();
    
                    NganHang account = NganHang.createAccount(stk, tentk, matkhau, SDT);
                    TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan(stk, tentk,matkhau,SDT) ;                 
                    TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem(stk, tentk,matkhau,SDT);
                                            
                    scheduler.scheduleAtFixedRate(
                        tkThanhToan::truPhiThuongNien, 0, 365, TimeUnit.DAYS);
                    account.addTaiKhoanCon(tkThanhToan,tkTietKiem); 
                    this.addAcount(account);
                 
                }   
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số trong file: " + e.getMessage());
        }
    }
}
