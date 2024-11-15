/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan_10;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class main {
    public static void menu(){
        System.out.println("-----------Menu-----------");
        System.out.println("1.Căn cước công dân!");
        System.out.println("2.Tài khoản!");
        System.out.println("0.Thoát!");
    }
    
    public static void menu_cccd(){
        System.out.println("-----------Menu_Căn cước công dân-----------");
        System.out.println("1.Thêm căn cước công dân!");
        System.out.println("2.In thông tin căn cước công dân!");
        System.out.println("0.Thoát!");
    }
    
    public static void menu_TaiKhoan(){
        System.out.println("-----------Menu_Tài khoản-----------");
        System.out.println("1.Thêm tài khoản!");
        System.out.println("2.Đăng nhập tài khoản!");
        System.out.println("3.In danh sách tài khoản!");
        System.out.println("4.Xóa tài khoản!");
        System.out.println("5.Tìm kiếm tài khoản!");
        System.out.println("0.Thoát");
    }
    
    public static void menu_TaiKhoanThanhToan(){
        System.out.println("-----------Menu_Tài khoản thanh toán-----------");
        System.out.println("1.Gửi tiền!");
        System.out.println("2.Rút tiền!");
        System.out.println("3.Chuyển khoản!");
        System.out.println("4.Xem thông tin tài khoản!");
        System.out.println("5.Thay đổi thông tin cá nhân!");
        System.out.println("6.Lịch sử giao dịch!");
        System.out.println("7.Đóng tài khoản!");
        System.out.println("8.Mở tài khoản!");
        System.out.println("9.Kiểm tra số dư!");
        System.out.println("0.Thoát!");
    }
    
    public static void menu_TaiKhoanTietKiem(){
        System.out.println("-----------Menu_Tài khoản thanh toán-----------");
        System.out.println("1.Gửi tiền!");
        System.out.println("2.Rút tiền!");
        System.out.println("3.Lãi suất!");
        System.out.println("4.Kiểm tra số dư");
        System.out.println("5.Lịch sử giao dịch!");
        System.out.println("6.In thông tin tài khoản!");
        System.out.println("7.Đóng tài khoản!");
        System.out.println("8.Mở tài khoản!");
        System.out.println("9.Cập nhật thông tin tài khoản!");
        System.out.println("0.Thoát");
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        DsCCCD dsCCCD=new DsCCCD();
        DSTaiKhoan dsTk =new DSTaiKhoan();
        char lc='y';
        while(lc=='y'){
            menu();
            System.out.print("Nhập lựa chọn của bạn:");
            int lc_menu =scanner.nextInt();
            switch(lc_menu){
                //1.căn cước công dân
                case 1:
                {
                    loop1 :
                    while(true){
                        menu_cccd();
                        System.out.print("Nhập lựa chọn của bạn:");
                        int lc_menu_cccd=scanner.nextInt();
                        scanner.nextLine();
                        switch(lc_menu_cccd){
                            case 1:
                                dsCCCD.nhap_cccd(scanner);
                                break;
                            case 2:
                                System.out.print("Nhập số căn cước công dân:");
                                String cccd=scanner.nextLine();
                                if(dsCCCD.kiemTraCanCuocCongDan(cccd)==null)
                                    System.out.println("Không tồn tại căn cước công dân!");
                                else
                                    System.out.println(dsCCCD.kiemTraCanCuocCongDan(cccd).toString());
                                break;
                            case 0:
                                break loop1;
                        }        
                    }
                    break;
                }   
                //2.Tài khoản
                case 2:
                {
                    loop1 :
                    while(true){
                        menu_TaiKhoan();
                        System.out.print("Nhập lựa chọn của bạn:");
                        int lc_menu_tk=scanner.nextInt();
                        scanner.nextLine();
                        switch(lc_menu_tk){
                            case 1:
                            {
                                int lcc=1;
                                while(lcc==1){
                                    System.out.println("Bạn muốn thêm tài khoản nào?");
                                    System.out.println("1.Thanh toán,2.Tiết kiệm,0.Thoát:");
                                    System.out.print("Nhập lựa chọn của bạn:");
                                    int lcc1=scanner.nextInt();
                                    scanner.nextLine();
                                    switch(lcc1){
                                        case 1:
                                            dsTk.nhap_thanhToan(scanner, dsCCCD,dsTk);
                                            break;
                                        case 2:
                                            dsTk.nhap_tietKiem(scanner, dsCCCD, dsTk);
                                            break;
                                        case 0:
                                            lcc=2;
                                            break;
                                    } 
                                }
                                break;
                            }    
                            case 2:
                            {
                                String stk ;
                                String mk;
                                int d=0;
                                System.out.print("Nhập số tài khoản đăng nhập:");
                                stk=scanner.nextLine();
                                TaiKhoan tk=dsTk.kiemTraTonTai(stk);
                                if(tk!=null){
                                    do{
                                        System.out.print("Nhập mật khẩu tài khoản đăng nhập:");
                                        mk=scanner.nextLine();
                                        if(!dsTk.kiemTraTonTai(stk).dangNhap(stk, mk)){
                                            if(d==4){
                                                System.out.println("Đăng nhập thất bại!");
                                                break;
                                            }   
                                            d+=1;

                                            System.out.println("Nhập sai,nhập lại!"+"Bạn còn "+(5-d)+" lần nhập lại!");                                  
                                        }
                                        else{
                                            System.out.println("Đăng nhập thành công");    
                                            //chức năng của tài khoản thanh toán
                                            if(tk instanceof TaiKhoanThanhToan){
                                                int tt=1;
                                                while(tt==1){
                                                    menu_TaiKhoanThanhToan();
                                                    System.out.print("Nhập lựa chọn của bạn:");
                                                    int lc_menu_tktt=scanner.nextInt();
                                                    switch(lc_menu_tktt){
                                                        case 1:
                                                            System.out.print("Nhập số tiền cần gửi:");
                                                            double tienGui=scanner.nextDouble();
                                                            tk.guiTien(tienGui);
                                                            break;
                                                        case 2:
                                                            System.out.print("Nhập số tiền cần rút:");
                                                            double tienRut =scanner.nextDouble();
                                                            tk.rutTien(tienRut,scanner);
                                                            break;
                                                        case 3:
                                                        {
                                                            scanner.nextLine();
                                                            System.out.print("Nhập số tài khoản cần chuyển:");
                                                            String stk_ck =scanner.nextLine();
                                                            TaiKhoan tk_ck = dsTk.kiemTraTonTai(stk_ck);
                                                            double tien_ck;
                                                            if(tk_ck!=null&&tk_ck!=tk){
                                                                do{
                                                                    System.out.print("Nhập số tiền chuyển khoản:");
                                                                    tien_ck=scanner.nextDouble();
                                                                }
                                                                while(tien_ck!=0&&tien_ck>tk.getSoDu()+(((TaiKhoanThanhToan) tk).getThauChi()-((TaiKhoanThanhToan) tk).getThauChiDaDung()));
                                                                scanner.nextLine();
                                                                String pin;
                                                                do{
                                                                    System.out.print("Nhập mã pin:");
                                                                     pin= scanner.nextLine();
                                                                }
                                                                while(!((TaiKhoanThanhToan) tk).getMaPin().equals(pin));
                                                                ((TaiKhoanThanhToan) tk).chuyenKhoan(tk_ck, tien_ck);
                                                            }
                                                            else
                                                                System.out.println("Số tài khoản chuyển khoản không đúng!");
                                                            break;
                                                        }
                                                        case 4:
                                                            tk.in();
                                                            break;
                                                        case 5:
                                                            ((TaiKhoanThanhToan) tk).capNhat(scanner);
                                                            break;
                                                        case 6:
                                                            tk.inLichSuGiaoDich();
                                                            break;
                                                        case 7:
                                                            tk.dongTaiKhoan();
                                                            break;
                                                        case 8:
                                                            tk.moTaiKhoan();
                                                            break;
                                                        case 9:
                                                            System.out.println("Số dư trong tài khoản là:"+tk.soDu());;
                                                            break;
                                                        case 0:
                                                             tt=0;
                                                             break;
                                                    }
                                                }
                                            }
                                            
                                            //chức năng tài khoản tiết kiệm
                                            if(tk instanceof  TaiKhoanTietKiem){
                                                int tt=1;
                                                while(tt==1){
                                                    menu_TaiKhoanTietKiem();
                                                    System.out.print("Nhập lựa chọn của bạn:");
                                                    int lc_menu_tktk=scanner.nextInt();
                                                    switch(lc_menu_tktk){
                                                        case 1:
                                                            System.out.print("Nhập số tiền cần gửi:");
                                                            double tienGui_TietKiem=scanner.nextDouble();
                                                            tk.guiTien(tienGui_TietKiem);
                                                            break;
                                                        case 2:
                                                            System.out.print("Nhập số tiền cần rút:");
                                                            double tienRut_TietKiem=scanner.nextDouble();
                                                            tk.rutTien(tienRut_TietKiem, scanner);
                                                            break;
                                                        case 3:
                                                            System.out.println("Lãi xuất là:"+((TaiKhoanTietKiem) tk).LaiXuat());
                                                            break;
                                                        case 4:
                                                            System.out.println("Số dư trong tài khoản là:"+tk.soDu());;
                                                            break;
                                                        case 5:
                                                            tk.inLichSuGiaoDich();
                                                            break;
                                                        case 6:
                                                            tk.in();
                                                            break;
                                                        case 7:
                                                            tk.dongTaiKhoan();
                                                            break;
                                                        case 8:
                                                            tk.moTaiKhoan();
                                                            break;
                                                        case 9:
                                                            ((TaiKhoanTietKiem) tk).capNhat(scanner);
                                                            break;
                                                        case 0:
                                                             tt=0;
                                                             break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    while(!tk.dangNhap(stk, mk)&&d<5);
                                }
                                else
                                    System.out.println("Tài khoản không tồn tại trong hệ thống!");
                                break;
                            }
                            case 3:
                                dsTk.InDsTaiKhoan_ThanhToan();
                                dsTk.InDsTaiKhoan_TietKiem();
                                break;
                            case 4:
                                dsTk.xoa(scanner);
                                break;
                            case 5:
                                System.out.print("Nhập số tài khoản cần tìm kiếm:");
                                String stk=scanner.nextLine();
                                TaiKhoan tk=dsTk.kiemTraTonTai(stk);
                                if(tk==null)
                                    System.out.println("Số tài khoản không tồn tại!");
                                else
                                    tk.in();
                                break;
                            case 0:
                                break loop1;
                        }        
                    }
                    break;
                } 
                //0.thoát
                case 0:
                       lc='N';
                       break;
            }
        }
    }
}
