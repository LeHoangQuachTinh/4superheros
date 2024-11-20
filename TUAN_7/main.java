/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_7;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class main {
    public static boolean kiemTraMatKhauManh(String matkhau) {
        if (matkhau.length() >= 5 &&matkhau.matches(".*[A-Z].*") &&  matkhau.matches(".*[a-z].*") &&matkhau.matches(".*\\d.*") && matkhau.matches(".*[!@#$%^&*()].*")) 
            return true;  
        return false;
        }
    public static void main(String[] args) {
        String soDienThoai,cccd,tenTK,matKhau,soTaiKhoan,maPin,otp,matKhauMoi;
        double tienGui,tienChuyenKhoan,tienRut,laiSuat;
        int kyHan;
        Scanner scanner=new Scanner(System.in);
        DanhSach ds=new DanhSach();
        while(true){
            System.out.println("---------------Menu---------------");
            System.out.println("1. Tài khoản thanh toán!");
            System.out.println("2. Tài khoản tiết kiệm!");
            System.out.println("0. Thoát chương trình!");
            System.out.println("");
            System.out.print("Nhập lựa chọn của bạn: ");
            int lc = scanner.nextInt();
            loop1:
            do {
            switch (lc) {
                case 1:
                    System.out.println("1. Đăng kí tài khoản thanh toán!");
                    System.out.println("2. Đăng nhập tài khoản thanh toán!");
                    System.out.println("0. Thoát");
                    System.out.println("");
                    System.out.print("Nhập lựa chọn của bạn: ");
                    int lc1 = scanner.nextInt();
                    
                    scanner.nextLine();
                    switch (lc1) {
                        case 1:
                            System.out.print("Nhập số điện thoại đăng kí: ");
                            soDienThoai = scanner.nextLine();
//                            System.out.print("Nhập mã otp: ");
//                            otp = scanner.nextLine();
                            System.out.print("Nhập căn cước công dân: ");
                            cccd = scanner.nextLine();
                            do {
                                System.out.print("Nhập số tài khoản: ");
                                soTaiKhoan = scanner.nextLine();
                                if (ds.kiemTraTonTai(soTaiKhoan) != null)
                                    System.out.println("Số tài khoản đã tồn tại trong hệ thống! Vui lòng nhập lại!");
                            } 
                            while (ds.kiemTraTonTai(soTaiKhoan) != null);
                            System.out.print("Nhập tên tài khoản đăng kí: ");
                            tenTK = scanner.nextLine();
                            do {
                                System.out.print("Nhập mật khẩu đăng kí:(Mật khẩu phải chứa kí tự Hoa,Thường,Số và đủ 5 kí tự) :");
                                matKhau = scanner.nextLine();
                            } 
                            while (!kiemTraMatKhauManh(matKhau));
                            System.out.print("Nhập mã pin khi thanh toán: ");
                            maPin = scanner.nextLine();
                            TaiKhoan tk = new TaiKhoanThanhToan(maPin, soTaiKhoan, tenTK, matKhau, cccd, soDienThoai);
                            ds.themTaiKhoanThanhToan(soTaiKhoan, tk);
                            System.out.println("Đã đăng ký thành công!");
                            System.out.println("");
                            System.out.println("Thông tin tài khoản vừa mới thêm là:");
                            System.out.printf("%-20s: %s\n", "Số tài khoản", soTaiKhoan);
                            System.out.printf("%-20s: %s\n", "Tên tài khoản", tenTK);
                            System.out.printf("%-20s: %s\n", "Mật khẩu", matKhau);
                            System.out.printf("%-20s: %s\n", "Căn cước công dân", cccd);
                            System.out.printf("%-20s: %s\n", "Số điện thoại", soDienThoai);
                            System.out.printf("%-20s: %s\n", "Mã PIN", maPin); 
                            System.out.println("----------------------------------------------");
                            break;                        
                        case 2:
                            int d=0;
                            boolean dangnhap = false;
                            do{
                                System.out.print("Nhập số tài khoản đăng nhập:");
                                soTaiKhoan=scanner.nextLine();
                                if(ds.kiemTraTonTai(soTaiKhoan)==null)
                                    System.out.println("Số tài khoản đăng nhập không tồn tại trong hệ thống!Vui lòng nhập lại");
                            }
                            while(ds.kiemTraTonTai(soTaiKhoan)==null);
                            TaiKhoan tk1=ds.kiemTraTonTai(soTaiKhoan);
                            if(tk1!=null){
                                do{
                                    System.out.print("Nhập mật khẩu đăng nhập:");
                                    matKhau=scanner.nextLine();
                                    if(tk1.dangNhap(soTaiKhoan, matKhau)){
                                        System.out.println("");
                                        System.out.println("Đăng nhập thành công!Xin chào "+tk1.chuTaiKhoan);
                                        dangnhap=tk1.dangNhap(soTaiKhoan, matKhau);
                                        loop2:
                                        while(true){
                                            System.out.println("1.Gửi tiền");
                                            System.out.println("2.Chuyển khoản");
                                            System.out.println("3.Rút tiền");
                                            System.out.println("4.Kiểm tra số dư");
                                            System.out.println("5.Đổi mật khẩu");
                                            System.out.println("6.Lịch sử giao dịch");
//                                            System.out.println("7.In biên lai");
                                            System.out.println("0.Thoát");
                                            System.out.println("");
                                            System.out.print("Nhập lựa chọn của bạn:");
                                            int lc2=scanner.nextInt();
                                            scanner.nextLine();
                                            switch(lc2){
                                                case 1:
                                                    do{
                                                        System.out.print("Nhập số tiền cần gửi:");
                                                        tienGui=scanner.nextDouble();
                                                        if(tienGui<0)
                                                            System.out.println("Tiền gửi không hợp lệ!Nhập lại");
                                                    }
                                                    while(tienGui<0);
                                                    tk1.guiTien(tienGui);
                                                    ds.ghiLichSuGiaoDich(tk1);
                                                    System.out.println("");
                                                    break;
                                                case 2:
                                                    do {                                                        
                                                        System.out.print("Nhập số tài khoản cần chuyển:");
                                                        soTaiKhoan=scanner.nextLine();
                                                        if(ds.kiemTraTonTai(soTaiKhoan)==null)
                                                            System.out.println("Số tài khoản không tồn tại!Nhập lại!");
                                                    } 
                                                    while (ds.kiemTraTonTai(soTaiKhoan)==null||ds.kiemTraTonTai(soTaiKhoan)==tk1);
                                                    TaiKhoan tk2=ds.kiemTraTonTai(soTaiKhoan);
                                                    do{
                                                        System.out.print("Nhập số tiền cần chuyển khoản:");
                                                        tienChuyenKhoan=scanner.nextDouble();
                                                        if(tienChuyenKhoan<0)
                                                            System.out.println("Tiền gửi không hợp lệ!Nhập lại");
                                                    }
                                                    while(tienChuyenKhoan<0||tk1.soDu<=tienChuyenKhoan);
                                                    scanner.nextLine();
                                                    do{
                                                        System.out.print("Nhập mã pin:");
                                                        maPin=scanner.nextLine();
                                                        if(!tk1.kiemTraMaPin(maPin))
                                                            System.out.println("Mã pin không đúng!Nhập lại!");
                                                    }
                                                    while(!tk1.kiemTraMaPin(maPin));
                                                    tk1.chuyenKhoan(tk2, tienChuyenKhoan);                                                
                                                    ds.ghiLichSuGiaoDich(tk1);
                                                    ds.ghiLichSuGiaoDich(tk2);
                                                    System.out.println("");
                                                    break;
                                                case 3:
                                                    do{
                                                        System.out.print("Nhập số tiền cần rút:");
                                                        tienRut=scanner.nextDouble();
                                                        if(tienRut<0)
                                                            System.out.println("Tiền rút không hợp lệ!Nhập lại");
                                                    }
                                                    while(tienRut<0||tienRut>tk1.getSoDu()); 
                                                    tk1.rutTien(tienRut);
                                                    ds.ghiLichSuGiaoDich(tk1);
                                                    System.out.println("");
                                                    break;
                                                case 4:
                                                    tk1.kiemTraSoDu();
                                                    System.out.println("");
                                                    break;
                                                case 5:
                                                    do{
                                                        System.out.print("Nhập mật khẩu cũ:");
                                                        matKhau=scanner.nextLine(); 
                                                     }
                                                     while(!tk1.kiemTraMatKhau(matKhau));
                                                     System.out.print("Nhập mật khẩu mới:");
                                                     matKhauMoi=scanner.nextLine();
                                                     tk1.doiMatKhau(matKhau, matKhauMoi);
                                                     System.out.println("");
                                                     break;
                                                case 6:
                                                    ds.hienThiLichSu(tk1);
                                                    System.out.println("");
                                                    break;
                                                case 0:
                                                    break loop2;
                                            }
                                        }
                                    }
                                    else{
                                        d++;
                                        if(d==5){
                                            System.out.println("Đã hết số lần nhập lại mật khẩu sai!");
                                             break;
                                        }
                                        System.out.println("Nhập sai!Nhập lại!"); 
                                        System.out.println("Bạn còn "+(5-d)+" lần nhập!");
                                    }
                                }
                                while(!dangnhap&&d<5);
                            }
                            break;
                        case 0:
                            break loop1; 
                     
                    }
                    break;
                    case 2:
                        System.out.println("1. Đăng kí tài khoản tiết kiệm!");
                        System.out.println("2. Đăng nhập tài khoản tiết kiệm!");
                        System.out.println("0. Thoát");
                        System.out.println("");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        int lc2 = scanner.nextInt();
                        scanner.nextLine();
                        switch(lc2){
                            case 1:
                                System.out.print("Nhập số điện thoại đăng kí: ");
                                soDienThoai = scanner.nextLine();
                                System.out.print("Nhập căn cước công dân: ");
                                cccd = scanner.nextLine();
                                do {
                                    System.out.print("Nhập số tài khoản: ");
                                    soTaiKhoan = scanner.nextLine();
                                    if (ds.kiemTraTonTai(soTaiKhoan) != null)
                                        System.out.println("Số tài khoản đã tồn tại trong hệ thống! Vui lòng nhập lại!");
                                } 
                                while (ds.kiemTraTonTai(soTaiKhoan) != null);
                                System.out.print("Nhập tên tài khoản đăng kí: ");
                                tenTK = scanner.nextLine();
                                do {
                                    System.out.print("Nhập mật khẩu đăng kí:(Mật khẩu phải chứa kí tự Hoa,Thường,Số và đủ 5 kí tự) :");
                                    matKhau = scanner.nextLine();
                                } 
                                while (!kiemTraMatKhauManh(matKhau));
                                System.out.print("Nhập lãi suất:");
                                laiSuat=scanner.nextDouble();
                                System.out.print("Nhập kỳ hạn:");
                                kyHan=scanner.nextInt();
                                TaiKhoan tk=new TaiKhoanTietKiem(soTaiKhoan, tenTK, matKhau, cccd, soDienThoai, laiSuat, kyHan);
                                ds.themTaiKhoanTietKiem(soTaiKhoan, tk);
                                System.out.println("Đã đăng ký thành công!");
                                System.out.println("");
                                System.out.println("Thông tin tài khoản vừa mới thêm là:");
                                System.out.printf("%-20s: %s\n", "Số tài khoản", soTaiKhoan);
                                System.out.printf("%-20s: %s\n", "Tên tài khoản", tenTK);
                                System.out.printf("%-20s: %s\n", "Mật khẩu", matKhau);
                                System.out.printf("%-20s: %s\n", "Căn cước công dân", cccd);
                                System.out.printf("%-20s: %s\n", "Số điện thoại", soDienThoai);
                                System.out.printf("%-20s: %.2f%%\n", "Lãi suất", laiSuat);
                                System.out.printf("%-20s: %d tháng\n", "Kỳ hạn", kyHan);
                                System.out.println("----------------------------------------------");
                                break;
                            case 2:
                                int d=0;
                                boolean dangnhap = false;
                                do{
                                    System.out.print("Nhập số tài khoản đăng nhập:");
                                    soTaiKhoan=scanner.nextLine();
                                    if(ds.kiemTraTonTai(soTaiKhoan)==null)
                                        System.out.println("Số tài khoản đăng nhập không tồn tại trong hệ thống!Vui lòng nhập lại");
                                }
                                while(ds.kiemTraTonTai(soTaiKhoan)==null);
                                TaiKhoan tk1=ds.kiemTraTonTai(soTaiKhoan);
                                if(tk1!=null){
                                    do{
                                        System.out.print("Nhập mật khẩu đăng nhập:");
                                        matKhau=scanner.nextLine();
                                        if(tk1.dangNhap(soTaiKhoan, matKhau)){
                                            System.out.println("");
                                            System.out.println("Đăng nhập thành công!Xin chào "+tk1.chuTaiKhoan);
                                            dangnhap=tk1.dangNhap(soTaiKhoan, matKhau);
                                            lopp2:
                                            while(true){
                                                System.out.println("1.Gửi tiền tiết kiệm");
                                                System.out.println("2.Rút tiền tiết kiệm");
                                                System.out.println("3.In thông tin tài khoản tiết kiệm");
                                                System.out.println("4.Lịch sử");
                                                System.out.println("0.Thoát");
                                                System.out.print("Nhập lựa chọn của bạn:");
                                                int lc3=scanner.nextInt();
                                                scanner.nextLine();
                                                switch(lc3){
                                                    case 1:
                                                        do{
                                                        System.out.print("Nhập số tiền cần gửi:");
                                                        tienGui=scanner.nextDouble();
                                                        if(tienGui<0)
                                                            System.out.println("Tiền gửi không hợp lệ!Nhập lại");
                                                        }
                                                        while(tienGui<0);
                                                        tk1.guiTien(tienGui);
                                                        ds.ghiLichSuGiaoDich(tk1);
                                                        System.out.println("");
                                                        break;
                                                    case 2:
                                                        do{
                                                            System.out.print("Nhập số tiền cần rút:");
                                                            tienRut=scanner.nextDouble();
                                                            if(tienRut<0||tienRut>tk1.getSoDu())
                                                                System.out.println("Số tiền rút không hợp lệ! Nhập lại!");
                                                        }
                                                        while(tienRut<0||tienRut>tk1.getSoDu());
                                                        tk1.rutTien(tienRut);
                                                        scanner.nextLine();
                                                        break;
                                                    case 3:
                                                        tk1.thongTinTaiKhoan();
                                                        break;
                                                    case 4:
                                                        ds.hienThiLichSu(tk1);
                                                        System.out.println("");
                                                        break;
                                                    case 0:
                                                        break lopp2;
                                                }
                                            }
                                        }
                                        else{
                                            d++;
                                            if(d==5){
                                                System.out.println("Đã hết số lần nhập lại mật khẩu sai!");
                                                 break;
                                            }
                                            System.out.println("Nhập sai!Nhập lại!"); 
                                            System.out.println("Bạn còn "+(5-d)+" lần nhập!");
                                        }
                                    }
                                    while(!dangnhap&&d<5);
                                }
                                break;
                            case 0:
                                break loop1;
                        } 
            }
            }
            while(true);
            System.out.println("---------------------------------------------------------------");
        }
    }
}
