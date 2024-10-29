package Tuan8;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
public class main {
    
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
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        DSTaiKhoang DS = new DSTaiKhoang();
        
        String stk;
        String tentk;
        String matkhau;
        String maOTP;
        int dem;

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> unlimitedDepositTask = null;
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
                                    System.out.print("Tạo mã OTP:");
                                    maOTP=sc.nextLine();
                                    NganHang account = new NganHang(stk, tentk,matkhau,maOTP);

                                    TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan(stk, tentk,matkhau,maOTP) ;                 
                                    TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem(stk, tentk,matkhau,maOTP);
                                    // tkThanhToan.truPhiThuongNien();
                                    scheduler.scheduleAtFixedRate(
                                        tkThanhToan::truPhiThuongNien, 0, 365, TimeUnit.DAYS);
                                    account.addTaiKhoanCon(tkThanhToan,tkTietKiem); 
                                    DS.addAcount(account);
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
                            NganHang account = new NganHang(stk, tentk,matkhau,maOTP);
                            TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan(stk, tentk,matkhau,maOTP) ;                 
                            TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem(stk, tentk,matkhau,maOTP);
                            // tkThanhToan.truPhiThuongNien();
                            scheduler.scheduleAtFixedRate(
                                tkThanhToan::truPhiThuongNien, 0, 365, TimeUnit.DAYS);
                            account.addTaiKhoanCon(tkThanhToan,tkTietKiem); 
                            DS.addAcount(account);
                            System.out.printf("\nTài khoản vừa mới thêm là: Account(stk: %s, tentk: %s, matkhau: %s,sodu:50000₫)\n", stk, tentk,matkhau);
                        }
                    }
                    else
                        System.out.println("\nSố tài khoản hoặc tên tài khoản đã tồn tại. Vui lòng nhập lại!");
                }       
                break;
                case 2: 
                {
                    System.out.printf("%-10s %-10s %-20s %-40s\n", "Số TK", "Tên TK", "Số tiền trong TK","Trạng thái");
                    DS.showAccount();
                }
                break;
                case 3: 
                {
                    System.out.print("Nhập số tài khoản cần đăng nhập:");
                    stk = sc.nextLine();
                    NganHang taikhoan = DS.searchAcount(stk);

                    if (taikhoan != null) 
                    {
                        System.out.print("Nhập mật khẩu tài khoản cần đăng nhập:");
                        matkhau = sc.nextLine();

                        taikhoan.soLanNhapSai=0;
                        while (!taikhoan.kiemtraMatKhau(matkhau) && taikhoan.soLanNhapSai<5) 
                        {
                            taikhoan.soLanNhapSai++;
                            System.out.printf("Mật khẩu sai. Nhập lại mật khẩu tài khoản cần đăng nhập lần %d:", taikhoan.soLanNhapSai);
                            matkhau = sc.nextLine();  
                        }
                        if (taikhoan.soLanNhapSai >= 5)
                                taikhoan.khoaTaiKhoan();
                                
                        if (!taikhoan.getLocket()) 
                        {
                            System.out.printf("\nTài khoản bạn chọn là: %s\n", taikhoan.getStk());
                            System.out.printf("Tên chủ tài khoản là: %s\n", taikhoan.chutk);
                            while (true) 
                            {
                                System.out.println("\n1.Tài khoản thanh toán");
                                System.out.println("2.Tài khoản tiết kiệm");
                                System.out.println("3.Đổi mật khẩu");
                                System.out.println("4.Xem thông tin các tài khoản con");
                                System.out.println("0.Thoát!");

                                System.out.print("Nhập lựa chọn: ");
                                int m = sc.nextInt();
                                sc.nextLine();  // Bổ sung dòng này để xử lý dư dữ liệu
                                boolean exit = true;
                                switch (m)
                                {
                                    
                                    case 1:
                                    {
                                        TaiKhoanThanhToan tkThanhToan=taikhoan.getTaiKhoanCon().keySet().iterator().next();
                                        if(!tkThanhToan.getLocket())
                                        {
                                            boolean kt=true;
                                        
                                           
                                            while(kt)
                                            {
                                                System.out.println("\n---------------Tài khoản thanh toán---------------");
                                                System.out.println("1.Nạp tiền tài khoản");
                                                System.out.println("2.Rút tiền");
                                                System.out.println("3.Chuyển khoảng");
                                                System.out.println("4.Thanh toán tiền điện,nước,wifi,....");
                                                System.out.println("5.Xem số dư tài khoản");
                                                System.out.println("0.Thoát tài khoản!");

                                                int h;
                                                System.out.print("Mời bạn nhập lựa chọn:");
                                                h=sc.nextInt();
                                                sc.nextLine();
                                                switch (h) 
                                                {
                                                    case 1:
                                                    {
                                                        System.out.print("Nhập số tiền cần nạp: ");
                                                        double tienNop = sc.nextDouble();
                                                        if(tienNop>=0)
                                                        {
                                                            tkThanhToan.napTiep(tienNop);                                  
                                                            System.out.printf("Số tiền mới trong tài khoản thanh toan là: %.0f₫\n", tkThanhToan.getSodu());  
                                                        }
                                                        else
                                                            System.out.println("Số tiền nộp không hợp lệ!");                                                 
                                                    }
                                                        break;
                                                        case 2:
                                                        {
                                                            System.out.print("Nhập số tiền cần rút: ");
                                                            double tienRut = sc.nextDouble();
                                                            sc.nextLine();
                                                            tkThanhToan.soLanNhapSai=0;
                                                            kt=true;
                                                            do
                                                            {
                                                                System.out.printf("Nhập mật khẩu để rút lần %d/5:",taikhoan.soLanNhapSai);
                                                                matkhau=sc.nextLine();
                                                                if(taikhoan.kiemtraMatKhau(matkhau))
                                                                {
                                                                    TaiKhoanThanhToan TKTT=taikhoan.getTaiKhoanCon().keySet().iterator().next();
                                                                    if (TKTT.getSodu() >= tienRut)
                                                                    {
                                                                        taikhoan.getTaiKhoanCon().keySet().iterator().next().rutTien(tienRut);
                                                                        System.out.printf("Số tiền mới trong tài khoản là: %.0f₫\n", TKTT.getSodu());
                                                                        kt=false;
                                                                    }
                                                                    else 
                                                                    {
                                                                        System.out.println("\nSố dư không đủ để thực hiện giao dịch.");
                                                                        kt=false;
                                                                    }
                                                                }
                                                                else
                                                                    taikhoan.soLanNhapSai++;
                                                                
                                                            }while(kt && taikhoan.soLanNhapSai<5);
                                                            if(taikhoan.soLanNhapSai>=5)
                                                            {
                                                                tkThanhToan.khoaTaiKhoan();
                                                                kt=false;
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    
                                                        case 3:
                                                        {
                                                            System.out.print("Nhập số tài khoản nhận: ");
                                                            String stkNhan = sc.nextLine();
                    
                                                            NganHang tkNhan = DS.searchAcount(stkNhan);
                                                            tkThanhToan.soLanNhapSai=1;
                                                            if (tkNhan != null) 
                                                            {                                          
                                                                System.out.printf("Tài khoản nhận: %s - %s\n", tkNhan.getStk(), tkNhan.chutk);
                                                                matkhau="";
                    
                                                                while(tkThanhToan.soLanNhapSai<=5 && !taikhoan.kiemtraMatKhau(matkhau))
                                                                {
                                                                    System.out.printf("Nhập mật khẩu để chuyển tiền lần %d/5:",tkThanhToan.soLanNhapSai);
                                                                    matkhau=sc.nextLine();
                                                                    if(taikhoan.kiemtraMatKhau(matkhau))
                                                                    {
                                                                        System.out.print("Nhập số tiền cần chuyển: ");
                                                                        double tienChuyen = sc.nextDouble();
                                                                        tkThanhToan.chuyenTien(tkNhan.getTaiKhoanCon().keySet().iterator().next(), tienChuyen);                                      
                                                                    }
                                                                    else
                                                                    {
                                                                        System.out.println("Mật khẩu không đúng.Vui lòng nhập lại!");
                                                                        tkThanhToan.soLanNhapSai++;
                                                                    }
                                                                }
                                                                if(tkThanhToan.soLanNhapSai>5)
                                                                    tkThanhToan.khoaTaiKhoan();
                                                                    kt=false;
                                                                    break;
                    
                                                            }
                                                            else    
                                                                System.out.println("Không tìm thấy tài khoản cần chuyển!");
                                                    }
                                                    break;
                                                    case 4:
                                                    {
                                                        System.out.print("Nhập số tiền thanh toán:");
                                                        double tienThanhToan=sc.nextDouble();
                                                        if(tienThanhToan<=tkThanhToan.getSodu())
                                                        {
                                                            tkThanhToan.rutTien(tienThanhToan);
                                                            System.out.printf("Bạn đã thanh toán thành công %.0f đ",tienThanhToan);
                                                        }
                                                        else
                                                            System.out.println("Số tiền trong tài khoản thanh toán không đủ để thanh toán!");
                                                    }
                                                        break;
                                                    case 5:
                                                        System.out.printf("\nSố dư tài khoản thanh toán của bạn là:%.0fđ\n",tkThanhToan.getSodu());                                              
                                                        break;
                                                    case 0:
                                                        kt=false;
                                                        break;
                                                    default:
                                                        System.out.println("\nLỗi.Vui lòng thử  lại.");
                                                        break;
                                                }
                                            }
                                        }
                                        else
                                            System.out.println("Chức năng này đã bị khoá.Vui lòng thử lại sau 5 phút");

                                    
                                    }
                                    break;
                                    case 2: 
                                    {
                                            TaiKhoanTietKiem tkTietKiem = taikhoan.getTaiKhoanCon().get(taikhoan.getTaiKhoanCon().keySet().iterator().next());
                                            boolean kt = true;        
                                            while (kt) 
                                            {
                                                System.out.println("\n---------------Tài khoản tiết kiệm---------------");
                                                System.out.println("1. Nạp tiền tài khoản tiết kiệm");
                                                System.out.println("2. Rút tiền tài khoản tiết kiệm");
                                                System.out.println("3. Chọn thời gian gửi");
                                                System.out.println("4. Xem số dư tài khoản tiết kiệm");
                                                System.out.println("5. Xem thời gian còn lại có thể gửi hoặc rút");
                                                System.out.println("0. Thoát tài khoản tiet kiem!");
                                        
                                                System.out.print("Mời bạn nhập lựa chọn: ");
                                                int h = sc.nextInt();
                                            
                                            
                                            
                                                switch (h) {
                                                    case 1: { 
                                                        if (tkTietKiem.ktThoiHan())
                                                        {

                                                        
                                                            System.out.print("Nhập số tiền cần nạp: ");
                                                            double tienNop = sc.nextDouble();
                                                            if (taikhoan.getTaiKhoanCon().keySet().iterator().next().getSodu() >= tienNop) 
                                                            {
                                                                
                                                                tkTietKiem.napTiep(tienNop);
                                                                taikhoan.getTaiKhoanCon().keySet().iterator().next().rutTien(tienNop);
                                                                System.out.printf("Số tiền mới trong tài khoản tiết kiệm là: %.0f₫\n", tkTietKiem.getSodu());
                                                            } 
                                                            else 
                                                                System.out.println("Tài khoản chính không đủ để nạp!");
                                                            
                                                        } 
                                                        else 
                                                            System.out.println("Thời hạn chưa đủ. Vui lòng đợi");
                                                        
                                                    }
                                                    break;
                                        
                                                    case 2: {
                                                        if (tkTietKiem.ktThoiHan())
                                                        {
                                                            System.out.print("Nhập số tiền cần rút về tài khoản chính: ");
                                                            double tienRut = sc.nextDouble();
                                                            if (tienRut <= tkTietKiem.getSodu()) {
                                                                tkTietKiem.rutTien(tienRut);
                                                                taikhoan.getTaiKhoanCon().keySet().iterator().next().napTiep(tienRut);
                                                                System.out.printf("Bạn đã rút thành công %.0f đ\n", tienRut);
                                                            } 
                                                            else 
                                                                System.out.println("Số tiền trong tài khoản không đủ để rút");
                                                            
                                                        }
                                                        else 
                                                            System.out.println("Thời hạn chưa đủ. Vui lòng đợi");
                                                        
                                                    }
                                                    break;
                                        
                                                    case 3: 
                                                    {
                                                        boolean choosingTime = true;
                                                        while (choosingTime) {
                                                            System.out.println("1. Gửi tiết kiệm không kỳ hạn");
                                                            System.out.println("2. Gửi tiết kiệm có kỳ hạn");
                                                            System.out.println("0. Thoát!");
                                        
                                                            System.out.print("Mời bạn nhập lựa chọn: ");
                                                            int lc = sc.nextInt();
                                        
                                                            switch (lc)
                                                            {
                                                                case 1: 
                                                                {
                                                                    if(tkTietKiem.ktThoiHan())
                                                                    {
                                                                    
                                                                        System.out.println("\nBạn muốn thiết lập hay huỷ gửi tiết kiệm không thời hạn!");
                                                                        System.out.println("1.Chọn gửi không kỳ hạn");
                                                                        System.out.println("2.Chọn huỷ bỏ gửi không kỳ hạn(Nếu đã chon gửi không kỳ hạn)");

                                                                        System.out.print("Nhập lựa chọn:");
                                                                        lc=sc.nextInt();
                                                                        switch (lc) {
                                                                            case 1 -> 
                                                                            {
                                                                                if (unlimitedDepositTask == null || unlimitedDepositTask.isCancelled()) {
                                                                                
                                                                                    unlimitedDepositTask = scheduler.scheduleAtFixedRate(
                                                                                            tkTietKiem::tienLaiHangNgay, 0, 1, TimeUnit.DAYS);
                                                                                    // tkTietKiem.tienLaiHangNgay();
                                                                                    
                                                                                    System.out.println("\nBạn đã chọn thành công gửi không thời hạn.Lãi suất là 0.001% và được cộng vào số dư theo NGÀY");
                                                                                } 
                                                                                else 
                                                                                    System.out.println("Đã có tác vụ gửi không kỳ hạn đang hoạt động.");
                                                                                
                                                                            }
                                                                            case 2 -> 
                                                                            {
                                                                                if (unlimitedDepositTask != null) 
                                                                                {
                                                                                    unlimitedDepositTask.cancel(true);
                                                                                 
                                                                                    System.out.println("\nBạn đã hủy bỏ gửi không kỳ hạn thành công!");
                                                                                } 
                                                                                else
                                                                                    System.out.println("Hiện tại không có gửi không kỳ hạn nào để hủy.");
                                                                                
                                                                            }
                                                                            default -> System.out.println("Lựa chọn không đúng!");
                                                                        }
                                                                    }
                                                                    else
                                                                        System.out.println("\nBạn đã gửi tiết kiệm có kỳ hạn. Vui lòng đợi đến hạn để chọn mục này.\n");
                                                                }
                                                                break;
                                        
                                                                case 2: 
                                                                {
                                                                    System.out.println("Mời bạn chọn số tháng gửi");
                                                                    System.out.println("1. 3 Tháng!");
                                                                    System.out.println("2. 6 Tháng!");
                                                                    System.out.println("3. 12 Tháng!");
                                                                    System.out.println("4. 24 Tháng!");
                                        
                                                                    System.out.print("Mời bạn nhập lựa chọn: ");
                                                                    int monthsChoice = sc.nextInt();
                                        
                                                                    if (tkTietKiem.ktThoiHan()) 
                                                                    {              
                                                                        int month;
                                                                        switch (monthsChoice) 
                                                                        {
                                                                            case 1 -> month = 3;
                                                                            case 2 -> month = 6;
                                                                            case 3 -> month = 12;
                                                                            case 4 -> month = 24;
                                                                            default ->
                                                                            {
                                                                                System.out.println("Lựa chọn không đúng!");
                                                                                continue;
                                                                            }
                                                                        }
                                                                        scheduler.shutdown();
                                                                        tkTietKiem.setSoThangGui(month);
                                                                        tkTietKiem.currenDateTK=LocalDate.now();
                                                                        tkTietKiem.congTienLaiCoKyHan(month);
                                                                    } 
                                                                    else 
                                                                        System.out.println("\nBạn đã gửi thời hạn trước đó. Vui lòng đợi đến hạn để gửi tiếp.\n");   
                                                                }
                                                                break;
                                        
                                                                case 0:
                                                                    choosingTime = false;
                                                                    break;
                                        
                                                                default:
                                                                    System.out.println("Lựa chọn không hợp lệ!");
                                                                    break;
                                                            }
                                                        }
                                                    }
                                                    break;
                                                    
                                                    case 4:
                                                        System.out.printf("\nSố dư tài khoản tiết kiệm của bạn là: %.0fđ\n", tkTietKiem.getSodu());
                                                        break;
                                        
                                                    case 5: {
                                                        if (tkTietKiem.ktThoiHan()) 
                                                            System.out.println("Bạn đã xong thời hạn. Có thể rút tiền hoặc gửi thêm.");
                                                        else
                                                            System.out.printf("Thời gian còn lại của bạn là %.0f/%d Tháng!\n", tkTietKiem.ThoiGianConLai(), tkTietKiem.getSoThangGui());
                                                    }
                                                    break;
                                        
                                                    case 0:
                                                        kt = false;
                                                        break;         
                                                    default:
                                                        System.out.println("\nLỗi. Vui lòng thử lại.");
                                                        break;
                                                }
                                            }          
                                    }
                                    break;
                                    case 3:
                                    {
                                        if(!taikhoan.getLocket())
                                        {
                                            boolean kt=true;
                                            taikhoan.soLanNhapSai=1;
                                            do
                                            {
                                                System.out.printf("Nhập mật khẩu cũ để đổi mật khẩu lần %d/5:",taikhoan.soLanNhapSai);
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
                                                    taikhoan.soLanNhapSai++;
                                            }while(kt && taikhoan.soLanNhapSai<=5);
                                            if(taikhoan.soLanNhapSai>5)
                                            {
                                                taikhoan.khoaTaiKhoan();
                                                exit=false;
                                            }

                                        }
                                        else
                                            System.out.println("Tài khoản của bạn đã bị khoá.Vui lòng chờ 5 phút");           
                                    }
                                    break;
                                    case 4:
                                        taikhoan.hienThi();
                                       break;
                                    case 0:
                                        exit=false;
                                    break;                      
                                    default:
                                        System.out.println("\nLựa chọn không hợp lệ.");
                                        break;
                                }
                                if(!exit)
                                    break;
                            }  
                        }
                        else                
                            System.out.println("Tài khoảng của bạn đã bị khoá !");
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
                        System.out.print("Nhập mã OTP để đặt lại mật khẩu: ");
                        maOTP = sc.nextLine();
                        dem=1;
                        boolean kt=true;
                        if (taikhoan.kiemTraMaOTP(maOTP)) 
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
                            System.out.println("\nMã OTP không đúng.");
                    } 
                    else 
                        System.out.println("\nSố tài khoản không tồn tại.");
                }
                break;
                case 5:
                {

                
                }break;
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
