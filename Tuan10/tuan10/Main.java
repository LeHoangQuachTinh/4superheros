package tuan10;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
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
    
    public static int xuLyInt(String thongbao) {
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
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
        Scanner sc = new Scanner(System.in);
        Admin DS = new Admin();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        DS.docFileTaiKhoan("taikhoan.txt");
        String stk;
        String matkhau;
        String maOTP;
        String maQuanTri;
        String SDT;
        int dem;
        int soLanNhapSai;
        int lc;
        boolean kt;

       

        while (true) 
        {
            System.out.println("--------------------Ngân hàng TinhBank xin chào 😜--------------------!");
            System.out.println("Vai trò của bạn là gì");
            System.out.println("1.Quản trị viên ngân hàng");
            System.out.println("2.Người dùng ngân hàng");
            System.out.println("0.Thoát ứng dụng!");

            int choose=xuLyInt("Nhập lựa chọn của bạn:");
            switch (choose) 
            {
                case 1:
                {
                    System.out.print("Nhập mã quản trị để đăng nhập vào hệ thống:");
                    maQuanTri=sc.nextLine();
                    dem=0;
                    while (!DS.kiemtraMaQuanTri(maQuanTri) && dem<3 ) 
                    {
                        dem++;
                        System.out.printf("Nhập lại mã quản trị lần %d\3:",dem);
                        maQuanTri=sc.nextLine();
                    }
                    if(DS.kiemtraMaQuanTri(maQuanTri))
                    {
                        boolean quantri=true;
                        while (quantri) 
                        {
                            System.out.println("\n--------------👨‍💻 Chức năng quản trị viên ngân hàng 👨‍💻-----------------");
                            System.out.println("1.Thêm tài khoản ngân hàng");
                            System.out.println("2.Xoá tài khoản ngân hàng");
                            System.out.println("3.Chỉnh sửa khoản ngân hàng");
                            System.out.println("4.Khoá tài khoản chỉ định");
                            System.out.println("5.Mở khoá tài khoản chỉ định đang bị khoá");
                            System.out.println("6.Xuất danh sách thông tin của các tài khoảng hiện có");
                            System.out.println("7.Chỉnh sửa các thông số laisuat,phithuongnien,....");
                            System.out.println("8.Đổi mã Quản Trị Viên");
                            System.out.println("0.Thoát chương trình!\n");

                            lc=xuLyInt("Nhập lựa chọn của bạn:");
                            switch (lc) 
                            {
                                case 1:
                                    DS.dangKiTaiKhoan();
                                    break;
                                case 2:
                                {
                                    System.out.print("Nhập số tài khoản cần xoá:");
                                    stk=sc.nextLine();
                                    System.out.print("Nhập lý do xoá tài khoản:");
                                    String lydo=sc.nextLine();
                                    NganHang taikhoan=DS.searchAcount(stk);
                                    if(taikhoan!=null)
                                    {
                                        DS.deleteAccount(stk);
                                        System.out.printf("\nBạn đã xoá tài khoản %s.Vì lý do %s\n",stk,lydo);
                                    }
                                    else
                                        System.out.println("Tài khoản không tồn tại!");
                                }
                                    break;
                                case 3:
                                {
                                    System.out.print("Nhập tài khoản cần sửa:");
                                    stk=sc.nextLine();
                                    NganHang taikhoan=DS.searchAcount(stk);
                                    if(taikhoan!=null)
                                    {
                                        kt=true;
                                        while (kt) 
                                        {
                                            System.out.println("\n-----------Chỉnh sửa tài khoản ngân hàng-------------");
                                            System.out.println("1.Đổi tên tài khoản");
                                            System.out.println("2.Đổi số điện thoại tài khoản");
                                            System.out.println("3.Đổi mật khẩu tài khoản");
                                            System.out.println("0.Thoát!");
                                            int lc1=xuLyInt("Nhập lựa chọn:");

                                            switch (lc1) {
                                                case 1:
                                                {
                                                    System.out.print("Nhập tên tài khoản mới:");
                                                    String tenMoi=sc.nextLine();
                                                    taikhoan.chutk=tenMoi;
                                                    System.out.println("\nĐổi tên thành công!\n");
                                                }
                                                    break;
                                                case 2:
                                                {
                                                    System.out.print("Nhập số điện thoại  mới:");
                                                    String sdt=sc.nextLine();
                                                    if(kiemtraSDTHopLe(sdt))
                                                    {
                                                        taikhoan.setSDT(sdt);
                                                        System.out.println("\nĐổi số điện thoại thành công thành công!\n");
                                                    }
                                                    else
                                                        System.out.println("\nSố điện thoại chưa đúng định dạng.Vui lòng thử lại!\n");
                                                }
                                                    break;
                                                case 3:
                                                {
                                                    System.out.print("Nhập mật khẩu mới(Mật khẩu phải chứa kí tự Hoa,Thường,Số,Kí tự đặt biệt và đủ 5 kí tự):");
                                                    String matkhauMoi=sc.nextLine();

                                                    if(kiemTraMatKhauHopLe(matkhauMoi))
                                                        taikhoan.doiMatKhau(matkhauMoi);
                                                    else
                                                        System.out.println("Mật khẩu mới chưa hợp lệ.Vui lòng thử lại");
                                                }
                                                    break;
                                                case 0:
                                                    kt=false;
                                                break;
                                                default:
                                                    break;
                                            }

                                        };
                                    }
                                    else
                                        System.out.println("\nTài khoản không tồn tại!");
                                }
                                break;
                                case 4:
                                {
                                    System.out.print("Nhập tài khoản cần khoá:");
                                    stk=sc.nextLine();
                                
                                    NganHang taikhoan=DS.searchAcount(stk);
                                    if(taikhoan!=null)
                                    {
                                        int thoigian=xuLyInt("Bạn muốn khoá tài khoản bao nhiêu phút:");
                                        DS.searchAcount(stk).khoaTaiKhoan(thoigian,"Bạn đã khoá tài khoản "+stk+" trong vòng "+thoigian+" phút!");
                                    }
                                    else
                                        System.out.println("\nTài khoản không tồn tại!");
                                }
                                    break;
                                case 5:
                                {
                                    System.out.print("Nhập số tài khoản cần mở:");
                                    stk=sc.nextLine();

                                    NganHang TK=DS.searchAcount(stk);
                                    if(TK!=null)
                                    {
                                        if(TK.getLocket())
                                        {
                                            TK.moKhoa();
                                            System.out.printf("Đã mở khoá thành công tài khoản(%s - %s)\n",TK.getStk(),TK.chutk);
                                        }
                                        else
                                            System.out.printf("Tài khoản (%s - %s) không bị khoá.Nên không cần mở khoá\n",TK.getStk(),TK.chutk);
                                    }
                                    else 
                                        System.out.println("!Không tim thấy tài khoản chỉ định.Vui lòng thử lại sau!");
                                }break;
                                case 6:
                                {
                                    System.out.printf("%-10s %-10s %-10s %-20s %-40s\n", "Số TK", "Chủ TK","Mật khẩu", "Số tiền trong TK","Trạng thái");
                                    DS.showAccount();
                                }
                                break;
                                case 7:
                                {
                                    kt=true;
                                    while (kt) {
                                        System.out.println("------------Các thông số trong ngân hàng---------------");
                                        System.out.println("1.Chỉnh phí thường niên trong tài khoản thanh toán");
                                        System.out.println("2.Chỉnh phí lãi suất vay trong tài khoản thanh toán");
                                        System.out.println("3.Chỉnh ngày hết hạn vay tài khoản thanh toán");
                                        System.out.println("4.Chỉnh lãi suất dài hạn trong tài khoản tiết kiệm");
                                        System.out.println("0.Thoát! ");

                                        int lc2=xuLyInt("Nhập lựa chọn:");

                                        switch (lc2) {
                                            case 1:
                                            {
                                                double phiThuongNien=xuLyDouble("Nhập phí thường niên mới:");
                                                for (NganHang NH : DS.getDS().values()) {
                                                    NH.getTaiKhoanCon().keySet().iterator().next().setPhiThuongNien(phiThuongNien);
                                                }
                                                System.out.println("Chỉnh sửa thành công!\n");
                                            }
                                            break;
                                            case 2:
                                            {
                                                double laiSuatVay=xuLyDouble("Nhập lãi suất vay mới :");
                                                for (NganHang NH : DS.getDS().values()) {
                                                    NH.getTaiKhoanCon().keySet().iterator().next().setLaiSuatVay(laiSuatVay);
                                                }
                                                System.out.println("Chỉnh sửa thành công!\n");
                                            }
                                            break;
                                            case 3:
                                            {
                                                int soNgayHetHang=xuLyInt("Nhập ngày hết hạn  mới:");
                                                for (NganHang NH : DS.getDS().values()) {
                                                    NH.getTaiKhoanCon().keySet().iterator().next().setSoNgayHetHang(soNgayHetHang);
                                                }
                                                System.out.println("Chỉnh sửa thành công!\n");
                                            }
                                            break;
                                            case 4:
                                            {
                                                double laiSuatDaiHan=xuLyDouble("Nhập lãi suất dài hạn mới:");
                                                for (NganHang NH : DS.getDS().values()) {
                                                    NH.getTaiKhoanCon().values().iterator().next().setLaiSuatDaiHan(laiSuatDaiHan);
                                                }
                                                System.out.println("Chỉnh sửa thành công!\n");
                                            }
                                            break;
                                            case 0:
                                                kt=false;
                                            break;
                                            default:
                                                System.out.println("\nLỗi.Vui lòng nhập lại\n");
                                                break;
                                        }
                                    }
                                }
                                break;
                                case 8:
                                {
                                    dem=1;
                                    do
                                    {
                                        System.out.printf("Nhập mã Quản Trị cũ để đổi mật khẩu lần %d/3:",dem);
                                        maQuanTri=sc.nextLine();
                                        if(DS.kiemtraMaQuanTri(maQuanTri))
                                        {
                                            System.out.print("Nhập mã Quản Trị mới cần đổi:");
                                            String maQuanTriMoi=sc.nextLine();
                                            if(kiemTraMatKhauHopLe(maQuanTriMoi))
                                            {
                                                DS.setMaQuanTri(maQuanTriMoi);
                                                System.out.println("\nMã Quản Trị đã đổi thành công!\n");
                                                break;
                                            }
                                            else    
                                                System.out.println("Nhập mã Quản Trị không thoải mãn!");
                                        }
                                        else
                                            dem++;
                                    }while(dem<=3);
                                    if(dem>3)
                                        System.out.println("Thay đổi mã quản trị không thành công!\n");
                                }
                                break;
                                case 0:
                                    quantri=false;
                                    break;
                                default:
                                    System.out.println("Lựa chọn không hợp lệ!");
                                    break;
                            }
                            if(!quantri)
                                break;
                        }
                    }
                    else
                        System.out.println("\nMã quản trị của bạn không đúng.Thoát!\n");
                }
                break;
                case 2:
                {
                    boolean lap=true;
                    while (lap) 
                    {
                        System.out.println("\n-----------------🧑‍💼 Người dùng 🧑‍💼-------------------");
                        System.out.println("Bạn chọn làm gì:");
                        System.out.println("1.Đăng kí tài khoản");
                        System.out.println("2.Đăng nhập tài khoản");
                        System.out.println("3.Quên mật khẩu");
                        System.out.println("0.Thoát chương trình");

                        int n = xuLyInt("Nhập sự lựa chọn: ");
                        switch (n) 
                        {
                            case 1:
                               DS.dangKiTaiKhoan();     
                            break;
                            case 2: 
                            {
                                System.out.print("Nhập số tài khoản cần đăng nhập:");
                                stk = sc.nextLine();
                                NganHang taikhoan = DS.searchAcount(stk);

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
                                        while (true) 
                                        {
                                            System.out.println("\n--------------🤑 Tài khoản chính 🤑----------------");
                                            System.out.println("1.Tài khoản thanh toán");
                                            System.out.println("2.Tài khoản tiết kiệm");
                                            System.out.println("3.Đổi mật khẩu");
                                            System.out.println("4.Xem thông tin các tài khoản con");
                                            System.out.println("5.Lịch sử");
                                            System.out.println("0.Thoát!");

                                            int m = xuLyInt("Nhập lựa chọn: ");
                                            boolean exit = true;
                                            switch (m)
                                            {
                                                case 1:
                                                {
                                                    TaiKhoanThanhToan tkThanhToan=taikhoan.getTaiKhoanCon().keySet().iterator().next();
                                                    if(!taikhoan.getLocket())
                                                    {
                                                        kt=true;
                                                        while(kt)
                                                        {
                                                            System.out.println("\n---------------💵 Tài khoản thanh toán 💵---------------");
                                                            System.out.println("1.Nạp tiền tài khoản");
                                                            System.out.println("2.Rút tiền");
                                                            System.out.println("3.Chuyển khoảng");
                                                            System.out.println("4.Thanh toán tiền điện,nước,wifi,....");
                                                            System.out.println("5.Vay nợ ngân hàng");
                                                            System.out.println("6.Xem số dư tài khoản");
                                                            System.out.println("0.Thoát tài khoản!");

                                                            int h;
                                                            h=xuLyInt("Mời bạn nhập lựa chọn:");
                                                            switch (h) 
                                                            {
                                                                case 1:
                                                                {
                                                                    double tienNop = xuLyDouble("Nhập số tiền cần nạp: ");
                                                                    if(tienNop>=0)
                                                                    {
                                                                        tkThanhToan.napTiep(tienNop);                                  
                                                                        System.out.printf("Số tiền mới trong tài khoản thanh toan là: %.0f₫\n", tkThanhToan.getSodu()); 
                                                                        // taikhoan.ThemLichSu("\nBạn đã nộp tiền vào tài khoản "+tienNop+"00đ lúc "+LocalDateTime.now().format(formatter).toString());
                                                                    }
                                                                    else
                                                                        System.out.println("Số tiền nộp không hợp lệ!");                                                 
                                                                }
                                                                break;
                                                                case 2:
                                                                {
                                                                    double tienRut=xuLyDouble("Nhập số tiền cần rút:");
                                                                    taikhoan.TaoOTP();
                                                                    sc.nextLine();
                                                                    do
                                                                    {

                                                                        System.out.printf("Nhập mã OTP để rút lần %d/5:",soLanNhapSai);
                                                                        maOTP=sc.nextLine();
                                                                        if(taikhoan.kiemTraMaOTP(maOTP))
                                                                        {
                    
                                                                            if (tkThanhToan.getSodu() >= tienRut)
                                                                            {
                                                                                
                                                                                taikhoan.getTaiKhoanCon().keySet().iterator().next().rutTien(tienRut);
                                                                                taikhoan.otpTask.cancel(true);
                                                                                System.out.printf("Số tiền mới trong tài khoản là: %.0f₫\n",tkThanhToan.getSodu());
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
                                                                        taikhoan.khoaTaiKhoan(5,"");
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
                                                                    if (tkNhan != null && !taikhoan.getStk().equals(stkNhan)) 
                                                                    {                                          
                                                                        System.out.printf("Tài khoản nhận: %s - %s\n", tkNhan.getStk(), tkNhan.chutk);
                        
                                                                        soLanNhapSai=1;
                                                                       
                                                                        double tienChuyen = xuLyDouble("Nhập số tiền cần chuyển: ");
                                                                        if(tienChuyen>0)
                                                                        {
                                                                            taikhoan.TaoOTP();
                                                                            sc.nextLine();
                                                                            do
                                                                            {
                                                                                System.out.printf("Nhập mã OTP để chuyển khoản lần %d/5:",soLanNhapSai);
                                                                                maOTP=sc.nextLine();
                                                                                if(taikhoan.kiemTraMaOTP(maOTP))
                                                                                {
                                                                                    tkThanhToan.chuyenTien(tkNhan.getTaiKhoanCon().keySet().iterator().next(), tienChuyen);    
                                                                                    taikhoan.ThemLichSu("\nBạn đã chuyển tiền cho tài khoản("+stkNhan+" - "+tkNhan.chutk+") "+tienChuyen+"00đ lúc "+LocalDateTime.now().format(formatter).toString());  
                                                                                    taikhoan.otpTask.cancel(true);
                                                                                    kt=false;                      
                                                                                }
                                                                                else
                                                                                {
                                                                                    System.out.println("Mã OTP không đúng.Vui lòng nhập lại!");
                                                                                    soLanNhapSai++;
                                                                                }
                                                                            }
                                                                            while(kt && soLanNhapSai<5);
                                                                        }
                                                                        else                    
                                                                            System.out.println("\nSố tiền chuyển không hợp lệ");
                                                                       
                                                                        if(soLanNhapSai>5)
                                                                        {
                                                                            taikhoan.khoaTaiKhoan(5,"");
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
                                                                    if(tienThanhToan<=tkThanhToan.getSodu())
                                                                    {
                                                                        taikhoan.TaoOTP();
                                                                        sc.nextLine();
                                                                        soLanNhapSai=1;
                                                                        do
                                                                        {
                                                                            System.out.printf("Nhập mã OTP để thanh toán lần %d/5:",soLanNhapSai);
                                                                            maOTP=sc.nextLine();
                                                                            if(taikhoan.kiemTraMaOTP(maOTP))
                                                                            {
                        
                                                                                tkThanhToan.rutTien(tienThanhToan);
                                                                                System.out.printf("Bạn đã thanh toán thành công %.0f đ",tienThanhToan);
                                                                                taikhoan.ThemLichSu("\nBạn đã thanh toán điện,nước,wifi,.. "+tienThanhToan+"00đ lúc "+LocalDateTime.now().format(formatter).toString());
                                                                                taikhoan.otpTask.cancel(true);
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
                                                                    System.out.println("\nLưu ý:Điều kiện vay là tài khoản của bạn không được vượt quá 500đ,số tiền vay không lớn hơn 5000000đ và chưa có khoản nợ ngân hàng trước đó mà chưa thanh toán");
                                                                    if(tkThanhToan.kiemtraVay())
                                                                    {
                                                                        double tienVay=xuLyDouble("Bạn muốn vay bao nhiêu:");
                
                                                                        if(tienVay>0 && tienVay<=5000000)
                                                                        {
                                                                            tkThanhToan.vayNo(tienVay);
                                                                            tkThanhToan.batDauGioiHanNo();
                                                                        }
                                                                        else
                                                                            System.out.println("\nSố tiền vay không hợp lệ!");
                                                                    }
                                                                    else
                                                                        System.out.println("\nTài khoản của bạn chưa đủ điều kiện để vay!");
                                                                }
                                                                break;
                                                                case 6:
                                                                {
                                                                   if(tkThanhToan.getSoNo()!=0)
                                                                        System.out.printf("\nSố dư tài khoản thanh toán của bạn là:%.0fđ | (Nợ %.0fđ.Thời gian còn lại để trả là:%.0f Ngày)\n",tkThanhToan.getSodu(),tkThanhToan.getSoNo(),tkThanhToan.ThoiGianConLai()); 
                                                                   else
                                                                        System.out.printf("\nSố dư tài khoản thanh toán của bạn là:%.0fđ\n",tkThanhToan.getSodu());  
                                                                
                                                                }break;
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
                                                    kt = true;        
                                                    while (kt) 
                                                    {
                                                        System.out.println("\n---------------💰 Tài khoản tiết kiệm 💰---------------");
                                                        System.out.println("1. Nạp tiền tài khoản tiết kiệm");
                                                        System.out.println("2. Rút tiền tài khoản tiết kiệm");
                                                        System.out.println("3. Chọn gửi tiết kiệm");
                                                        System.out.println("4. Xem số dư tài khoản tiết kiệm");
                                                        System.out.println("5. Xem thời gian còn lại có thể gửi hoặc rút");
                                                        System.out.println("0. Thoát tài khoản tiet kiem!");
                                                
                                                        int h = xuLyInt("Mời bạn nhập lựa chọn: ");
                                                        switch (h) {
                                                            case 1: 
                                                            { 
                                                                if (tkTietKiem.ktThoiHan())
                                                                {
                                                                    double tienNop =xuLyDouble("Nhập số tiền cần nạp: ");
                                                                    if (taikhoan.getTaiKhoanCon().keySet().iterator().next().getSodu() >= tienNop) 
                                                                    { 
                                                                        taikhoan.TaoOTP();
                                                                        sc.nextLine();
                                                                        soLanNhapSai=1;
                                                                        do
                                                                        {
                                                                            System.out.printf("Nhập mã OTP để thanh toán lần %d/5:",soLanNhapSai);
                                                                            maOTP=sc.nextLine();
                                                                            if(taikhoan.kiemTraMaOTP(maOTP))
                                                                            {
                        
                                                                                tkTietKiem.napTiep(tienNop);
                                                                                taikhoan.getTaiKhoanCon().keySet().iterator().next().rutTien(tienNop);
                                                                                taikhoan.otpTask.cancel(true);
                                                                                System.out.printf("Số tiền mới trong tài khoản tiết kiệm là: %.0f₫\n", tkTietKiem.getSodu());
                                                                                // taikhoan.ThemLichSu("\nBạn đã nộp tiền vào tài khoản tiết kiệm "+tienNop+"00đ lúc "+LocalDateTime.now().format(formatter).toString());
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
                                                                        System.out.println("Tài khoản chính không đủ để nạp!");
                                                                }
                                                                else 
                                                                    System.out.println("Thời hạn chưa đủ. Vui lòng đợi");  
                                                            }    
                                                            break;
                                                            case 2: 
                                                            {
                                                                if (tkTietKiem.ktThoiHan())
                                                                {
                                                                    double tienRut = xuLyDouble("Nhập số tiền cần rút về tài khoản chính: ");
                                                                    if (tienRut <= tkTietKiem.getSodu()) 
                                                                    {
                        
                                                                        taikhoan.TaoOTP();
                                                                        sc.nextLine();
                                                                        soLanNhapSai=1;
                                                                        do
                                                                        {
                                                                            System.out.printf("Nhập mã OTP để thanh toán lần %d/5:",soLanNhapSai);
                                                                            maOTP=sc.nextLine();
                                                                            if(taikhoan.kiemTraMaOTP(maOTP))
                                                                            {
                        
                                                                                tkTietKiem.rutTien(tienRut);
                                                                                taikhoan.getTaiKhoanCon().keySet().iterator().next().napTiep(tienRut);
                                                                                taikhoan.otpTask.cancel(true);
                                                                                System.out.printf("Bạn đã rút thành công %.0f đ\n", tienRut);
                                                                                // taikhoan.ThemLichSu("\nBạn đã rút "+tienRut+"00đ từ tài khoản tiết kiệm về tài khoản thanh toán lúc "+LocalDateTime.now().format(formatter).toString());
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
                                                                        System.out.println("Số tiền trong tài khoản không đủ để rút"); 
                                                                }
                                                                else 
                                                                    System.out.println("Thời hạn chưa đủ. Vui lòng đợi");  
                                                            }
                                                            break;
                                                            case 3: 
                                                            {
                                                                if(tkTietKiem.getSodu()>=500)
                                                                {
                                                                    boolean choosingTime = true;
                                                                    while (choosingTime) 
                                                                    {
                                                                        System.out.println("\nDanh mục gửi tiền tiết kiệm");
                                                                        System.out.println("1. Gửi tiết kiệm không kỳ hạn");
                                                                        System.out.println("2. Gửi tiết kiệm có kỳ hạn");
                                                                        System.out.println("0. Thoát!");
                                                    
                                                                        lc =xuLyInt("Mời bạn nhập lựa chọn: ");
                                                                        switch (lc)
                                                                        {
                                                                            case 1: 
                                                                            {
                                                                                if(tkTietKiem.ktThoiHan())
                                                                                {
                                                                                    System.out.println("\nBạn muốn thiết lập hay huỷ gửi tiết kiệm không thời hạn!");
                                                                                    System.out.println("1.Chọn gửi không kỳ hạn");
                                                                                    System.out.println("2.Chọn huỷ bỏ gửi không kỳ hạn(Nếu đã chon gửi không kỳ hạn)");

                                                                                    lc=xuLyInt("Mời bạn nhập lựa chọn:");
                                                                                    switch (lc) {
                                                                                        case 1 -> 
                                                                                        {
                                                                                            if(tkTietKiem.guiKhongKyHan()) 
                                                                                                taikhoan.ThemLichSu("\nBạn đã gửi tiết kiệm không thời hạn với lãi suất "+ tkTietKiem.getLaiSuatDaiHan() + " lúc "+LocalDateTime.now().format(formatter).toString());
                                                                                            else 
                                                                                                System.out.println("Đã có tác vụ gửi không kỳ hạn đang hoạt động.");
                                                                                        }
                                                                                        case 2 -> 
                                                                                        {
                                                                                            if(tkTietKiem.huyGuiKhongKyHan())
                                                                                                taikhoan.ThemLichSu("\nBạn đã HUỶ gửi tiết kiệm không thời hạn lúc "+LocalDateTime.now().format(formatter).toString());
                                                                                            else
                                                                                                System.out.println("\nHiện tại không có gửi không kỳ hạn nào để hủy.");
                                                                                                
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
                                                                                System.out.println("1. 3 Tháng(Lãi suất 0.1)!");
                                                                                System.out.println("2. 6 Tháng(Lãi suất 0.2)!");
                                                                                System.out.println("3. 12 Tháng(Lãi suất 0.4)!");
                                                                                System.out.println("4. 24 Tháng(Lãi suất 0.6)!");
                                                    
                                                                                System.out.print("Mời bạn nhập lựa chọn: ");
                                                                                int monthsChoice = xuLyInt("Mời bạn nhập lựa chọn:");

                                                                                int month=tkTietKiem.guiCoKyHan(monthsChoice);
                                                                                if(month!=0)
                                                                                    taikhoan.ThemLichSu("\nBạn đã gửi tiết kiệm có kì hạn là "+month+" tháng lúc "+LocalDateTime.now().format(formatter).toString());
                                                                                else 
                                                                                    System.out.println("\nBạn đã gửi thời hạn trước đó. Vui lòng đợi đến hạn để gửi tiếp.");   
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
                                                                else
                                                                    System.out.println("\nSố dư của bạn quá thấp.Vui lòng nạp thêm (sodu>=500) để gửi!");
                                                            }
                                                            break;
                                                            case 4:
                                                                System.out.printf("\nSố dư tài khoản tiết kiệm của bạn là: %.0fđ\n", tkTietKiem.getSodu());
                                                                break;
                                                
                                                            case 5: 
                                                            {
                                                                if (tkTietKiem.ktThoiHan()) 
                                                                    System.out.println("\nBạn đã xong thời hạn. Có thể rút tiền hoặc gửi thêm.");
                                                                else
                                                                    System.out.printf("\nThời gian còn lại của bạn là %.0f/%d Tháng!\n", tkTietKiem.ThoiGianConLai(), tkTietKiem.getSoThangGui());
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
                                                        kt=true;
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
                                                            exit=false;
                                                        }
                                                    }
                                                    else
                                                        System.out.println("Tài khoản của bạn đã bị khoá.Vui lòng chờ 5 phút");           
                                                }
                                                break;
                                                case 4:
                                                {   
                                                    System.out.printf("%23s %10s %20s %15s\n", "Số TK", "Chủ TK", "Số tiền trong TK", "Trạng thái");
                                                    taikhoan.hienThi();
                                                }break;
                                                case 5:
                                                    if(taikhoan.lichSu!="")
                                                        System.out.println(taikhoan.lichSu);
                                                    else
                                                        System.out.println("\nChưa có thông tin biến động");
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
                            case 3:
                            {
                                System.out.print("Nhập số tài khoản muốn khôi phục mật khẩu: ");
                                stk = sc.nextLine();
                                NganHang taikhoan = DS.searchAcount(stk);

                                if (taikhoan != null) 
                                {
                                    System.out.print("Nhập số điện thoại để đặt lại mật khẩu: ");
                                    SDT = sc.nextLine();
                                    dem=1;
                                    kt=true;
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
                                System.out.println("\nThoát chương trình.");
                                lap=false;
                                break;
                            default: 
                                System.out.println("\nError! Nhập lại.");
                                break;
                        }
                        if(!lap)
                                break;
                    }  
                }
                break;
                case 0:
                    {
                        System.out.println("\nCảm ơn quý khách đã dùng dịch vụ ngân hàng TinhBank👋!");
                        sc.close();
                        System.exit(0);
                    }
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;           
            }  
        } 
    }   
}
