package BT.NganHang;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import static BT.IListAccount.DS;
import BT.Main;
public class MainNH {
    static  Scanner sc = new Scanner(System.in);
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
    public static int xuLyInt(String thongbao) {

        while (true) {
            try {
                System.out.print(thongbao);
                int input = sc.nextInt();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Bạn nhập lựa chọn phải một số nguyên!\n.");
                sc.nextLine();
            }
        }
    }
    public static double xuLyDouble(String thongbao) {
        while (true) {
            try {
                System.out.print(thongbao);
                double input = sc.nextDouble();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("\nLỗi: Bạn phải nhập một số tiền hợp lệ kiểu số!\n.");
                sc.nextLine();
            }
        }
    }
   
    public static void main(String[] args) 
    {
        // DSTaiKhoang DS = DS;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        String stk;
        String matkhau;
        String maOTP;
        String SDT;
        int dem;
        int soLanNhapSai;
        int lc;

       while (true) 
        {
            System.out.println("\n-----------------🧑‍💼 Ngân hàng 4 anh em siêu nhân 🧑‍💼-------------------");
            System.out.println("Bạn chọn làm gì:");
            System.out.println("1.Đăng kí tài khoản");
            System.out.println("2.Đăng nhập tài khoản");
            System.out.println("3.Quên mật khẩu");
            System.out.println("0.Thoát chương trình");

            int n = xuLyInt("Nhập sự lựa chọn: ");
            // sc.nextLine();
            switch (n) 
            {
                case 1:
                    DS.dangKiTaiKhoan();     
                break;
                case 2: 
                {
                    sc.nextLine();
                    System.out.print("Nhập số tài khoản cần đăng nhập:");
                    stk = sc.nextLine();
                    TaiKhoan taikhoan = DS.searchAcount(stk);
                    TaiKhoanThanhToan taikhoanTT=(TaiKhoanThanhToan)taikhoan;
                    if (taikhoan != null) 
                    {
                        System.out.print("Nhập mật khẩu tài khoản cần đăng nhập:");
                        matkhau = sc.nextLine();

                        soLanNhapSai=0;
                        while (!taikhoan.kiemtraMatKhau(matkhau) && soLanNhapSai<5) 
                        {
                            soLanNhapSai++;
                            System.out.printf("Mật khẩu sai. Nhập lại mật khẩu tài khoản cần đăng nhập lần %d:", soLanNhapSai);
                            matkhau = sc.nextLine();  
                        }
                        if (soLanNhapSai >= 5)
                                taikhoan.khoaTaiKhoan(5,"");
                        if (!taikhoan.getLocket()) 
                        {
                            System.out.printf("\nTài khoản bạn chọn là: %s\n", taikhoan.getStk());
                            System.out.printf("Tên chủ tài khoản là: %s\n", taikhoan.chutk);
                            do{
                                System.out.println("\n--------------🤑 Tài khoản chính 🤑----------------");
                                System.out.println("1.Nạp tiền tài khoản");
                                System.out.println("2.Rút tiền ");
                                System.out.println("3.Chuyển khoảng");
                                System.out.println("4.Thanh toán tiền điện,nước,wifi,....");
                                System.out.println("5.Xem số dư tài khoản");
                                System.out.println("6.Đổi mật khẩu");
                                System.out.println("7.Lịch sử");
                                System.out.println("0.Thoát!");

                                lc = xuLyInt("Nhập lựa chọn: ");
                      
                                switch (lc)
                                {
                                    case 1:
                                    {
                                    
                                        double tienNop = xuLyDouble("Nhập số tiền cần nạp: ");
                                        if(tienNop>=0)
                                        {
                                            taikhoanTT.napTiep(tienNop);                                  
                                            System.out.printf("Số tiền mới trong tài khoản thanh toan là: %.0f₫\n", taikhoanTT.getSodu()); 
                                            taikhoan.ThemLichSu("\nBạn đã nộp tiền vào tài khoản "+tienNop+"00đ lúc "+LocalDateTime.now().format(formatter).toString());
                                        }
                                        else
                                            System.out.println("Số tiền nộp không hợp lệ!");                                                 
                                    }
                                    break;
                                    case 2:
                                    {
                                        double tienRut = xuLyDouble("Nhập số tiền cần rút: ");
                                        soLanNhapSai=1;

                                        taikhoan.TaoOTP();
                                        do
                                        {
                                            System.out.printf("Nhập mã OTP để rút lần %d/5:",soLanNhapSai);
                                            maOTP=sc.nextLine();
                                            if(taikhoan.kiemTraMaOTP(maOTP))
                                            {

                                                if (taikhoanTT.getSodu() >= tienRut)
                                                {
                                                    
                                                    taikhoan.rutTien(tienRut);
                                                    System.out.printf("Số tiền mới trong tài khoản là: %.0f₫\n",taikhoanTT.getSodu());
                                                    taikhoan.ThemLichSu("\nBạn đã rút "+tienRut+"00đ lúc "+LocalDateTime.now().format(formatter).toString());
                                                }
                                                else 
                                                {
                                                    System.out.println("\nSố dư không đủ để thực hiện giao dịch.");
                                                    break;
                                                }
                                            }
                                            else
                                                soLanNhapSai++;
                                            
                                        }while(!taikhoan.kiemTraMaOTP(maOTP) && soLanNhapSai<=5);
                                        if(soLanNhapSai>=5)
                                        {
                                            taikhoanTT.khoaTaiKhoan(5,"");
                                            break;
                                        }
                                    }
                                    break;
                                    case 3:
                                    {
                                        System.out.print("Nhập số tài khoản nhận: ");
                                        String stkNhan = sc.nextLine();

                                        TaiKhoan tkNhan = DS.searchAcount(stkNhan);
                                        TaiKhoanThanhToan tkNhan1=(TaiKhoanThanhToan)tkNhan;
                                        if (tkNhan != null && !taikhoan.getStk().equals(stkNhan)) 
                                        {                                          
                                            System.out.printf("Tài khoản nhận: %s - %s\n", tkNhan.getStk(), tkNhan.chutk);

                                            taikhoan.TaoOTP();
                                            soLanNhapSai=1;
                                            boolean kt=false;
                                            do
                                            {
                                                double tienChuyen = xuLyDouble("Nhập số tiền cần chuyển: ");
                                                if(tienChuyen>0)
                                                {
                                                    System.out.printf("Nhập mã OTP để chuyển khoản lần %d/5:",soLanNhapSai);
                                                    maOTP=sc.nextLine();
                                                    if(taikhoan.kiemTraMaOTP(maOTP))
                                                    {
                                                        taikhoanTT.chuyenTien(tkNhan1, tienChuyen);    
                                                        taikhoan.ThemLichSu("\nBạn đã chuyển tiền cho tài khoản("+stkNhan+" - "+tkNhan.chutk+") "+tienChuyen+"00đ lúc "+LocalDateTime.now().format(formatter).toString());                               
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Mã OTP không đúng.Vui lòng nhập lại!");
                                                        soLanNhapSai++;
                                                    }
                                                }
                                                else
                                                    System.out.println("\nSố tiền chuyển không hợp lệ");

                                            }
                                            while(kt && soLanNhapSai<5);
                                            if(soLanNhapSai>5)
                                            {
                                                taikhoanTT.khoaTaiKhoan(5,"");
                                                kt=false;
                                                break;
                                            }
                                        }
                                        else    
                                            System.out.println("\nKhông tìm thấy tài khoản cần chuyển!");
                                    }
                                    break;
                                    case 4:
                                    {
                                        double tienThanhToan=xuLyDouble("Nhập số tiền thanh toán:");
                                        if(tienThanhToan<=taikhoanTT.getSodu())
                                        {
                                            taikhoan.TaoOTP();
                                            soLanNhapSai=1;
                                            do
                                            {
                                                System.out.printf("Nhập mã OTP để thanh toán lần %d/5:",soLanNhapSai);
                                                maOTP=sc.nextLine();
                                                if(taikhoan.kiemTraMaOTP(maOTP))
                                                {

                                                    taikhoanTT.rutTien(tienThanhToan);
                                                    System.out.printf("Bạn đã thanh toán thành công %.0f đ",tienThanhToan);
                                                    taikhoan.ThemLichSu("\nBạn đã thanh toán điện,nước,wifi,.. "+tienThanhToan+"00đ lúc "+LocalDateTime.now().format(formatter).toString());
                                                }
                                                else
                                                {
                                                    System.out.println("Mã OTP không đúng.Vui lòng nhập lại!");
                                                    soLanNhapSai++;
                                                }
                                            }
                                            while(soLanNhapSai<=5 && !taikhoan.kiemTraMaOTP(maOTP));
                                        }
                                        else
                                            System.out.println("Số tiền trong tài khoản thanh toán không đủ để thanh toán!");

                                    }
                                    break;
                                   
                                    case 5:
                                    {
                                        if(taikhoanTT.getSoNo()!=0)
                                            System.out.printf("\nSố dư tài khoản thanh toán của bạn là:%.0fđ | (Nợ %.0fđ.Thời gian còn lại để trả là:%.0f Ngày)\n",taikhoanTT.getSodu(),taikhoanTT.getSoNo(),taikhoanTT.ThoiGianConLai()); 
                                        else
                                            System.out.printf("\nSố dư tài khoản thanh toán của bạn là:%.0fđ\n",taikhoanTT.getSodu());  
                                    
                                    }break;
                                    case 6:
                                    {
                                        if(!taikhoan.getLocket())
                                        {
                                            boolean kt=true;
                                            soLanNhapSai=1;
                                            do
                                            {
                                                System.out.printf("Nhập mật khẩu cũ để đổi mật khẩu lần %d/5:",soLanNhapSai);
                                                matkhau=sc.nextLine();
                                                if(taikhoan.kiemtraMatKhau(matkhau))
                                                {
                                                    System.out.print("Nhập mật khẩu mới cần đổi(Mật khẩu phải chứa kí tự Hoa,Thường,Số và đủ 5 kí tự):");
                                                    String mkMoi=sc.nextLine();
                                                    if(kiemTraMatKhauHopLe(mkMoi))
                                                    {
                                                        taikhoan.doiMatKhau(mkMoi);
                                                        kt=false;
                                                    }
                                                    else    
                                                        System.out.println("Nhập mật khẩu không thoải mãn!");
                                                }
                                                else
                                                    soLanNhapSai++;
                                            }while(kt && soLanNhapSai<=5);
                                            if(soLanNhapSai>5)
                                            {
                                                taikhoan.khoaTaiKhoan(5,"");
                                                break;
                                            }
                                        }
                                        else
                                            System.out.println("Tài khoản của bạn đã bị khoá.Vui lòng chờ 5 phút");           
                                    }
                                    break;
                                    case 7:
                                        if(taikhoan.lichSu!="")
                                            System.out.println(taikhoan.lichSu);
                                        else
                                            System.out.println("\nChưa có thông tin biến động");
                                    break;
                                    case 0:
                                         
                                        break;                      
                                    default:
                                        System.out.println("\nLựa chọn không hợp lệ.");
                                        break;
                                      
                                    }
                                
                                    
                                }while (lc!=0);     
                        }
                        else                
                            System.out.println("Tài khoảng của bạn đã bị khoá !");
                    }
                    else
                        System.out.println("Tài khoảng không hợp lệ!");              
                }
                break;
                case 3:
                {
                    System.out.print("Nhập số tài khoản muốn khôi phục mật khẩu: ");
                    stk = sc.nextLine();
                    TaiKhoan taikhoan = DS.searchAcount(stk);

                    if (taikhoan != null) 
                    {
                        System.out.print("Nhập số điện thoại để đặt lại mật khẩu: ");
                        SDT = sc.nextLine();
                        dem=1;
                        boolean kt=true;
                        if (taikhoan.ktSDT(SDT)) 
                        {
                            do
                            {
                                System.out.printf("Nhập mật khẩu mới lan %d/3:",dem);
                                String matKhauMoi = sc.nextLine();
                                if(kiemTraMatKhauHopLe(matKhauMoi))
                                {
                                    taikhoan.doiMatKhau(matKhauMoi);
                                    System.out.println("Mật khẩu đã được đổi thành công!");
                                    kt=false;
                                }
                                else    
                                {
                                    System.out.println("Nhập mật khẩu không thoải mãn!Vui lòng nhập lại");
                                    dem++;
                                }
                            }while(kt && dem<=3);
                        } 
                        else 
                            System.out.println("\nsố điện thoại không đúng.");
                    } 
                    else 
                        System.out.println("\nSố tài khoản không tồn tại.");
                }
                break;
                
                   
                case 0:
                    {
                        System.out.println("\nCảm ơn quý khách đã dùng dịch vụ ngân hàng TinhBank👋!");
                        Main.main(new String[]{});

                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;           
            }  
        } 
    }   
}
