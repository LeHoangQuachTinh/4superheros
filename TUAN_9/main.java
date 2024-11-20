/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUAN_9;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class main {
    public static void menu(){
        System.out.println("");
        System.out.println("1.Thêm tài khoản!");
        System.out.println("2.Đăng nhập tài khoản!");
        System.out.println("3.In danh sách tài khoản!");
        System.out.println("0.Thoát!");
    }
    
    public static void menu_thanhToan(){
        System.out.println("");
        System.out.println("1.Gửi tiền!");
        System.out.println("2.Rút tiền!");
        System.out.println("3.Chuyển khoản!");
        System.out.println("4.Kiểm tra số dư");
        System.out.println("5.Lịch sử giao dịch!");
        System.out.println("6.In thông tin tài khoản!");
        System.out.println("7.Đổi mật khẩu!");
        System.out.println("0.Thoát");
        System.out.println("");
    }
    
    public static void menu_tietKiem(){
        System.out.println("");
        System.out.println("1.Gửi tiền!");
        System.out.println("2.Rút tiền!");
        System.out.println("3.Lãi suất!");
        System.out.println("4.Kiểm tra số dư");
        System.out.println("5.Lịch sử giao dịch!");
        System.out.println("6.In thông tin tài khoản!");
        System.out.println("7.Đổi mật khẩu!");
        System.out.println("0.Thoát");
        System.out.println("");
    }
    public static void main(String[] args) {
        String stk,mk = null;
        DSTaiKhoan ds =new DSTaiKhoan();
        Scanner scanner=new Scanner(System.in);
        char c='Y';
        while(c=='Y'){
            menu();
            System.out.print("Nhập lựa chọn của bạn:");
            int lc=scanner.nextInt();
            
            switch(lc){
                case 1:
                    ds.nhap(scanner);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Nhập số tài khoản đăng nhập:");
                    stk=scanner.nextLine();
                    if(ds.kiemTraTonTai(stk)!=null){
                        int d=0;
                        do{
                            System.out.print("Nhập mật khẩu tài khoản đăng nhập:");
                            mk=scanner.nextLine();
                            if(!ds.dangNhapTaiKhoan(stk, mk)){
                                if(d==4){
                                    System.out.println("Đăng nhập thất bại!");
                                    break;
                                }   
                                d+=1;
                                
                                System.out.println("Nhập sai,nhập lại!"+"Bạn còn "+(5-d)+" lần nhập lại!");                                  
                            }
                            else{
                                System.out.println("Đăng nhập thành công");    
                            }
                                
                        }
                        while(!ds.dangNhapTaiKhoan(stk, mk)&&d<5);
                    }
                    else
                        System.out.println("Tài khoản không tồn tại trong hệ thống!");
                   
                    if(ds.dangNhapTaiKhoan(stk, mk)){
                        //tài khoản thanh toán
                        if(ds.kiemTraTonTai(stk) instanceof  TaiKhoanThanhToan){
                            TaiKhoan tk=ds.kiemTraTonTai(stk);
                            char tt='Y';
                            while(tt=='Y'){
                                menu_thanhToan();
                                System.out.print("Nhập lựa chọn của bạn:");      
                                int lc_thanhToan=scanner.nextInt();
                                switch(lc_thanhToan){
                                case 1:
                                    System.out.print("Nhập tiền gửi:");
                                    double tienGui=scanner.nextDouble();
                                    tk.guiTien(tienGui);
                                    break;
                                case 2:
                                    System.out.print("Nhập số tiền cần rút:");
                                    double tienRut=scanner.nextDouble();
                                    tk.rutTien(tienRut);
                                    break;
                                case 3:
                                    scanner.nextLine();
                                    System.out.print("Nhập số tài khoản cần chuyển tiền:");
                                    String stk_ck =scanner.nextLine();
                                    TaiKhoan tk_ck=ds.kiemTraTonTai(stk_ck);
                                    if(tk_ck!=null){
                                        double tien_ck;
                                        do{
                                            System.out.print("Nhập số tiền chuyển khoản:");
                                            tien_ck=scanner.nextDouble();
                                        }
                                        while(tien_ck>tk.getSoDu());
                                        scanner.nextLine();
                                        String pin;
                                        do{
                                            System.out.print("Nhập mã pin:");
                                             pin= scanner.nextLine();
                                        }
                                        while(!tk.kiemTraMaPin(pin));
                                        tk.chuyenKhoan(tk_ck, tien_ck);
                                    }
                                    break;
                                case 4:
                                    tk.kiemTraSoDu();
                                    break;
                                case 5:
                                    tk.inLichSuGiaoDich();
                                    break;
                                case 6:
                                    tk.in();;
                                    break;
                                case 7:
                                    String matKhau;
                                    do{
                                       System.out.print("Nhập mật khẩu cũ:");                 
                                        matKhau=scanner.nextLine();                 
                                       }
                                    while(!tk.kiemTraMatKhau(matKhau));
                                    System.out.print("Nhập mật khẩu mới:");
                                    String matKhauMoi=scanner.nextLine();
                                    tk.doiMatKhau(matKhau, matKhauMoi);
                                    System.out.println("");
                                    break;
                                case 0:
                                    System.out.println("Đăng xuất tài khoản thanh toán!");
                                    tt='N';
                                    break;
                                }
                            }
                        }
                        //tài khoản tiết kiệm
                        if(ds.kiemTraTonTai(stk) instanceof  TaiKhoanTietKiem){
                            TaiKhoan tk=ds.kiemTraTonTai(stk);
                            char tt='Y';
                            while(tt=='Y'){
                                menu_tietKiem();
                                System.out.print("Nhập lựa chọn của bạn:");      
                                int lc_thanhToan=scanner.nextInt();
                                switch(lc_thanhToan){
                                case 1:
                                    System.out.print("Nhập tiền gửi:");
                                    double tienGui=scanner.nextDouble();
                                    tk.guiTien(tienGui);
                                    break;
                                case 2:
                                    System.out.print("Nhập số tiền cần rút:");
                                    double tienRut=scanner.nextDouble();
                                    tk.rutTien(tienRut);
                                    break;
                                case 3:
                                    System.out.println("Lãi suất là:"+tk.LaiXuat());
                                    break;
                                case 4:
                                    tk.kiemTraSoDu();
                                    break;
                                case 5:
                                    tk.inLichSuGiaoDich();
                                    break;
                                case 6:
                                    tk.in();;
                                    break;
                                case 7:
                                    String matKhau;
                                    do{
                                       System.out.print("Nhập mật khẩu cũ:");                 
                                        matKhau=scanner.nextLine();                 
                                       }
                                    while(!tk.kiemTraMatKhau(matKhau));
                                    System.out.print("Nhập mật khẩu mới:");
                                    String matKhauMoi=scanner.nextLine();
                                    tk.doiMatKhau(matKhau, matKhauMoi);
                                    System.out.println("");
                                    break;
                                case 0:
                                    System.out.println("Đăng xuất tài khoản thanh toán!");
                                    tt='N';
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    ds.InDsTaiKhoan_ThanhToan();
                    System.out.println("");
                    ds.InDsTaiKhoan_TietKiem();
                    break;
                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
                
            } 
        }        
    }
}
