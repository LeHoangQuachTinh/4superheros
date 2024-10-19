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
    public static void main(String[] args) {
        String soTaiKhoan,matKhau,chuTaiKhoan,lc,matKhauMoi;
        int soLanDangNhap=0,tt;
        double tienGui,rutTien;
        Scanner scanner=new Scanner(System.in);
        DanhSach ds =new DanhSach();
        do{
            System.out.println("-----Chương trình-----");
            System.out.println("1.Tạo tài khoản ngân hàng");
            System.out.println("2.Đăng nhập tài khoản ngân hàng");
            System.out.println("Nhấn một phím bất kỳ để thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn:");
            lc=scanner.nextLine();
            switch(lc){
                case "1":
                    System.out.print("Nhập số tài khoản:");
                    soTaiKhoan=scanner.nextLine();
                    System.out.print("Nhập tên tài khoản:");
                    chuTaiKhoan=scanner.nextLine();
                    System.out.print("Nhập mật khẩu tài khoản:");
                    matKhau=scanner.nextLine();
                    TaiKhoan tk = new TaiKhoan(soTaiKhoan, chuTaiKhoan, matKhau);
                    ds.themTaiKhoan(soTaiKhoan, tk);
                    break;
                case "2":
                    boolean dangNhap=false;
                    do{
                        System.out.print("Nhập số tài khoản đăng nhập:");
                        soTaiKhoan=scanner.nextLine();
                        System.out.print("Nhập mật khẩu tài khoản đăng nhập:");
                        matKhau=scanner.nextLine();
                        TaiKhoan tk1=ds.kiemTraTonTai(soTaiKhoan);
                        if(tk1!=null){
                            dangNhap=tk1.dangNhap(soTaiKhoan, matKhau);
                            if(dangNhap){
                                System.out.println("Bạn đã đăng nhập thành công!");
                                System.out.println("Xin chào:"+tk1.getChuTaiKhoan());
                                String lc1;
                                loop1:
                                while(true){
                                    System.out.println("-----Chọn lựa chọn của bạn-----");
                                    System.out.println("1.Gửi tiền");
                                    System.out.println("2.Rút tiền");
                                    System.out.println("3.Đổi mật khẩu");
                                    System.out.println("Nhập một phím bất kỳ để đăng xuất tài khoản!");
                                    System.out.print("Nhập lựa chọn của bạn:");
                                    lc1=scanner.nextLine();
                                    switch(lc1){
                                        case "1":
                                            do{
                                                System.out.print("Nhập số tiền cần gửi:");
                                                tienGui=scanner.nextDouble();
                                                if(tienGui<0)
                                                    System.out.println("Số tiền nhập không hợp lệ! Nhập lại!");
                                            }
                                            while(tienGui<0);
                                            tk1.guiTien(tienGui);
                                            scanner.nextLine();
                                            break;
                                        case "2":
                                            do{
                                                System.out.print("Nhập số tiền cần rút:");
                                                rutTien=scanner.nextDouble();
                                                if(rutTien<0||rutTien>tk1.getSoDu())
                                                    System.out.println("Số tiền rút không hợp lệ! Nhập lại!");
                                            }
                                            while(rutTien<0||rutTien>tk1.getSoDu());
                                            tk1.rutTien(rutTien);
                                            scanner.nextLine();
                                            break;
                                        case "3":
                                            do{
                                               System.out.print("Nhập mật khẩu cũ:");
                                               matKhau=scanner.nextLine(); 
                                            }
                                            while(!tk1.kiemTraMatKhau(matKhau));
                                            System.out.print("Nhập mật khẩu mới:");
                                            matKhauMoi=scanner.nextLine();
                                            tk1.doiMatKhau(matKhau, matKhauMoi);
                                            break;
                                       default:
                                           break loop1;
                                           
                                    }
                                }
                            }
                            else{
                                System.out.println("Số tài khoản hay mật khẩu đăng nhập sai! Nhập lại!");
                                soLanDangNhap++;
                                if(soLanDangNhap==5){
                                    System.out.println("Số lần đăng nhập lại quá giới hạn!");
                                    break;
                                }    
                                System.out.println("Bạn còn "+(5-soLanDangNhap)+" lần nhập lại!");
                            }
                        }
                        else{
                            System.out.println("Tài khoản không tồn tại trong hệ thống!");
                            System.out.println("Vui lòng nhập lại tài khoản!");
                            soLanDangNhap++;
                            if(soLanDangNhap==5){
                                System.out.println("Số lần đăng nhập lại quá giới hạn!");
                                break;
                            }
                            System.out.println("Bạn còn "+(5-soLanDangNhap)+" lần nhập lại!");                
                        }
                    }
                    while(soLanDangNhap<5&&!dangNhap);
                    break;
                default:
                    System.out.println("Kết thúc chương trình!");
                    return;
            } 
            System.out.println("Bạn có muốn tiếp tục đăng nhập không? 1.Tiếp tục , 2.Dừng!");
            System.out.print("Nhập lựa chọn của bạn:");
            tt=scanner.nextInt();
            scanner.nextLine();
            if(tt==1)
                continue;
            else
                break;
        }
        while(true);
    }
}
