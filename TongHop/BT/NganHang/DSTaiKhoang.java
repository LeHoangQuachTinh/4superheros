package BT.NganHang;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import BT.Dish;

public class DSTaiKhoang {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    Hashtable<String, TaiKhoan> DS;
    
    public DSTaiKhoang() {
        this.DS= new Hashtable<>();
        docFileTaiKhoan("D:\\DAIHOC\\KY_3\\TH_LTHDT\\BAI_THUC_HANH\\src\\TongHop\\BT\\NganHang\\taikhoan.txt");
    }
    public void addAcount(TaiKhoan account) {
        this.DS.put(account.getStk(), account); 

    }
    public boolean kiemTraTrung(String stk, String tentk) {
        if (DS.containsKey(stk)) 
        {
            System.out.println("\nSố tài khoản đã tồn tại!");
            return true;
        }
        
        for (TaiKhoan account : DS.values()) 
        {
            if (account.chutk.equalsIgnoreCase(tentk)) 
            {
                System.out.println("Tên tài khoản đã tồn tại!");
                return true;
            }
        }
        return false;
    }
    public TaiKhoan searchAcount(String stk) {
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
        String SDT;
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
                        System.out.print("Tạo số điện thoại để khôi phục:");
                        SDT=sc.nextLine();
                        TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan(stk, tentk,matkhau,SDT) ;                 
                        TaiKhoanThanhToan tkThanhToan1=(TaiKhoanThanhToan)(tkThanhToan);
                        scheduler.scheduleAtFixedRate(
                            tkThanhToan1::truPhiThuongNien, 0, 365, TimeUnit.DAYS);
                        DS.put(stk, tkThanhToan);
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
                System.out.print("Tạo số điện thoại để khôi phục:");
                SDT=sc.nextLine();

                TaiKhoan tkThanhToan = new TaiKhoanThanhToan(stk, tentk,matkhau,SDT) ;                 
                TaiKhoanThanhToan tkThanhToan1=(TaiKhoanThanhToan)(tkThanhToan);
                scheduler.scheduleAtFixedRate(
                    tkThanhToan1::truPhiThuongNien, 0, 365, TimeUnit.DAYS);
                DS.put(stk, tkThanhToan);
                System.out.printf("\nTài khoản vừa mới thêm là: Account(stk: %s, tentk: %s, matkhau: %s,sodu:50000₫)\n", stk, tentk,matkhau);
            }
        }
        else
            System.out.println("\nSố tài khoản hoặc tên tài khoản đã tồn tại. Vui lòng nhập lại!");
    }
    public void docFileTaiKhoan(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            TaiKhoan tk=null; // Keeps track of the current restaurant
    
            while ((line = reader.readLine()) != null) {
                line = line.trim();
    
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                if (line.contains(";")) {
                    String[] taikhoanInfo = line.split(";");
                    String stk = taikhoanInfo[0].trim();
                    String chutk = taikhoanInfo[1].trim();
                    String matkhau = taikhoanInfo[2].trim();
                    String SDT = taikhoanInfo[3].trim();
    
                    // Create a new Restaurant object
                    tk =new  TaiKhoanThanhToan(stk,chutk,matkhau,SDT);
                    this.DS.put(stk, tk);
                } 
                
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số trong file: " + e.getMessage());
        }
    }
}
