package Tuan7;
import java.util.Scanner;
public class main {
    
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
        // if (!matkhau.matches(".*[!@#$%^&*()].*")) 
        //     return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DSTaiKhoang DS = new DSTaiKhoang();
        
        String stk;
        String tentk;
        String matkhau;
        String maKhoiPhuc;
        int dem;
        while (true) 
        {
            System.out.println("-----------------------------------------------");
            System.out.println("Bạn chọn làm gì:");
            System.out.println("1.Đăng kí tài khoản");
            System.out.println("2.Xuất danh sách thông tin của các tài khoảng");
            System.out.println("3.Đăng nhập tài khoản");
            System.out.println("4.Quên mật khẩu");
            System.out.println("0.Thoát chương trình");

            System.out.print("Nhập sự lựa chọn: ");
            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1:
                {
                    System.out.print("Tạo số tài khoản: ");
                    stk = sc.nextLine();
                    System.out.print("Tạo chủ tài khoản: ");
                    tentk = sc.nextLine();
                    System.out.print("Tạo mật khẩu cho tài khoản(Mật khẩu phải chứa kí tự Hoa,Thường,Số và đủ 5 kí tự): ");
                    matkhau = sc.nextLine();
                    
                    dem=1;
                    if(!DS.kiemTraTrung(stk, tentk))
                    {
                        if(!kiemTraMatKhauHopLe(matkhau))
                        {
                            while (dem<=5 && !kiemTraMatKhauHopLe(matkhau)) 
                            {
                                System.out.printf("Tạo mật khẩu cho tài khoản lần %d/5:",dem);
                                matkhau = sc.nextLine();
                                if(kiemTraMatKhauHopLe(matkhau))
                                {
                                    System.out.print("Tạo mã khôi phục:");
                                    maKhoiPhuc=sc.nextLine();
                                    NganHang account = new NganHang(stk, tentk,matkhau,maKhoiPhuc);
                                    DS.addAcount(account);

                                    System.out.printf("Tài khoản vừa mới thêm là: Account(stk: %s, tentk: %s, matkhau: %s,sodu:50000₫)\n", stk, tentk,matkhau);
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
                            System.out.print("Tạo mã khôi phục:");
                            maKhoiPhuc=sc.nextLine();
                            NganHang account = new NganHang(stk, tentk,matkhau,maKhoiPhuc);
                            DS.addAcount(account);
                            System.out.printf("Tài khoản vừa mới thêm là: Account(stk: %s, tentk: %s, matkhau: %s,sodu:50000₫)\n", stk, tentk,matkhau);
                        }
                    }
                    else
                        System.out.println("Số tài khoản hoặc tên tài khoản đã tồn tại.Vui lòng nhập lại!");
                    
                }       
                break;
                case 2: 
                {
                    System.out.printf("%-10s %-20s %-20s\n", "Số TK", "Tên TK", "Số tiền trong TK");
                    DS.showAccount();
                }
                break;
                case 3: 
                {
                    System.out.print("Nhập số tài khoản cần đăng nhập:");
                    stk = sc.nextLine();
                    // int dem=0;
                    NganHang taikhoan = DS.searchAcount(stk);

                    if (taikhoan != null) 
                    {
                        System.out.print("Nhập mật khẩu tài khoản cần đăng nhập:");
                        matkhau = sc.nextLine();

                        int count = 0;
                        while (!taikhoan.kiemtraMatKhau(matkhau)) 
                        {
                            count++;
                            System.out.printf("Mật khẩu sai. Nhập lại mật khẩu tài khoản cần đăng nhập lần %d:", count);
                            matkhau = sc.nextLine();
                            if (count >= 5)
                                break;
                        }

                        if (taikhoan.kiemtraMatKhau(matkhau)) 
                        {
                            System.out.printf("\nTài khoản bạn chọn là: %s\n", taikhoan.getStk());
                            System.out.printf("Tên chủ tài khoản là: %s\n", taikhoan.chutk);
                            while (true) 
                            {
                                System.out.println("\n1.Nạp tiền");
                                System.out.println("2.Rút tiền");
                                System.out.println("3.Chuyển khoảng");
                                System.out.println("4.Xem số dư");
                                System.out.println("5.Đổi mật khẩu");
                                System.out.println("0.Thoát!");
                                System.out.print("Nhập lựa chọn: ");
                                int m = sc.nextInt();
                                sc.nextLine();  // Bổ sung dòng này để xử lý dư dữ liệu

                                boolean exit = true;
                                switch (m)
                                {
                                    case 1:
                                    {
                                      System.out.print("Nhập số tiền cần nạp: ");
                                      double tienNop = sc.nextDouble();
                                      taikhoan.napTiep(tienNop);
                                      System.out.printf("Số tiền mới trong tài khoản là: %.0f₫\n", taikhoan.getSodu());  
                                    }                      
                                      break;
                                    case 2:
                                    {
                                        System.out.print("Nhập số tiền cần rút: ");
                                        double tienRut = sc.nextDouble();
                                        sc.nextLine();
                                        int d=0;
                                        boolean kt=true;
                                        do
                                        {
                                            System.out.printf("Nhập mật khẩu để rút lần %d/5:",d+1);
                                            matkhau=sc.nextLine();
                                            if(taikhoan.kiemtraMatKhau(matkhau))
                                            {
                                                if (taikhoan.getSodu() >= tienRut)
                                                {
                                                    taikhoan.rutTien(tienRut);
                                                    System.out.printf("Số tiền mới trong tài khoản là: %.0f₫\n", taikhoan.getSodu());
                                                    kt=false;
                                                }
                                                else 
                                                {
                                                    System.out.println("\nSố dư không đủ để thực hiện giao dịch.");
                                                    kt=false;
                                                }
                                            }
                                            else
                                                d++;
                                            
                                        }while(kt && d<5);
                                    }
                                    break;
                                    case 3:
                                    {
                                        System.out.print("Nhập số tài khoản nhận: ");
                                        String stkNhan = sc.nextLine();

                                        NganHang tkNhan = DS.searchAcount(stkNhan);
                                        
                                        if (tkNhan != null) {                                          
                                            System.out.printf("Tài khoản nhận: %s - %s\n", tkNhan.getStk(), tkNhan.chutk);
                                            
                                            System.out.print("Nhập số tiền cần chuyển: ");
                                            double tienChuyen = sc.nextDouble();

                                            taikhoan.chuyenTien(tkNhan,tienChuyen);
                                        }
                                        else    
                                            System.out.println("Không tìm thấy tài khoản cần chuyển!");
                                    }break;
                                    case 4:
                                        System.out.printf("\nSố dư của bạn là:%.0f\n",taikhoan.getSodu());
                                        break;
                                    case 5:
                                    {
                                        boolean kt=true;
                                        dem=1;
                                        do
                                        {
                                            System.out.printf("Nhập mật khẩu cũ để đổi mật khẩu lần %d/5:",dem);
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
                                                dem++;
                                        }while(kt && dem<=5);
                                       
                                    }
                                    break;
                                    case 0:
                                        exit=false;
                                    break;
                                    default:
                                        System.out.println("\nLựa chọn không hợp lệ.");
                                }
                                if(!exit)
                                    break;
                            }  
                        }
                        else                
                            System.out.println("Mật khẩu sai.Vui lòng thử lại!");
                    }
                    else
                        System.out.println("Tài khoảng không hợp lệ!");              
                }   
                break;
                case 4:
                {
                    System.out.print("Nhập số tài khoản muốn khôi phục mật khẩu: ");
                    stk = sc.nextLine();
                    NganHang taikhoan = DS.searchAcount(stk);

                    if (taikhoan != null) 
                    {
                        System.out.print("Nhập mã khôi phục để đặt lại mật khẩu: ");
                        maKhoiPhuc = sc.nextLine();
                        dem=1;
                        boolean kt=true;
                        if (taikhoan.kiemTraMaKhoiPhuc(maKhoiPhuc)) 
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
                            System.out.println("\nMã khôi phục không đúng.");
                    } 
                    else 
                        System.out.println("\nSố tài khoản không tồn tại.");
                }
                break;
                case 0:
                    System.out.println("\nThoát chương trình.");
                    return;
                default: 
                    System.out.println("\nError! Nhập lại.");
                    break;
            }
        }
    }
}
